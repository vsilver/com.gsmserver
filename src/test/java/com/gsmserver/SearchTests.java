package com.gsmserver;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @BeforeEach
    void  openHomePage(){
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
    void searchProductByTitleTest(){

        var productName = "Z3X Box Pro Samsung Activated Golden Edition without Cable Set";

        new  HomePage().searchFor(productName);
        var actualSearchResultTitle = new SearchResultPage().getSearchResultTitle();

        Assertions.assertEquals(productName, actualSearchResultTitle);

    }

    private SelenideElement findProductID(String productID) {
        return $(Selectors.by("key", productID));
    }
}
