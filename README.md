# Swag_Labs_autotest
https://www.saucedemo.com/

UI-������������ (Selenide, JUnit 5, Allure)

��������� � Selenide:

������ ������ ���������� ����� ������� � ������������

- byClassName
- byId
- byName
- byLinkText
- byXpath


    $(...).setValue("text");
    $(...).click(); 
    $(byClassName("profile__title")).getText(); 

    $(byClassName("page_heading")).shouldHave(exactText("Swag Labs")); - ��������� ��������
    
    Integer countCards = $$(byClassName("card__title")).size(); -  ������� �� �������� ���-���������
    
    $(byTagName("button").shouldBe(clickable));

    $("#submit").shouldBe(enabled).click(); - ���������, ���� ������ ������ ��������, � ����� �������� �� ��� (�������� �� ��������� 4000 ����)

    shouldBe(Condition, milliseconds) - ��������� ������� �������� �������
    
        


