<%@ page import="service.PermissionService" %>
<%@ page import="model.entities.Permission" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<section class="navigation-profile__section --flex-column-left  --gap-normal">
    <h2 class="navigation-profile__title">Navigation</h2>
    <nav class="navigation-profile__nav --flex-column-left">
        <a href="<%= ApplicationConfiguration.getPath("app.root", "servlet.user.check") %>?section=information" class="navigation-profile__option --flex-center --gap-normal" data-option="information">
            <span class="navigation-profile__icon">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                     fill="currentColor" viewBox="0 0 24 24">
                    <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                    <path d="M20 11h-6c-.55 0-1 .45-1 1v8c0 .55.45 1 1 1h6c.55 0 1-.45 1-1v-8c0-.55-.45-1-1-1m-1 8h-4v-6h4zm-9-4H4c-.55 0-1 .45-1 1v4c0 .55.45 1 1 1h6c.55 0 1-.45 1-1v-4c0-.55-.45-1-1-1m-1 4H5v-2h4zM20 3h-6c-.55 0-1 .45-1 1v4c0 .55.45 1 1 1h6c.55 0 1-.45 1-1V4c0-.55-.45-1-1-1m-1 4h-4V5h4zm-9-4H4c-.55 0-1 .45-1 1v8c0 .55.45 1 1 1h6c.55 0 1-.45 1-1V4c0-.55-.45-1-1-1m-1 8H5V5h4z"></path>
                </svg>
            </span>
            <span class="navigation-profile__description">Information</span>
        </a>
        <a class="navigation-profile__option --flex-center --gap-normal" data-option="order-history">
            <span class="navigation-profile__icon">
                <svg  xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                      fill="currentColor" viewBox="0 0 24 24" >
                    <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                    <path d="M19.07 4.93a9.9 9.9 0 0 0-3.18-2.14A9.95 9.95 0 0 0 12 2v2c1.08 0 2.13.21 3.11.63.95.4 1.81.98 2.54 1.71s1.31 1.59 1.72 2.54c.42.99.63 2.03.63 3.11s-.21 2.13-.63 3.11c-.4.95-.98 1.81-1.72 2.54-.17.17-.34.32-.52.48L15 15.99v6h6l-2.45-2.45c.18-.15.36-.31.52-.48.92-.92 1.64-1.99 2.14-3.18.52-1.23.79-2.54.79-3.89s-.26-2.66-.79-3.89a9.9 9.9 0 0 0-2.14-3.18ZM4.93 19.07c.92.92 1.99 1.64 3.18 2.14 1.23.52 2.54.79 3.89.79v-2a7.9 7.9 0 0 1-3.11-.63c-.95-.4-1.81-.98-2.54-1.71s-1.31-1.59-1.72-2.54c-.42-.99-.63-2.03-.63-3.11s.21-2.13.63-3.11c.4-.95.98-1.81 1.72-2.54.17-.17.34-.32.52-.48L9 8.01V2H3l2.45 2.45c-.18.15-.36.31-.52.48-.92.92-1.64 1.99-2.14 3.18C2.27 9.34 2 10.65 2 12s.26 2.66.79 3.89c.5 1.19 1.22 2.26 2.14 3.18"></path>
                </svg>
            </span>
            <span class="navigation-profile__description">
                Order History
            </span></a>
        <a class="navigation-profile__option --flex-center --gap-normal">
            <span class="navigation-profile__icon">
                <svg  xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                      fill="currentColor" viewBox="0 0 24 24" >
                    <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                    <path d="M11.29 20.66c.2.2.45.29.71.29s.51-.1.71-.29l7.5-7.5c2.35-2.35 2.35-6.05 0-8.41-2.3-2.28-5.85-2.35-8.21-.2-2.36-2.15-5.91-2.09-8.21.2-2.35 2.36-2.35 6.06 0 8.41zM5.21 6.16C6 5.38 7 4.99 8.01 4.99s2.01.39 2.79 1.17l.5.5c.39.39 1.02.39 1.41 0l.5-.5c1.56-1.56 4.02-1.56 5.59 0 1.56 1.57 1.56 4.02 0 5.58l-6.79 6.79-6.79-6.79a3.91 3.91 0 0 1 0-5.58Z"></path>
                </svg>
            </span>
            <span class="navigation-profile__description">
                Wishlist
            </span></a>
        <a class="navigation-profile__option --flex-center --gap-normal">
            <span class="navigation-profile__icon">
                <svg  xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                      fill="currentColor" viewBox="0 0 24 24" >
                    <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                    <path d="M8 18a2 2 0 1 0 0 4 2 2 0 1 0 0-4m9 0a2 2 0 1 0 0 4 2 2 0 1 0 0-4M6 15c0 .55.45 1 1 1h12c.46 0 .86-.31.97-.76l2-8c.07-.3 0-.62-.18-.86S21.31 6 21 6H8V3c0-.55-.45-1-1-1H2v2h4zm2-7h11.72l-1.5 6H8z"></path>
                </svg>
            </span>
            <span class="navigation-profile__description">
                Shopping Cart
            </span></a>
        <a class="navigation-profile__option --flex-center --gap-normal" data-option="settings">
            <span class="navigation-profile__icon">
                <svg  xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                      fill="currentColor" viewBox="0 0 24 24" >
                    <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                    <path d="M12 8c-2.21 0-4 1.79-4 4s1.79 4 4 4 4-1.79 4-4-1.79-4-4-4m0 6c-1.08 0-2-.92-2-2s.92-2 2-2 2 .92 2 2-.92 2-2 2"></path><path d="m20.42 13.4-.51-.29c.05-.37.08-.74.08-1.11s-.03-.74-.08-1.11l.51-.29c.96-.55 1.28-1.78.73-2.73l-1-1.73a2.006 2.006 0 0 0-2.73-.73l-.53.31c-.58-.46-1.22-.83-1.9-1.11v-.6c0-1.1-.9-2-2-2h-2c-1.1 0-2 .9-2 2v.6c-.67.28-1.31.66-1.9 1.11l-.53-.31c-.96-.55-2.18-.22-2.73.73l-1 1.73c-.55.96-.22 2.18.73 2.73l.51.29c-.05.37-.08.74-.08 1.11s.03.74.08 1.11l-.51.29c-.96.55-1.28 1.78-.73 2.73l1 1.73c.55.95 1.77 1.28 2.73.73l.53-.31c.58.46 1.22.83 1.9 1.11v.6c0 1.1.9 2 2 2h2c1.1 0 2-.9 2-2v-.6a8.7 8.7 0 0 0 1.9-1.11l.53.31c.95.55 2.18.22 2.73-.73l1-1.73c.55-.96.22-2.18-.73-2.73m-2.59-2.78c.11.45.17.92.17 1.38s-.06.92-.17 1.38a1 1 0 0 0 .47 1.11l1.12.65-1 1.73-1.14-.66c-.38-.22-.87-.16-1.19.14-.68.65-1.51 1.13-2.38 1.4-.42.13-.71.52-.71.96v1.3h-2v-1.3c0-.44-.29-.83-.71-.96-.88-.27-1.7-.75-2.38-1.4a1.01 1.01 0 0 0-1.19-.15l-1.14.66-1-1.73 1.12-.65c.39-.22.58-.68.47-1.11-.11-.45-.17-.92-.17-1.38s.06-.93.17-1.38A1 1 0 0 0 5.7 9.5l-1.12-.65 1-1.73 1.14.66c.38.22.87.16 1.19-.14.68-.65 1.51-1.13 2.38-1.4.42-.13.71-.52.71-.96v-1.3h2v1.3c0 .44.29.83.71.96.88.27 1.7.75 2.38 1.4.32.31.81.36 1.19.14l1.14-.66 1 1.73-1.12.65c-.39.22-.58.68-.47 1.11Z"></path>
                </svg>
            </span>
            <span class="navigation-profile__description">
                Settings
            </span>
        </a>
        <a href="<%= ApplicationConfiguration.getPath("app.root", "servlet.user.check") %>?section=management" class="<%= PermissionService.can(request.getSession(false), Permission.USERS_HANDLE) ? "--show" : "--hidden" %> navigation-profile__option --flex-center --gap-normal" data-option="management">
            <span class="navigation-profile__icon">
                <svg  xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                      fill="currentColor" viewBox="0 0 24 24" >
                    <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                    <path d="M20 9h-8V2c0-.45-.3-.85-.74-.97s-.9.07-1.12.46l-7 12.01c-.18.31-.18.69 0 1s.51.5.87.5h8v7c0 .45.3.85.74.97.09.02.17.03.26.03.35 0 .68-.18.86-.5l7-12c.18-.31.18-.69 0-1S20.36 9 20 9m-6 9.3V14c0-.55-.45-1-1-1H5.74L10 5.7V10c0 .55.45 1 1 1h7.26z"></path>
                </svg>
            </span>
            <span class="navigation-profile__description">
                Management
            </span>
        </a>
        <a class="<%= PermissionService.can(request.getSession(false), Permission.POSTS_HANDLE) ? "--show" : "--hidden" %> navigation-profile__option --flex-center --gap-normal">
            <span class="navigation-profile__icon">
                <svg  xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                      fill="currentColor" viewBox="0 0 24 24" >
                    <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                    <path d="M21.93 7.66c-.02-.05-.04-.11-.07-.16a1 1 0 0 0-.06-.08c-.03-.04-.06-.09-.1-.12-.03-.03-.06-.04-.09-.07-.04-.03-.07-.06-.11-.09h-.01l-9-5.01a.99.99 0 0 0-.97 0l-9.01 5H2.5c-.04.02-.07.06-.11.09a.6.6 0 0 0-.09.07c-.04.04-.07.08-.1.12-.02.03-.05.05-.06.08-.03.05-.05.1-.07.16-.01.03-.03.05-.03.08-.02.08-.04.17-.04.26v8c0 .36.2.7.51.87l9 5 .15.06c.03.01.06.03.09.03a1.1 1.1 0 0 0 .5 0c.03 0 .06-.02.09-.03.05-.02.1-.03.15-.06l9-5c.32-.18.51-.51.51-.87v-8c0-.09-.01-.18-.04-.26 0-.03-.02-.05-.03-.08ZM12 4.15l6.94 3.86-2.44 1.36-6.94-3.86zm-4.5 2.5 6.94 3.86L12 11.87 5.06 8.01zM4 9.71l7 3.89v5.71l-7-3.89zm16 5.71-7 3.89V13.6l2.5-1.39v3.21l2-1.11V11.1L20 9.71z"></path>
                </svg>
            </span>
            <span class="navigation-profile__description">
                Posts
            </span>
        </a>
        <a href="<%= ApplicationConfiguration.getPath("app.root", "servlet.user.close") %>" class="navigation-profile__option --flex-center --gap-normal">
            <span class="navigation-profile__icon">
                <svg  xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                      fill="currentColor" viewBox="0 0 24 24" >
                    <!--Boxicons v3.0.8 https://boxicons.com | License  https://docs.boxicons.com/free-->
                    <path d="M4 4h2v16H4zm8.29 2.71 4.3 4.29H8v2h8.59l-4.3 4.29 1.42 1.42 6.7-6.71-6.7-6.71z"></path>
                </svg>
            </span>
            <span class="navigation-profile__description">
                Log-Out
            </span>
        </a>
    </nav>
</section>
