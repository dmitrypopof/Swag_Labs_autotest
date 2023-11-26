# Swag_Labs_autotest
https://www.saucedemo.com/

UI-тестирование (Selenide, JUnit 5, Allure)

Селекторы в Selenide:

Полный список селекторов можно изучить в документации

- byClassName
- byId
- byName
- byLinkText
- byXpath


    $(...).setValue("text");
    $(...).click(); 
    $(byClassName("profile__title")).getText(); 

    $(byClassName("page_heading")).shouldHave(exactText("Swag Labs")); - сравнение значений
    
    Integer countCards = $$(byClassName("card__title")).size(); -  сколько на странице веб-элементов
    
    $(byTagName("button").shouldBe(clickable));

    $("#submit").shouldBe(enabled).click(); - дождаться, пока кнопка станет активной, а потом кликнуть по ней (ожидание по умолчанию 4000 мсек)

    shouldBe(Condition, milliseconds) - установка времени ожидания вручную
    
        


