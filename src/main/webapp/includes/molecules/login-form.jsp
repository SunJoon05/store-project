<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 24/02/2026
  Time: 8:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<section class="login-section --flex-center" data-response="<%= request.getAttribute("resp")%>">
    <div class="login-card --flex-column-center --gap-large --padding-normal">

        <h2 class="login-card__title">Sign In</h2>

        <form class="login-form --flex-column-center --gap-normal" action="<%= request.getContextPath() %>/login" method="POST">
            <div class="login-form__field">
                <input class="login-form__input --input" type="email" id="email" name="email" placeholder="Email Address">
            </div>

            <div class="login-form__field">
                <input class="login-form__input --input" type="password" id="password" name="password" placeholder="Password">
            </div>

            <button class="login-form__button --rounded-button" type="submit">Log In</button>
        </form>

        <p class="login-card__footer">
            Don't have an account?
            <a class="login-link link--accent" href="<%= request.getContextPath() %>/register">Sign Up</a>
        </p>
    </div>
    <%@ include file="modal-error.jsp" %>
</section>
