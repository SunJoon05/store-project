<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 7/02/2026
  Time: 8:26 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<section class="header-bottom --flex-center --padding-block-normal">
    <div class="content-spacing">
        <div class="header-bottom__content --flex-space-between">
            <nav class="header-bottom__navigation --flex-center --gap-normal">
                <a class="header-bottom__link" href="<%= ApplicationConfiguration.getPath("app.root", "view.home") %>">
                    <span class="header-bottom__text">
                        Home
                    </span>
                </a>

                <a class="header-bottom__link --flex-center --gap-narrowly" href="https://">
                    <span class="header-bottom__text">
                        Categories
                    </span>
                    <span class="header-bottom__icon --flex-center">
                        <!--?xml version="1.0" encoding="UTF-8"?-->
                        <svg id="Arrow - Down 2" width="16" height="16" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M19 8.5L15.5 12L14.625 12.875M12 15.5L5 8.5" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                        </svg>
                    </span>
                </a>

                <a class="header-bottom__link" href="https://">
                    <span class="header-bottom__text">
                        About Us
                    </span>
                </a>

                <a class="header-bottom__link" href="https://">
                    <span class="header-bottom__text">
                        Contact Us
                    </span>
                </a>
            </nav>
            <div class="header-main__phone --flex-center --gap-narrowly">
                <span class="header-bottom__icon">
                    <svg class="header-bottom__icon" id="Call" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M8.44994 15.7988C1.55294 8.89982 2.53294 5.74082 3.26094 4.72282C3.35394 4.55882 5.65594 1.11182 8.12494 3.13382C14.2509 8.17982 6.49494 7.46582 11.6389 12.6108C16.7849 17.7558 16.0709 9.99982 21.1159 16.1248C23.1379 18.5938 19.6909 20.8968 19.5279 20.9888C18.6369 21.6258 16.1059 22.4568 10.8649 18.0328"
                              stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                    </svg>
                </span>
                <span class="header-bottom__text">
                    +(57) 3154859665
                </span>
            </div>
        </div>
    </div>
</section>
