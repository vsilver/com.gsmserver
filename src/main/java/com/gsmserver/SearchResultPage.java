package com.gsmserver;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    private final By productListItem = By.cssSelector(".pr-t_view");

    @Step
    public String getSearchResultTitle() {
        return $x("//h1[contains(text(),'Z3X Box Pro Samsung Activated Golden Edition without Cable Set')]").getText();
    }

    public String getFirstProductInfoTitle() {
        //Selenide.executeJavaScript() для работы с таблицей
        return $(productListItem).$("[title='Z3X Box Pro Samsung Activated Golden Edition without Cable Set']").getText();
    }

    public int getSearchResultListSize() {
        return $$(productListItem).size();
    }
}
