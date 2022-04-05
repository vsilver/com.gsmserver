package com.gsmserver;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchResultPage {
    public String getSearchResultTitle() {
        return $(".col-12").shouldBe(Condition.visible).getText();
    }
}
