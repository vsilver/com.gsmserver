package com.gsmserver;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePage {

    @Step
    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
        sleep(3000);
    }
}
