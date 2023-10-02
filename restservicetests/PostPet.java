package restservicetests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
public class PostPet {
    @Test
    void restTest() {

        String petIDReq= "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Барсик\"\n" +
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
                    .body(petIDReq)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
