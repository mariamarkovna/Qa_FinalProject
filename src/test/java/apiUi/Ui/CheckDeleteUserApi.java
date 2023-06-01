package apiUi.Ui;


import apiUi.API.tests.DeleteUserApiTests;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderMenu;
import pages.SignInPage;
import regressionTests.BaseTest;

import static com.codeborne.selenide.Condition.text;

public class CheckDeleteUserApi extends BaseTest {
    @Test(testName= "tc_api2:Delete user via API")
    @Description("Checking deleted user via API")
    public void checkDeleteUserApi() {
        HeaderMenu headerMenu = new HeaderMenu();
        headerMenu.clickSignInBtn();

        SignInPage signInPage = new SignInPage();
        signInPage.signIn("faker@gmail.com", "123456");
        signInPage.confirmErrorMessage().shouldHave(text("Invalid email or password"));
    }

}
