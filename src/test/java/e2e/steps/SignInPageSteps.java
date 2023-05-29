package e2e.steps;

import com.codeborne.selenide.SelenideElement;
import e2e.pages.SignInPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.openqa.selenium.devtools.v108.page.Page.close;

public class SignInPageSteps implements En {

    SignInPage signInPage;
    WebDriver driver;

    public SignInPageSteps() {

        When("we enter valid creds of existing user", () -> {
            signInPage = page(SignInPage.class);
            signInPage.validAuth("malik@example.com", "123456");

        });

        And("we click SignIn button", () ->{
            signInPage.clickSignInButn();
        });

        And("we moved on SingIn Page", () ->{

            signInPage.formIsShown().shouldHave(text("Use the"));

        });

        And("we close the driver", () ->{
            driver = new FirefoxDriver();
            setWebDriver(driver);
            driver.close();


        });
    }




}
