<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 31/05/2026
  Time: 10:39 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="user__profile-section --hidden" data-section-id="create">
    <div class="edit-user">
        <h2 class="account-settings__title">Create New User</h2>
        <form class="account-settings__form" action="<%= ApplicationConfiguration.getPath("app.root", "servlet.user.create")%>" enctype="multipart/form-data" method="POST">
            <div class="account-settings__content">
                <div class="account-settings__form-information">

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="first_name">First Name</label>
                        <input class="account-settings__input" type="text"
                               name="first_name" id="first_name"
                               placeholder="Enter first name" required>
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="last_name">Last Name</label>
                        <input class="account-settings__input" type="text"
                               name="last_name" id="last_name"
                               placeholder="Enter last name" required>
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="email">Email</label>
                        <input class="account-settings__input" type="email"
                               name="email" id="email"
                               placeholder="example@mail.com" required>
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="password">Password</label>
                        <input class="account-settings__input" type="password"
                               name="password" id="password"
                               placeholder="Create a secure password" required>
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="phone_number">Phone Number</label>
                        <input class="account-settings__input" type="text"
                               name="phone_number" id="phone_number"
                               placeholder="e.g. 3154568595">
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="birth_date">Birth Date</label>
                        <input class="account-settings__input" type="date"
                               name="birth_date" id="birth_date">
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="role">Role</label>
                        <select class="account-settings__input" name="role" id="role" required>
                            <option class="account-settings__input" value="" disabled selected>Select a role</option>
                            <option class="account-settings__input" value="1">ADMINISTRATOR</option>
                            <option class="account-settings__input" value="2">SUPERVISOR</option>
                            <option class="account-settings__input" value="3">CLIENT</option>
                        </select>
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="state">State (Active by default)</label>
                        <label class="account-settings__toggle">
                            <%-- Por defecto viene activado (checked) al crear un usuario nuevo --%>
                            <input type="checkbox" name="state" id="state" value="Active" checked>
                            <span class="account-settings__toggle-slider"></span>
                        </label>
                    </div>

                </div>
                <div class="account-settings__form-avatar">
                    <div class="account-settings__avatar-preview">
                        <%-- Imagen por defecto para cuando no hay foto cargada aún --%>
                        <img class="account-settings__avatar-img"
                             src="${pageContext.request.contextPath}/assets/images/default-avatar.png"
                             alt="Default profile picture" id="avatar_preview">
                    </div>
                    <label class="account-settings__avatar-label" for="profile_picture">
                        Upload Photo
                    </label>
                    <input class="account-settings__avatar-input" type="file"
                           name="profile_picture" id="profile_picture" accept="image/*">
                </div>
            </div>

            <button class="account-settings__submit --rounded-button" type="submit">Create User</button>
        </form>
    </div>
</section>
