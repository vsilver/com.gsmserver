package com.gsmserver;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    @Step
    public String getSearchResultTitle() {
        //return $(".col-12").getText();
        return $x("//h1[contains(text(),'Z3X Box Pro Samsung Activated Golden Edition without Cable Set')]").getText();
    }
}
