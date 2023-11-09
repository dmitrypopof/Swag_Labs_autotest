package com.swag_labs;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Test_std_Users {

    @Tag("smoke")
    @Test
    public void openPageStart(){
        open("https://www.saucedemo.com/");
        $(byId("user-name")).setValue("standard_user");
        $(byId("password")).setValue("secret_sauce");
        $(byId("login-button")).click();
    }

    @Tag("regress")
    @Test
    public void openMainPageStart(){
        MainPage page =
        open("https://www.saucedemo.com/", MainPage.class);

        page.logStdUser("standard_user","secret_sauce");
        page.pressEnter();

    }
}
