package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    private static By signInForm = By.xpath("//div[@id='signin']");
    private static By emailInput = By.xpath("//*[@id=\"sw-form-capture-email-input\"]");
    private static By passwordInput = By.xpath("//*[@id=\"sw-form-password-input\"]");
    private static By btnSignIn = By.xpath("//*[@id=\"sw-sign-in-submit-btn\"]");
    private static By errorMessage = By.xpath("//div[@class='error-message login-error d-block']");

    @Step("Sign In Form is exist")
    public SelenideElement formIsShown() {
        return $(signInForm);
    }

    @Step("Enter valid creds of existing User")
    public void validAuth(String email, String password) {
        $(emailInput).val(email);
        $(passwordInput).val(password);
    }

    @Step("Click Sign In button")
    public void clickSignInButn() {
        $(btnSignIn).click();
    }

    @Step("Sign In with valid creds of existing User ")
    public void signIn(String email, String password) {
        formIsShown();
        validAuth(email, password);
        clickSignInButn();
    }

    @Step("Confirmation of the error message")
    public SelenideElement confirmErrorMessage() {
        return $(errorMessage);
    }
}
