package com.gsmserver;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @Test
    void searchProductByTitle() {
        open("https://gsmserver.com/");

        var searchQuery = "Z3X Box Pro Samsung Activated Golden Edition without Cable Set";
        var buttonText = "Cart";
        var productID = "870605";

        $("[name='searchword']").val("Z3X Box Pro Samsung Activated Golden Edition without Cable Set").pressEnter();
        $(".col-12").shouldHave(text(searchQuery));

        $(Selectors.by("key", productID)).$(".pr-t_view").shouldHave(text(searchQuery)).click();
        $(Selectors.by("key", productID)).$(".btn--add-to-cart").click();
        $(By.xpath("//div[@class='col-md-1 d-md-flex justify-content-md-center']")).click();

        $(".page_cart_container").shouldHave(text(buttonText));
        $(".pr-tiny_title").shouldHave(text(searchQuery));
        sleep(5000);
    }
}
