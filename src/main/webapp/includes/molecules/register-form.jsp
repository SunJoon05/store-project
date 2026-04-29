<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 24/02/2026
  Time: 8:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<section class="register-section --flex-center" data-response="<%= request.getAttribute("resp")%>">
    <div class="register-card --flex-column-center --gap-large --padding-normal">

        <h2 class="register-card__title">Create Account</h2>

        <form class="register-form --flex-column-center --gap-normal" action="<%= request.getContextPath() %>/register" method="POST">
            <div class="register-form__field">
                <input class="register-form__input --input" type="email" id="email" name="email" placeholder="Email Address">
            </div>

            <div class="register-form__field">
                <input class="register-form__input --input" type="password" id="password" name="password" minlength="8" placeholder="Password">
            </div>

            <div class="register-form__field">
                <input class="register-form__input --input" type="password" id="confirm" name="confirm" minlength="8" placeholder="Confirm Password">
            </div>

            <button class="register-form__button --rounded-button" type="submit">Create Account</button>
        </form>

        <p class="register-card__footer">
            Already have an account?
            <a class="register-link link--accent" href="<%= ApplicationConfiguration.getPath("app.root", "servlet.login") %>">Sign In</a>
        </p>

    </div>
    <%@ include file="modal-error.jsp" %>
    <%@ include file="modal-success.jsp" %>
</section>
