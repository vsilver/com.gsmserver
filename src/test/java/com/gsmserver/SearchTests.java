package com.gsmserver;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


@ExtendWith({TextReportExtension.class, SoftAssertsExtension.class})
public class SearchTests extends BaseTest {

    @RegisterExtension
    TextReportExtension textReportExtension = new TextReportExtension();

    @AfterAll
    public static void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public static byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }

    @BeforeEach
    void openHomePage() {
        open("/");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
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
        String actualSearchResultTitleCut = actualSearchResultTitle.substring(8, 70);

        Assertions.assertEquals(productName, actualSearchResultTitleCut);

    }

    private SelenideElement findProductID(String productID) {
        return $(Selectors.by("key", productID));
    }

}
