package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePageUser {
    private static SelenideElement usersHomePageElement = $x("//h1[contains(@class,'sw-font-size-5xl sw-text-color-252525 sw-font-family-default sw-font-weight-bold sw-padding-top-none sw-padding-bottom-4xs sw-letter-spacing-normal sw-line-height-normal')]");


    @Step("Home page user is exist")
    public SelenideElement getUsersHomePageElement() {
        return $(usersHomePageElement);
    }
}
