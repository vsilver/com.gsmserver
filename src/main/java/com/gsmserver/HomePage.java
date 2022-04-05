package com.gsmserver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePage {

    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
        sleep(3000);
    }
}
