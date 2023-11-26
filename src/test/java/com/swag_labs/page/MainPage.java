package com.swag_labs.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static final String URL = "https://www.saucedemo.com/";
    private final SelenideElement emailField= $(By.id("user-name"));
    private final SelenideElement passField = $(By.id("password"));
    private final SelenideElement butLogin = $(By.id("login-button"));
    private final SelenideElement titleLogoSite = $(By.className("app_logo"));

   @Step("Авторизация")
    public MainPage logStdUser(String strings, String password){
        emailField.setValue(strings);
        passField.setValue(password);
        return this;
    }

    @Step("клик Войти")
    public MainPage pressEnter(){
        butLogin.click();
        return this;
    }

    @Step("Проверка надписи названия сайта")
    public String isOpenLogin () {
        return  titleLogoSite.getText();
    }

}
