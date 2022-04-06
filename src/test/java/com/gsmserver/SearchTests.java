package com.gsmserver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


@ExtendWith({TextReportExtension.class})
public class SearchTests {

    @RegisterExtension
    TextReportExtension textReportExtension = new TextReportExtension();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        //SelenideLogger.addListener("allure", new AllureSelenide());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }


    @BeforeEach
    void openHomePage() {
        open("https://gsmserver.com/");
    }

    @Test
    void searchProductByTitleAndAddToCartTest() {


        var productName = "Z3X Box Pro Samsung Activated Golden Edition without Cable Set";
        var buttonText = "Cart";
        var productID = "870605";

        $("[name='searchword']").val("Z3X Box Pro Samsung Activated Golden Edition without Cable Set").pressEnter();
        $(".col-12").shouldHave(text(productName));

        findProductID(productID).$(".pr-t_view").shouldHave(text(productName)).click();
        findProductID(productID).$(".btn--add-to-cart").click();
        $x("//div[@class='col-md-1 d-md-flex justify-content-md-center']").click();

        $(".page_cart_container").shouldHave(text(buttonText));
        $$(".pdt_row").shouldHave(size(1));
        findProductID(productID).$(".pr-tiny_title").shouldHave(text(productName));
    }

    @Test
    void searchProductByTitleTest() {

        var productName = "Z3X Box Pro Samsung Activated Golden Edition without Cable Set";

        new HomePage().searchFor(productName);
        var actualSearchResultTitle = new SearchResultPage().getSearchResultTitle();

        Assertions.assertEquals(productName, actualSearchResultTitle);

    }

    private SelenideElement findProductID(String productID) {
        return $(Selectors.by("key", productID));
    }

    //@AfterEach

}
