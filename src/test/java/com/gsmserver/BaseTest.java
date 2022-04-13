package com.gsmserver;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public abstract class BaseTest {

    static {
        Configuration.baseUrl = "https://gsmserver.com";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100";
        Configuration.browserSize = "1280x800";
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.fastSetValue = true;
        Configuration.driverManagerEnabled = true;
        Configuration.pageLoadStrategy = "normal";
        Configuration.reportsUrl  = "https://gsmserver.com";
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 100;
        //Configuration.screenshots = false;
        //Configuration.savePageSource = false;
        //Configuration.clickViaJs = true;
        //Configuration.headless = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }
}
