package apiUi.API;

import apiUi.API.enums.EndPoint;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    protected Faker faker = new Faker();

//    final String SOFTR_API_KEY = "khIbAyJIU5CIuh1oDuBRx1s49";
//    final String BASE_URL = "https://studio-api.softr.io";
//    final String SOFTR_DOMAIN = "jere237.softr.app";

    final String SOFTR_API_KEY="khIbAyJIU5CIuh1oDuBRx1s49";
    final String BASE_URL ="https://studio-api.softr.io/v1";
    final String SOFTR_DOMAIN= "jere237.softr.app";

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", SOFTR_API_KEY)
            .addHeader("Softr-Domain", SOFTR_DOMAIN)
            .build();

    public Response doPostRequest(EndPoint endPoint, int statusCode, Object dto){
        Response response = RestAssured.given()
                .spec(spec)
                .body(dto)
                .when()
                .log().all()
                .post(endPoint.getValue())
                .then()
                .log().all()
                .extract().response();
        response.then().assertThat().statusCode(statusCode);
        return response;
    }

    public Response doDeleteRequest(EndPoint endPoint, int statusCode, String email){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("email", email)
                .log().all()
                .delete(endPoint.getValue())
                .then()
                .log().all()
                .extract().response();
        response.then().assertThat().statusCode(statusCode);
        return response;
    }



}
