package e2e.steps;

import pages.HomePage;
import pages.SignInPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class HomePageSteps implements En {

    HomePage homePage;
    //HeaderMenu headerMenu;
    SignInPage signInPage;
    WebDriver driver;
    String baseUrl = "https://jere237.softr.app/";

    public HomePageSteps() {
        Given("that we navigate to home page", () -> {
            driver = new FirefoxDriver();
            setWebDriver(driver);
            homePage = open(baseUrl, HomePage.class);
            sleep(5000);
            //homePage.HPIShown().shouldHave(text("Welcome to NoCode University's Student Portal"));
        });

        And("we click SignIn button in Header",() -> {
            homePage.headerMenu.clickSignInBtn();
        });

        Then("we see a SignIn form",() ->{
            signInPage = page(SignInPage.class);
//            SelenideElement f = signInPage.formIsShown();
//            f.shouldHave(text("the"));
            signInPage.formIsShown().shouldHave(text("Use the"));
        });

        And("we close the driver", () ->{
            driver.close();
        });
    }



}
