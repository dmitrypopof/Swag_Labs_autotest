package com.swag_labs;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    MainPage page;

    @BeforeEach
    public void setUp(){
        page = new MainPage();
        Selenide.open(MainPage.URL);
    }
}
