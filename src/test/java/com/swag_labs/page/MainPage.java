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
    private final SelenideElement addToCartSauceLabsBackpack = $(By.id("add-to-cart-sauce-labs-backpack"));
    private final SelenideElement backToProductsBut = $(By.id("back-to-products"));
    private final SelenideElement basketButton = $(By.id("shopping_cart_container"));
    private final SelenideElement checkoutButton = $(By.id("checkout"));

    private final SelenideElement firstNameFieldInf = $(By.id("first-name"));
    private final SelenideElement lasttNameFieldInf = $(By.id("last-name"));
    private final SelenideElement postCodeFieldInf = $(By.id("postal-code"));
    private final SelenideElement continueInf = $(By.id("continue"));

    private final SelenideElement finishButton = $(By.id("finish"));
   @Step("Authorization")
    public MainPage logStdUser(String strings, String password){
        emailField.setValue(strings);
        passField.setValue(password);
        return this;
    }

    @Step("click Log In")
    public MainPage pressEnter(){
        butLogin.click();
        return this;
    }

    @Step("Checking the label of the site name")
    public String isOpenLogin () {
        return titleLogoSite.getText();
    }

    @Step("Select an item in the shopping cart {0}")
    public MainPage selectProduct(String nameProduct){
       $(By.xpath("//div[@class='inventory_item']/..//div[text()='"+nameProduct+"']")).click();
       return this;
   }

    @Step("Click on the button  {0}")
    public MainPage pressButton(String nameButton){
        $(By.xpath("//button[text()='"+nameButton+"']")).click();
        return this;
    }
    @Step("Click on the add to cart button, without going to a separate product page {0}")
    public MainPage pressButtonAddToCard(String nameProduct){
       $(By.xpath("//a/div[text()='" + nameProduct + "']//..//..//..//button")).click();
       return this;
    }

    @Step("Click on the Shopping Cart button to go")
    public MainPage pressBasket(){
       basketButton.click();
        return this;
    }

    @Step("Click on the checkout button")
    public MainPage checkoutProduct(){
       checkoutButton.click();
        return this;
    }

    @Step("Entering information {0},{1},{2}")
    public MainPage inputInformation(String firstName, String lastName, String postCode ){
        firstNameFieldInf.setValue(firstName);
        lasttNameFieldInf.setValue(lastName);
        postCodeFieldInf.setValue(postCode);
        return this;
    }

    @Step("click on the continue button")
    public MainPage pressContinue(){
       continueInf.click();
       return this;
    }

    @Step("click on the finish button")
    public MainPage pressFinish(){
        finishButton.click();
        return this;
    }

    @Step("Verification of a successful purchase")
    public String getTextCheckoutComplete(){
       return $(By.xpath("//span[@class='title']")).getText();
    }

    @Step("Checking the message about the inability to buy")
    public String getTextNotComplete(){
        return $(By.xpath("//div[@class='error-message-container error']")).getText();
    }

}
