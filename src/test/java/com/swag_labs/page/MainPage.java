package com.swag_labs.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static final String URL = "https://www.saucedemo.com/";
    private final SelenideElement emailField= $(By.id("user-name"));
    private final SelenideElement passField = $(By.id("password"));
    private final SelenideElement butLogin = $(By.id("login-button"));

   @Step("Авторизация {user},{password}")
    public MainPage logStdUser(String user, String password){
        emailField.setValue(user);
        passField.setValue(password);
        return this;
    }

    @Step("клик Войти")
    public MainPage pressEnter(){
        butLogin.click();
        return this;
    }
}
