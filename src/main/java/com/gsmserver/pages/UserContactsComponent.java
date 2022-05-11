package com.gsmserver.pages;

import static com.codeborne.selenide.Selenide.$;

public class UserContactsComponent {

    public void fillPhoneNumber(String phoneNumberValue) {
        //$("[name*='phone']").parent().$("input[type='tel']").val(phoneNumberValue);
        $("input[name*='phone']").val(phoneNumberValue);
    }

}
