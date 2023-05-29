package e2e.pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {

    private static By signInForm = By.xpath("//div[@id='signin']");
    //private static By emailInput= By.id("#sw-form-capture-email-input");

    private static By emailInput= By.xpath("//*[@id=\"sw-form-capture-email-input\"]");
    private static By passwordInput= By.xpath("//*[@id=\"sw-form-password-input\"]");
    private static By btnSignIn= By.xpath("//*[@id=\"sw-sign-in-submit-btn\"]");

    public SelenideElement formIsShown() {

        return $(signInForm);

    }


    public void validAuth(String email,String password ) {

        $(emailInput).val(email);
        $(passwordInput).val(password);
    }

    public void clickSignInButn() {

        $(btnSignIn).click();
    }




}
