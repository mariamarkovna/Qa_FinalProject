package apiUi.API.tests;


import apiUi.API.ApiBase;
import apiUi.API.enums.EndPoint;
import apiUi.API.model.UserDto;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import pages.HeaderMenu;
import pages.HomePage;
import pages.SignInPage;


public class CreateUserApiAndCheckUITests extends ApiBase {
    UserDto userDto;
    Response response;
    String email;

    @AfterMethod
    public void afterMethod() {
        doDeleteRequest(EndPoint.DELETE_USER, 200, email);
    }

    @Test(testName = "tc_api2:Delete user via API")
    @Description("Create User via API")
    public void createUserApiAndCheckUITests() {
        userDto = new UserDto();
        userDto.setFull_name(faker.name().fullName());
        userDto.setEmail("faker@gmail.com");
        userDto.setPassword("123456");
        userDto.setGenerate_magic_link(false);

        response = doPostRequest(EndPoint.CREATE_USER, 201, userDto);
        email = response.jsonPath().getString("email");

        Assert.assertEquals(response.jsonPath().getString("full_name"), userDto.getFull_name());
        Assert.assertEquals(response.jsonPath().getString("email"), userDto.getEmail());
        Assert.assertEquals(response.jsonPath().getString("magic_link"), userDto.getMagic_link());

        new HeaderMenu().clickSignInBtn();
        new SignInPage().signIn("faker@gmail.com", "123456");
        new HomePage().HPIsShown();
    }
    // open("https://jere237.softr.app");
//        WebDriverRunner.getWebDriver().manage().window().maximize();
}
