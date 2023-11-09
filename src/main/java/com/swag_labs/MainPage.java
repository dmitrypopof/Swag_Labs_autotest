package com.swag_labs;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.ID,using = "user-name")
    private SelenideElement emailField;

    @FindBy(how = How.ID,using = "password")
    private SelenideElement passField;

    @FindBy(how = How.ID,using = "login-button")
    private SelenideElement butLogin;

    public void logStdUser(String user, String password){
        emailField.setValue(user);
        passField.setValue(password);
    }

    public void pressEnter(){
        butLogin.click();
    }
}
