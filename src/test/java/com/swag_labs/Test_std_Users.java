package com.swag_labs;

import org.junit.jupiter.api.Test;



public class Test_std_Users extends BaseTest{

    @Test
    public void authorise_STD_USER(){
        page
                .logStdUser("standard_user","secret_sauce")
                .pressEnter();
    }
}
