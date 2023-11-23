package com.swag_labs;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class Test_std_Users extends BaseTest{

    @Test
    @DisplayName("dispName")
    @Description("описание")
    public void authorise_STD_USER(){
        page
                .logStdUser("standard_user","secret_sauce")
                .pressEnter();
    }
}
