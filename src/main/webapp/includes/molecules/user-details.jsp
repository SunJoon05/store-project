<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 18/05/2026
  Time: 1:03 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="user__profile-section --hidden" data-section-id="details">
    <div class="user-details">
        <div class="user__details-header">
            <h2 class="user__details-header-title">User Details</h2>
            <a href="http://">Back to List</a>
        </div>
        <div class="user__details-body">
            <div class="user__details-container">
                <h2 class="user__details-content-title">basic information</h2>
                <div class="user__details-content">

                    <div class="user__details_group">
                        <span class="user__details-label">name</span>
                        <span class="user__details-value">
                            ${full_name}
                        </span>
                    </div>

                    <div class="user__details_group">
                        <span class="user__details-label">
                            email
                        </span>
                        <span class="user__details-value">
                            ${email}
                        </span>
                    </div>

                    <div class="user__details_group">
                        <span class="user__details-label">phone</span>
                        <span class="user__details-value">
                            ${phone}
                        </span>
                    </div>
                </div>
            </div>

            <div class="user__details-container">
                <h2 class="user__details-content-title">sensitive information</h2>
                <div class="user__details-content --sensitive">

                    <div class="user__details-sensitive">

                        <div>
                            <div class="user__details_group">
                        <span class="user__details-label">
                            uuid
                        </span>
                                <span class="user__details-value">
                                    ${id}
                                </span>
                            </div>

                            <div class="user__details_group">
                        <span class="user__details-label">
                            state
                        </span>
                                <span class="user__details-value">
                                    ${state}
                                </span>
                            </div>

                            <div class="user__details_group">
                                <span class="user__details-label">user type</span>
                                <span class="user__details-value">
                                    ${role}
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="user__details-sensitive">
                        <div>
                            <div class="user__details_group">
                        <span class="user__details-label">
                            birth date
                        </span>
                                <span class="user__details-value">
                                    ${birth_date}
                                </span>
                            </div>

                            <div class="user__details_group">
                        <span class="user__details-label">
                            last login
                        </span>
                                <span class="user__details-value">
                                    ${last_login}
                                </span>
                            </div>

                            <div class="user__details_group">
                                <span class="user__details-label">register date</span>
                                <span class="user__details-value">
                                    ${register_date}
                                </span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>
