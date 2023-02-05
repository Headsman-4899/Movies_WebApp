package com.example.movies;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class ReviewControllerTests {
     String requestReviewBody = "{\n" +
             "    \"reviewBody\": \"Very nice movie!\",\n" +
             "    \"imdbId\": \"tt10298840\"\n" +
             "}";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/v1";
    }

    @Test
    void createReviewToMovieTest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestReviewBody)
                .when()
                .post("/reviews")
                .then()
                .extract().response();

        Assertions.assertEquals(201, response.statusCode());
    }

}
