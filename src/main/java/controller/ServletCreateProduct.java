package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.Market;
import model.entities.Product;
import repository.ProductRepo;
import service.ProductService;

import java.io.IOException;
import jakarta.servlet.http.*;

@WebServlet("/create-product")
public class ServletCreateProduct extends HttpServlet {

    private ProductService product_service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ProductRepo PRODUCT_DAO = new ProductRepo();
        this.product_service = new ProductService(PRODUCT_DAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Product product = new Product();
        HttpSession session = req.getSession(false);
        Market market = (Market) session.getAttribute("market");

        try {
            product.setName(req.getParameter("name"));
            product.setPrice(Double.parseDouble(req.getParameter("price")));
            product.setMarket(market);

            this.product_service.insertProduct(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
