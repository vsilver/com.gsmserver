package com.gsmserver;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductBlock {

    public SelenideElement findProductID(String productID) {
        return $(Selectors.by("key", productID));
    }
}
