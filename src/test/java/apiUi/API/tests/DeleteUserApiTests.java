package apiUi.API.tests;

import apiUi.API.ApiBase;
import apiUi.API.enums.EndPoint;
import apiUi.API.model.UserDto;
import apiUi.Ui.CheckDeleteUserApi;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class DeleteUserApiTests extends ApiBase {
    UserDto userDto;
    Response response;

    String email;

    @BeforeMethod
    public void precondition() {
        userDto = new UserDto();
        userDto.setFull_name(faker.name().fullName());
        userDto.setEmail("faker@gmail.com");
        userDto.setPassword("123456");
        userDto.setGenerate_magic_link(false);

        response = doPostRequest(EndPoint.CREATE_USER, 201, userDto);
        email = response.jsonPath().getString("email");
    }

    @Test(testName = "tc_api2:Delete user via API")
    @Description("Checking deleted user via API")
    public void deleteUserTest() {
        doDeleteRequest(EndPoint.DELETE_USER, 200, email);
        open("https://jere237.softr.app");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        new CheckDeleteUserApi();

    }

}
