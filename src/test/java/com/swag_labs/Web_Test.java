package com.swag_labs;


import io.qameta.allure.Description;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class Web_Test extends BaseTest{
    @ParameterizedTest
    @DisplayName("User authorization")
    @Description("Testing user authorization {0},{1}")
    @CsvSource({
            "standard_user, secret_sauce",
            "locked_out_user, secret_sauce",
            "problem_user, secret_sauce",
            "performance_glitch_user, secret_sauce",
            "error_user, secret_sauce",
            "visual_user, secret_sauce"
    })
    public void authorise_STD_USER(String userName, String password){
        page
                .logStdUser(userName,password)
                .pressEnter();
        String actual = page.isOpenLogin();
        Assertions.assertEquals("Swag Labs",actual);
    }


    @Test
    @DisplayName("Purchase of one product")
    @Description("description")
    public void checkPurchaseOfGoods(){
        page
                .logStdUser("standard_user","secret_sauce")
                .pressEnter();

        page.selectProduct("Sauce Labs Backpack");

        page
                .pressButton("Add to cart")
                .pressBasket()
                .checkoutProduct()
                .inputInformation("Fedor","Dostoevski","12345687")
                .pressContinue();

        page.pressFinish();
        String actual = page.getTextCheckoutComplete();
        Assertions.assertEquals("Checkout: Complete!",actual);

    }

    @Test
    @DisplayName("Buy, but do not fill in the information about the buyer")
    @Description("description")
    public void checkNotAddInfo(){
        page
                .logStdUser("standard_user","secret_sauce")
                .pressEnter();

        page
                .pressButtonAddToCard("Sauce Labs Bolt T-Shirt")
                .pressBasket()
                .checkoutProduct()
                .pressContinue();
        String actual = page.getTextNotComplete();
        System.out.println("actual: "+actual);
        Assertions.assertEquals("Error: First Name is required",actual);
    }
}
