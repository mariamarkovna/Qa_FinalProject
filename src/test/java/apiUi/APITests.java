package apiUi;

import apiUi.model.request.UserDto;
import apiUi.model.response.UserRespDto;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class APITests {

    private final String BASE_URI = "https://studio-api.softr.io/v1";

    @Test//(testName="tc_api1:Create user via API and check created user")
    public void createUser() {
        String full_name = "Felicity_Thiel";
        String email = "Bernardo.Cruickshank@gmail.com";
        boolean generate_magic_link = false;
        UserDto userDto = new UserDto(full_name, email, generate_magic_link);

        UserRespDto userRespDto = RestAssured.given()
                .header("Content-type", "application/json")
                .body(userDto)
                .when()
                .baseUri(BASE_URI)
                .log().all()
                .post("/api/users")
                .then()
                .log().all()
                .extract().as(UserRespDto.class);
        Assert.assertEquals(userRespDto.full_name, full_name);
        Assert.assertEquals(userRespDto.email, email);
        Assert.assertEquals(userRespDto.magic_link, null);

//        RestAssured.given()
//                .header("Content-type","application/json")
//                .body(userDto)
//                .when()
//                .baseUri(BASE_URI)
//                .log().all()
//                .post("/api/users")
//                .then()
//                .log().all()
//                .assertThat()
//                .body("name", Matchers.equalTo(full_name));

    }

}
