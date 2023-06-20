package e2e_cucumber.steps;

import pages.SignInPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SignInPageSteps implements En {
    SignInPage signInPage;
    WebDriver driver;

    public SignInPageSteps() {
        Then("we enter valid creds of existing user", () -> {
            signInPage = page(SignInPage.class);
            signInPage.validAuth("malik@example.com", "123456");
        });

        And("we click SignIn button", () -> {
            signInPage.clickSignInButn();
        });

        Then("we moved on SingIn Page", () -> {
            signInPage.formIsShown().shouldHave(text("Use the"));
        });
    }
}
