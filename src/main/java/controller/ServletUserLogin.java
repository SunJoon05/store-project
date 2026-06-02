package controller;

import config.ApplicationConfiguration;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.entities.Market;
import model.entities.Permission;
import model.entities.Role;
import model.entities.User;
import repository.MarketRepo;
import repository.PermissionRepo;
import repository.UserRepo;
import service.AuthenticationService;
import service.MarketService;
import service.PermissionService;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class ServletUserLogin extends HttpServlet{

    private AuthenticationService authentication_service;
    private PermissionService permissions_service;
    private MarketService market_service;

    @Override
    public void init() {
        UserRepo USER_DAO = new UserRepo();
        PermissionRepo PERMISSIONS_DAO = new PermissionRepo();
        MarketRepo MARKETS_DAO = new MarketRepo();
        this.market_service = new MarketService(MARKETS_DAO);
        this.authentication_service = new AuthenticationService(USER_DAO);
        this.permissions_service = new PermissionService(PERMISSIONS_DAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            resp.sendRedirect(ApplicationConfiguration.getPath("app.root", "servlet.user.check"));
            return;
        }

        req.getRequestDispatcher(ApplicationConfiguration.getPath("dir.views", "dir.auth", "view.login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (!authentication_service.validateLoginInput(email, password)) {
            sendError(req, resp, "Invalid input format.");
            return;
        }

        try {
            User found = this.authentication_service.authenticationUser(email, password);
            Market market;

            if (found == null || found.getState() == false) {
                sendError(req, resp, "Invalid username or password.");
                return;
            }

            req.setAttribute("resp", "success");
            req.getSession(false);
            HttpSession session = req.getSession(true);

            found.setPasswordHash(null);
            List<Permission> permissions = this.permissions_service.userPermissionsById(found.getRole().getId());

            session.setAttribute("permissions", permissions);
            session.setAttribute("user", found);

            if (found.getRole() == Role.SUPERVISOR) {
                // lógica para obtener el mercado asociado
                market = this.market_service.getMarketBySupervisorId(found.getId());
                session.setAttribute("market", market);
            }

            resp.sendRedirect(ApplicationConfiguration.getPath("app.root", "servlet.user.check"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendError(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
        req.setAttribute("resp", "rejected");
        req.setAttribute("message", msg);
        req.getRequestDispatcher(ApplicationConfiguration.getPath("dir.views", "dir.auth", "view.login")).forward(req, resp);
    }

}