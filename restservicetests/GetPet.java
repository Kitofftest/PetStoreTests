package restservicetests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
public class GetPet {
    @Test
    void restTest() {

        RestAssured
                .given()
                    .log().all()
                .when()
                .get("https://petstore.swagger.io/v2/pet/9223372016900084735")
                .then()
                    .log().all()
                .statusCode(200);
    }
}
