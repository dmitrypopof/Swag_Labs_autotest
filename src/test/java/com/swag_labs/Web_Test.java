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
    @Description("описание")
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
}
