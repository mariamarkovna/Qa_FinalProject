package e2e.pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private static SelenideElement homePageElement = $x("/html/body/div[1]/header/div/div/div[1]/h1");
    static SelenideElement signInBtn = $x("/html/body/div[1]/div[1]/header/div/div/div/div/a[1]");
    public HeaderMenu headerMenu = new HeaderMenu();
    public SelenideElement HPIShown() {
        return $(homePageElement);
    };

}
