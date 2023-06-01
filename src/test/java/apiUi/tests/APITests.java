package apiUi.tests;

import apiUi.model.UserDto;
import apiUi.model.response.UserRespDto;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class APITests {
//
//    //private final String BASE_URI = "https://studio-api.softr.io/v1";
//    String baseUri = "https://studio-api.softr.io/v1";
//
//    @Test//(testName="tc_api1:Create user via API and check created user")
//    public void createUser() {
//        String full_name = "Vasja Pupkin";
//        String email = "vp@gmail.com";
//        String password = "123456";
//        Object generate_magic_link =null;
//        UserDto userDto = new UserDto(full_name, email, password,generate_magic_link );
//
//        UserRespDto userRespDto = RestAssured.given()
//                .header("Content-type", "application/json")
//                .body(userDto)
//                .when()
//                .baseUri(baseUri)
//                .log().all()
//                .post("/api/users")
//                .then()
//                .log().all()
//                .extract().as(UserRespDto.class);
//        Assert.assertEquals(userRespDto.full_name, full_name);
//        Assert.assertEquals(userRespDto.email, email);
//        Assert.assertEquals(userRespDto.password, password);
//        Assert.assertEquals(userRespDto.magic_link, null);//
//    }
//
//    @Test
//    public void creatUser_1() {
//        String body = """
//                {
//                    "full_name":"Vasja Pupkin",
//                    "email":"vp@gmail.com",
//                    "password":"123456",
//                    "generate_magic_link":"false
//                }""";
//        RestAssured.given()
//                .header("Content-type", "application/json")
//                .body(body)
//                .when()
//                .baseUri(baseUri)
//                .log().all()
//                .post("/api/users")
//                .then()
//                .log().all()
//                .assertThat()
//                .body("email", Matchers.equalTo("vp@gmail.com"));
//
//    }
//    @Test
//    public void createUser_2() {
//        String full_name = "Vasja Pupkin";
//        String email = "vp@gmail.com";
//        String password = "123456";
//        Object generate_magic_link = false;
//        UserDto userDto = new UserDto(full_name, email, password, generate_magic_link);
//
//        RestAssured.given()
//                .header("Content-type", "application/json")
//                .body(userDto)
//                .when()
//                .baseUri(baseUri)
//                .log().all()
//                .post("/api/users")
//                .then()
//                .log().all()
//                .assertThat()
//                .body("email", Matchers.equalTo("vp@gmail.com"));
//    }

}
