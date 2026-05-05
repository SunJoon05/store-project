<%@ page import="mapper.HtmlBuilder" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<section class="user__profile-section --hidden" data-section-id="management">
    <div class="users-management">
        <h2 class="users__management-title">Users Management</h2>
        <table class="users__management-table">
            <thead class="users__management-head">
                <tr class="users__management-row">
                    <th class="users__management-head">Id</th>
                    <th class="users__management-head">Full Name</th>
                    <th class="users__management-head">Email</th>
                    <th class="users__management-head">Phone</th>
                    <th class="users__management-head">Register Date</th>
                    <th class="users__management-head">Role</th>
                    <th class="users__management-head">State</th>
                    <th class="users__management-head">Actions</th>
                </tr>
            </thead>

            <tbody class="users__management-body">
                <%
                    HtmlBuilder builder = new HtmlBuilder();
                    for (String row: builder.buildTableRows()) {%>
                    <%= row %>
                    <%}
                %>
            </tbody>

        </table>
    </div>
</section>
