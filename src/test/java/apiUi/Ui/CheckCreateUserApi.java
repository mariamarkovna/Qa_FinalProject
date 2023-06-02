package apiUi.Ui;

import apiUi.API.tests.CreateUserApiTests;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderMenu;
import pages.HeaderMenuStudent;
import pages.SignInPage;
import regressionTests.BaseTest;

public class CheckCreateUserApi extends BaseTest {
    @Test
    @Description("Checking created user via API with UI")
    public void loginCreateUserApi() {
        new HeaderMenu().clickSignInBtn();
        new SignInPage().signIn("faker@gmail.com", "123456");
        new HeaderMenuStudent().verifyAuthIcon();
    }

}
