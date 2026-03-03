<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 25/02/2026
  Time: 7:22 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<section class="modal-error__card --flex-column-center --gap-large --padding-normal --hidden">
  <span class="modal-error__icon --flex-center --padding-narrowly">
    <svg id="Danger" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M12.0056 20.4368H19.1971C20.7791 20.4368 21.7721 18.7268 20.9861 17.3528L13.8001 4.78781C13.0091 3.40481 11.0151 3.40381 10.2231 4.78681L3.02509 17.3518C2.23909 18.7258 3.23109 20.4368 4.81409 20.4368H7.50012" stroke="#fff" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
    <path d="M12.0024 13.4148V10.3148" stroke="#fff" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
    <path d="M11.995 16.5H12.005" stroke="#fff" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
    </svg>
  </span>
  <h2 class="modal-error__title">Invalid Credentials</h2>
  <p class="modal-error__message">
    Check the credentials and enter them correctly
  </p>
  <button class="modal-error__button modal-close">Accept</button>
</section>
