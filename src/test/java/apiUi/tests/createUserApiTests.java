package apiUi.tests;


import apiUi.model.UserDto;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class createUserApiTests extends ApiBase{


    UserDto userDto;
    Response response;



    @Test
    public void createUserApiTests(){

        String full_name=faker.name().fullName();
        String email= "faker@gmail.com";
        String password = "123456";
        Object generate_magic_link = false;
        userDto = new UserDto();
        userDto.setFull_name(full_name);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setGenerate_magic_link(generate_magic_link);

        response =doPostRequest("/api/users", 201, userDto);

        Assert.assertEquals(response.jsonPath().getString("full_name"),userDto.getFull_name());
        Assert.assertEquals(response.jsonPath().getString("email"),userDto.getEmail());
        Assert.assertEquals(response.jsonPath().getString("password"),userDto.getPassword());




    }

}
