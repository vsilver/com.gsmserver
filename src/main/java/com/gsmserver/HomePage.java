package com.gsmserver;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.By.cssSelector;

public class HomePage {

    @Step
    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
        sleep(3000);
    }

    public static class  DropdownAccount {

        private By
                dropDownAccount = cssSelector("[space*='component/account/dropdown']"),
                loginDropDownItem = cssSelector("[name='login']"),
                registrationDropDownItem = cssSelector("[name='registration']");

        public void openDropdownPopup(){
            $(dropDownAccount).click();
        }

        public void openLoginPopup(){
            $(loginDropDownItem).click();
        }

        public void openRegistrationPopup(){
            $(registrationDropDownItem).click();
        }

    }
}
