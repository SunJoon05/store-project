<%@ page import="config.ApplicationConfiguration" %><%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 2/06/2026
  Time: 2:22 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<section class="user__profile-section --hidden" data-section-id="create-product">
    <div class="edit-user">
        <h2 class="account-settings__title">Create New Product</h2>

        <form class="account-settings__form" action="<%= ApplicationConfiguration.getPath("app.root", "servlet.product.create")%>" method="POST">
            <div class="account-settings__content">
                <div class="account-settings__form-information">

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="product_name">Product Name</label>
                        <input class="account-settings__input" type="text"
                               name="name" id="product_name"
                               placeholder="Enter product name" required>
                    </div>

                    <div class="account-settings__field">
                        <label class="account-settings__label" for="product_price">Price</label>
                        <input class="account-settings__input" type="number"
                               step="0.01" name="price" id="product_price"
                               placeholder="0.00" required>
                    </div>

                </div>
            </div>

            <button class="account-settings__submit --rounded-button" type="submit">Save Product</button>
        </form>
    </div>
</section>