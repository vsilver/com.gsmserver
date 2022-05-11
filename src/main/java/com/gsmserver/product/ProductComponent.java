package com.gsmserver.product;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductComponent {

    public SelenideElement findProductID(String productID) {
        return $(Selectors.by("key", productID));
    }
}
