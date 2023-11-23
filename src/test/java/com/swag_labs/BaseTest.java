package com.swag_labs;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.swag_labs.page.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    MainPage page;

    @BeforeEach
    public void setUp(){
        page = new MainPage();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.open(MainPage.URL);
    }
}
