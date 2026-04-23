<%@ page contentType="text/html;charset=UTF-8"%>
<section class="user__profile-section --visible" data-section-id="information">
    <div class="account-information">
        <div class="user__profile-avatar">
            <div class="user__profile-avatar-wrapper">
                <img src="${profile_picture}" alt="Foto de perfil">
            </div>
            <span class="user__profile-name">
                ${first_name}
            </span>
            <span class="user__profile-role">
                ${role}
            </span>
            <span class="user__profile-status">
                ${state}
            </span>
        </div>
        <div class="user__profile-details">
            <span class="user__profile-name --label">
                FULL NAME
            </span>
            <span class="user__profile-name --user__detail">
                ${full_name}
            </span>
            <span class="user__profile-email --label">
                EMAIL ADDRESS
            </span>
            <span class="user__profile-email --user__detail">
                ${email}
            </span>
            <span class="user__profile-register-date --label">
                REGISTER DATE
            </span>
            <span class="user__profile-register-date --user__detail">
                ${register_date}
            </span>
            <span class="user__profile-last-login --label">LAST LOGIN</span>
            <span class="user__profile-last-login --user__detail">
                ${last_login}
            </span>
            <span class="user__profile-age --label">AGE</span>
            <span class="user__profile-age --user__detail">
                ${age}
            </span>
        </div>
    </div>
</section>
