package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAcconts(){
        given()
                .baseUri("http://0.0.0.0:9999/api/v1")
                .when()
                .get ("/demo/accounts")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body("",hasSize(3))
                .body("[0].currency", equalTo("RUB"))
                .body("[1].balance",greaterThan(0));


    }
}
