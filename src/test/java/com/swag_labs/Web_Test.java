package com.swag_labs;


import io.qameta.allure.Description;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class Web_Test extends BaseTest{
    @ParameterizedTest
    @DisplayName("Авторизация пользователя")
    @Description("Тестирование авторизации пользователей {0},{1}")
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
    @DisplayName("Покупка одного товара")
    @Description("описание")
    public void checkPurchaseOfGoods(){
        page
                .logStdUser("standard_user","secret_sauce")
                .pressEnter();

        page.selectProduct("Sauce Labs Backpack");

        page
                .pressButtonAddToCard()
                .pressBasket()
                .checkoutProduct()
                .inputInformation("Fedor","Dostoevski","12345687")
                .pressContinue();

        page.pressFinish();
        String actual = page.getTextCheckoutComplete();
        Assertions.assertEquals("Checkout: Complete!",actual);

    }
}
