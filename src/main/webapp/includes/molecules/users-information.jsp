<%@ page import="util.HtmlBuilder" %>
<%@ page import="util.Pagination" %>
<%@ page import="model.entities.User" %>
<%@ page import="service.UserService" %>
<%@ page import="repository.UserRepo" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
    UserRepo USER_DAO = new UserRepo();
    UserService user_service = new UserService(USER_DAO);
    String page_param = request.getParameter("page");
    int current_page = 1;

    if (page_param != null ) {
        current_page = Integer.parseInt(page_param);
    }

    int size = 10;
    int offset = (current_page - 1) * size;
    Pagination users_pagination = user_service.UsersPagination(offset);
%>
<section class="user__profile-section --hidden" data-section-id="management">
    <div class="users-management">
        <div class="users__management-header">
            <h2 class="users__management-title">Users Management</h2>
            <div class="users__management-options">
                <a class="users__management-link">
                    <svg  xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                          fill="currentColor" viewBox="0 0 24 24" >
                        <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                        <path d="M20 2H4c-.55 0-1 .45-1 1v2c0 .22.07.43.2.6L9 13.33V21a1 1 0 0 0 1 1c.15 0 .31-.04.45-.11l4-2A1 1 0 0 0 15 19v-5.67l5.8-7.73c.13-.17.2-.38.2-.6V3c0-.55-.45-1-1-1m-1 2.67-5.8 7.73c-.13.17-.2.38-.2.6v5.38l-2 1V13c0-.22-.07-.43-.2-.6L5 4.67V4h14z"></path>
                    </svg>
                </a>
                <a class="users__management-link">
                    <svg  xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                          fill="currentColor" viewBox="0 0 24 24" >
                        <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                        <path d="M3 13h8v8h2v-8h8v-2h-8V3h-2v8H3z"></path>
                    </svg>
                </a>
            </div>
        </div>
        <table class="users__management-table">
            <thead class="users__management-head">
                <tr class="users__management-row">
                    <th class="users__management-head">##</th>
                    <th class="users__management-head">UUID</th>
                    <th class="users__management-head">Full Name</th>
                    <th class="users__management-head">Email</th>
                    <th class="users__management-head">Role</th>
                    <th class="users__management-head">View</th>
                    <th class="users__management-head">State</th>
                    <th class="users__management-head">Actions</th>
                </tr>
            </thead>

            <%for (int i = 0; i < users_pagination.content.size(); i++) {%>
                <% Object u = users_pagination.content.get(i);%>
                <%= HtmlBuilder.renderUserRow((User) u, offset + i + 1, ApplicationConfiguration.getPath("app.root", "servlet.details")) %>
            <%} %>
        </table>

        <div class="users__management-pagination">
            <%for (int i = 0; i < users_pagination.total_pages; i++) {%>
                <a class="users__management-pagination-item" href="?section=management&page=<%=i + 1%>"><%=i + 1%></a>
            <%}%>
        </div>
    </div>
</section>
