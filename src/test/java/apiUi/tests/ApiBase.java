package apiUi.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    final String SOFTR_API_KEY="khIbAyJIU5CIuh1oDuBRx1s49";
    final String BASE_URI ="https://studio-api.softr.io/v1";
    final String SOFTR_DOMIAN= "https://jere237.softr.app/sign-in";
    final String CONTENT_TYPE= "application/json";
    RequestSpecification spac = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", SOFTR_API_KEY)
            .addHeader("Soft-Domian", SOFTR_DOMIAN)
            .addHeader("Content-Type", CONTENT_TYPE)



//    Softr-Domain= "jere237.softr.app"
//    Content-Type = application/json
}
