<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 7/02/2026
  Time: 8:26 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<section class="header-top">
    <div class="content-spacing">
        <div class="header-top__content">
            <div class="location-store">
                <div class="location-store__title">
                    <span class="location-store__icon">
                        <svg id="Location" width="20" height="20" viewBox="0 0 24 24" fill="none"
                             xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd"
                                  d="M14.5103 10.7105C14.5103 9.3292 13.391 8.20996 12.0097 8.20996C10.6295 8.20996 9.51025 9.3292 9.51025 10.7105C9.51025 12.0907 10.6295 13.21 12.0097 13.21C13.391 13.21 14.5103 12.0907 14.5103 10.7105Z"
                                  stroke="#000000" stroke-width="1.5" stroke-linecap="round"
                                  stroke-linejoin="round"></path>
                            <path fill-rule="evenodd" clip-rule="evenodd"
                                  d="M11.9995 21C9.10148 21 4.5 15.9587 4.5 10.5986C4.5 6.40246 7.8571 3 11.9995 3C16.1419 3 19.5 6.40246 19.5 10.5986C19.5 15.9587 14.8985 21 11.9995 21Z"
                                  stroke="#000000" stroke-width="1.5" stroke-linecap="round"
                                  stroke-linejoin="round"></path>
                        </svg>
                    </span>
                    <span class="location-store__title">Store Location:</span>
                </div>
                <address class="location-store__address">
                    <span class="location-store__direction">Guadalajara de Buga</span>
                </address>
            </div>
            <div class="authentication-store">
                <a class="authentication-store__anchor" href="<%= request.getContextPath() %>/login">Sign In</a>
                <span>/</span>
                <a class="authentication-store__anchor" href="<%= request.getContextPath() %>/register">Sign Up</a>
            </div>
        </div>
    </div>
</section>