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
    private final SelenideElement addToCartSauceLabsBackpack = $(By.id("add-to-cart-sauce-labs-backpack")); // добавить в корзину
    private final SelenideElement backToProductsBut = $(By.id("back-to-products")); // кнопка назад
    private final SelenideElement basketButton = $(By.id("shopping_cart_container")); // кнопка корзина
    private final SelenideElement checkoutButton = $(By.id("checkout")); //кнопка оформить покупку

    private final SelenideElement firstNameFieldInf = $(By.id("first-name")); // ввод инфо о заказе
    private final SelenideElement lasttNameFieldInf = $(By.id("last-name"));// ввод инфо о заказе
    private final SelenideElement postCodeFieldInf = $(By.id("postal-code"));// ввод инфо о заказе
    private final SelenideElement continueInf = $(By.id("continue")); // кнопка продолжить

    private final SelenideElement finishButton = $(By.id("finish"));
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
        return titleLogoSite.getText();
    }

    @Step("Выбрать товар в корзину {0}")
    public MainPage selectProduct(String nameProduct){
       $(By.xpath("//div[@class='inventory_item']/..//div[text()='"+nameProduct+"']")).click();
       return this;
   }

    @Step("Нажать на кнопку  {0}")
    public MainPage pressButton(String nameButton){
        $(By.xpath("//button[text()='"+nameButton+"']")).click();
        return this;
    }
    @Step("Нажать на кнопку добавить в корзину , без перехода на отдельную страницу товара {0}")
    public MainPage pressButtonAddToCard(String nameProduct){
       $(By.xpath("//a/div[text()='" + nameProduct + "']//..//..//..//button")).click();
       return this;
    }

    @Step("Нажать на кнопку Корзина для перехода")
    public MainPage pressBasket(){
       basketButton.click();
        return this;
    }

    @Step("Нажать на кнопку оформить покупку")
    public MainPage checkoutProduct(){
       checkoutButton.click();
        return this;
    }

    @Step("Ввод информации {0},{1},{2}")
    public MainPage inputInformation(String firstName, String lastName, String postCode ){
        firstNameFieldInf.setValue(firstName);
        lasttNameFieldInf.setValue(lastName);
        postCodeFieldInf.setValue(postCode);
        return this;
    }

    @Step("нажать на кнопку продолжить")
    public MainPage pressContinue(){
       continueInf.click();
       return this;
    }

    @Step("нажать на кнопку завершить")
    public MainPage pressFinish(){
        finishButton.click();
        return this;
    }

    @Step("Проверка успешной покупки")
    public String getTextCheckoutComplete(){
       return $(By.xpath("//span[@class='title']")).getText();
    }

    @Step("Проверка сообщения о невозможности купить")
    public String getTextNotComplete(){
        return $(By.xpath("//div[@class='error-message-container error']")).getText();
    }

}
