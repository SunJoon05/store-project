<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<section class="user__profile-section --hidden" data-section-id="edit">
    <div class="edit-user">
        <h2 class="account-settings__title">Account Settings</h2>
        <form class="account-settings__form" action="<%= ApplicationConfiguration.getPath("app.root", "servlet.user.edit")%>" enctype="multipart/form-data" method="POST">
            <div class="account-settings__content">
                <div class="account-settings__form-information">

                    <input type="hidden" name="id" value="${id}">

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="first_name">First Name</label>
                        <%-- Si first_name es null, value queda vacío y aparece el placeholder --%>
                        <input class="account-settings__input" type="text"
                               name="first_name" id="first_name"
                               placeholder="${not empty first_name ? first_name : 'First name not provided'}">
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="last_name">Last Name</label>
                        <input class="account-settings__input" type="text"
                               name="last_name" id="last_name"
                               placeholder="${not empty last_name ? last_name : 'Last name not provided'}">
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="email">Email</label>
                        <input class="account-settings__input" type="email"
                               name="email" id="email"
                               placeholder="${not empty email ? email : 'Email not provided'}">
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="phone_number">Phone Number</label>
                        <input class="account-settings__input" type="text"
                               name="phone_number" id="phone_number"
                               placeholder="${not empty phone ? phone : 'Phone not provided'}">
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="birth_date">Birth Date</label>
                        <%-- type="date" ignora el placeholder en la mayoría de navegadores,
                             pero lo dejamos por consistencia y accesibilidad --%>
                        <input class="account-settings__input" type="date"
                               name="birth_date" id="birth_date"
                               placeholder="${not empty birth_date ? birth_date : 'Birth date not provided'}">
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="role">Role</label>
                        <select class="account-settings__input" name="role" id="role">
                            <option class="account-settings__input" value="1" ${role == "ADMIN" ? "selected" : ""}>ADMINISTRATOR</option>
                            <option class="4-settings__input" value="2" ${role == "SUPERVISOR" ? "selected" : ""}>SUPERVISOR</option>
                            <option class="account-settings__input" value="3" ${role == "CLIENT" ? "selected" : ""}>CLIENT</option>
                        </select>
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="state">State</label>
                        <label class="account-settings__toggle">
                            <%-- checked si el usuario está activo --%>
                            <input type="checkbox" name="state" id="state" ${state == "Active" ? "checked" : ""}>
                            <span class="account-settings__toggle-slider"></span>
                        </label>
                    </div>

                </div>
                <div class="account-settings__form-avatar">
                    <div class="account-settings__avatar-preview">
                        <img class="account-settings__avatar-img"
                             src="${not empty profile_picture ? profile_picture : ''}"
                             alt="Profile picture" id="avatar_preview">
                    </div>
                    <label class="account-settings__avatar-label" for="profile_picture">
                        Change Photo
                    </label>
                    <input class="account-settings__avatar-input" type="file"
                           name="profile_picture" id="profile_picture" accept="image/*">
                </div>
            </div>

            <button class="account-settings__submit --rounded-button" type="submit">Save Changes</button>
        </form>
    </div>
</section>