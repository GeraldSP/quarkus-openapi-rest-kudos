package com.redhat.kudos;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class KudosResourceTest {
    @Test
    void testEmpryKudosEndpoint() {
        given()
          .when().get("/kudos")
          .then()
             .statusCode(200)
             .body(is("{}"));
    }

}