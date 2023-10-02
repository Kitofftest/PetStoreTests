package restservicetests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
public class RestTest {
    @Test
    void restTest() {
        String orderReq= "{\n" +
                "  \"id\": 2,\n" +
                "  \"petId\": 2,\n" +
                "  \"quantity\": 2\n" +
                "  \"shipDate\": \"2023-09-29T16:09:39.991Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        String petIDReq= "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(orderReq)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().jsonPath().getString("token");
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(petIDReq)
                .get("https://petstore.swagger.io/v2/pet/2")
                .then()
                .log().all()
                .statusCode(200);
    }
}
