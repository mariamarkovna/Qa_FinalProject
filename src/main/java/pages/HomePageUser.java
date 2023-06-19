package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePageUser {
    private static SelenideElement usersHomePageElement = $x("//h2[contains(@class,'sw-font-size-4xl sw-text-color-default sw-font-family-default sw-font-weight-default sw-padding-top-none sw-padding-bottom-4xs sw-letter-spacing-normal sw-line-height-normal')]");

    @Step("Home page user is exist")
    public SelenideElement getUsersHomePageElement() {
        return $(usersHomePageElement);
    }
}
