package apiUi.API.tests;


import apiUi.API.ApiBase;
import apiUi.API.enums.EndPoint;
import apiUi.API.model.UserDto;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

public class CreateUserApiTests extends ApiBase {


    UserDto userDto;
    Response response;
    String email;

    @AfterMethod
    public void afterMethod() {
        doDeleteRequest(EndPoint.DELETE_USER, 200, email);
    }

    @Test
    public void createUserApiTests() {
        String full_name = faker.name().fullName();
        String email = "faker@gmail.com";
        String password = "123456";
        Object generate_magic_link = false;
        //Object magic_link = null;
        userDto = new UserDto();
        userDto.setFull_name(full_name);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setGenerate_magic_link(generate_magic_link);
        //userDto.setMagic_link(null);


        response = doPostRequest(EndPoint.CREATE_USER, 201, userDto);
        email = response.jsonPath().getString("email");

        Assert.assertEquals(response.jsonPath().getString("full_name"), userDto.getFull_name());
        Assert.assertEquals(response.jsonPath().getString("email"), userDto.getEmail());
        Assert.assertEquals(response.jsonPath().getString("magic_link"),userDto.getMagic_link());
    }

}
