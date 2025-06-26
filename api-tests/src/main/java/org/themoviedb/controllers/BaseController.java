package org.themoviedb.controllers;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;
import org.themoviedb.filters.CustomAllureRestAssuredFilter;

@Component
public class BaseController {

    private RequestSpecification requestSpecification;

    protected RequestSpecification getRequestSpecification() {
        if (requestSpecification == null) {
            requestSpecification = initRequestSpecification();
        }
        return RestAssured.given(requestSpecification);
    }

    private RequestSpecification initRequestSpecification() {
//        TODO: to be stored on safe place and provided as a static field - initialized once (simulate behavior when token is overrided by each login request
        var authToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMGM5ZDBmN2QyZTg5YjA5MjYzYmFmYWFmOGM2OWE2YSIsIm5iZiI6MTU2MzQ2Mzg0My4xOTEsInN1YiI6IjVkMzA5MGEzY2FhYjZkMTY0MGExNzZjOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dAAGUsz0vwhS8Th1gW2PowRoA4jjkK5LXiRkOHYi96Y";
        return RestAssured.given()
                .baseUri("https://api.themoviedb.org/3")
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new CustomAllureRestAssuredFilter());
    }
}
