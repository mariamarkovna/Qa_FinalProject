package apiUi.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    protected Faker faker = new Faker();

    final String SOFTR_API_KEY="khIbAyJIU5CIuh1oDuBRx1s49";
    final String BASE_URI ="https://studio-api.softr.io/v1";
    final String SOFTR_DOMIAN= "https://jere237.softr.app/sign-in";
    final String CONTENT_TYPE= "application/json";
    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", SOFTR_API_KEY)
            .addHeader("Soft-Domian", SOFTR_DOMIAN)
            .addHeader("Content-Type", CONTENT_TYPE)
            .build();

    public Response doPostRequest(String endPoint, int statusCode, Object dto){
        Response response = RestAssured.given()
                .spec(spec)
                .body(dto)
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .extract().response();
        response.then().assertThat().statusCode(statusCode);
        return response;



    }



}
