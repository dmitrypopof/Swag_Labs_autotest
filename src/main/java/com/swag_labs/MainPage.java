package com.swag_labs;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static final String URL = "https://www.saucedemo.com/";
    private final SelenideElement emailField= $(By.id("user-name"));
    private final SelenideElement passField = $(By.id("password"));
    private final SelenideElement butLogin = $(By.id("login-button"));

    public MainPage logStdUser(String user, String password){
        emailField.setValue(user);
        passField.setValue(password);
        return this;
    }

    public MainPage pressEnter(){
        butLogin.click();
        return this;
    }
}
