<%@ page contentType="text/html;charset=UTF-8"%>
<section class="user__profile-section --hidden" data-section-id="settings">
    <div class="account-settings">
        <div class="account-settings__form-wrapper">
            <h2 class="account-settings__title">Account Settings</h2>
            <form class="account-settings__form" action="<%= request.getContextPath() %>/update-user-data" enctype="multipart/form-data" method="POST">
                <div class="account-settings__content">
                    <div class="account-settings__form-information">
                        <div class="account-settings__field">
                            <label class="account-settings__label" for="first_name">First Name</label>
                            <input class="account-settings__input" type="text" name="first_name" id="first_name" placeholder="Enter your first name">
                        </div>

                        <div class="account-settings__field">
                            <label class="account-settings__label" for="last_name">Last Name</label>
                            <input class="account-settings__input" type="text" name="last_name" id="last_name" placeholder="Enter your last name">
                        </div>

                        <div class="account-settings__field">
                            <label class="account-settings__label" for="email">Email</label>
                            <input class="account-settings__input" type="email" name="email" id="email" placeholder="Enter your email">
                        </div>

                        <div class="account-settings__field">
                            <label class="account-settings__label" for="phone_number">Phone Number</label>
                            <input class="account-settings__input" type="text" name="phone_number" id="phone_number" placeholder="Enter your phone number">
                        </div>

                        <div class="account-settings__field">
                            <label class="account-settings__label" for="birth_date">Birth Date</label>
                            <input class="account-settings__input" type="date" name="birth_date" id="birth_date">
                        </div>
                    </div>
                    <div class="account-settings__form-avatar">
                        <div class="account-settings__avatar-preview">
                            <img class="account-settings__avatar-img" src="${profile_picture}" alt="Foto de perfil" id="avatar_preview">
                        </div>
                        <label class="account-settings__avatar-label" for="profile_picture">
                            Change Photo
                        </label>
                        <input class="account-settings__avatar-input" type="file" name="profile_picture" id="profile_picture" accept="image/*">
                    </div>
                </div>

                <button class="account-settings__submit --rounded-button" type="submit">Save Changes</button>
            </form>
        </div>
        <div class="account-settings__avatar-wrapper">
        </div>
        <div class="account-settings__danger-zone">
        </div>
    </div>
</section>