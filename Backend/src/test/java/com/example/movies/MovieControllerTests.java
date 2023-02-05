package com.example.movies;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class MovieControllerTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/v1";
    }

    @Test
    void getAllMoviesTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/movies")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void getSingleMovieTest() {
        final String PussInBootsTheLastWishImdbId = "tt3915174";

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/movies/" + PussInBootsTheLastWishImdbId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Puss in Boots: The Last Wish", response.jsonPath().getString("title"));
    }
}
