package org.themoviedb.controllers;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.configs.ApiConfig;
import org.themoviedb.filters.CustomAllureRestAssuredFilter;

@Component
public class BaseController {

    @Getter
    @Autowired
    private ApiConfig apiConfig;

    private RequestSpecification requestSpecification;

    protected RequestSpecification getRequestSpecification() {
        if (requestSpecification == null) {
            requestSpecification = initRequestSpecification();
        }
        return RestAssured.given(requestSpecification);
    }

    private RequestSpecification initRequestSpecification() {
//        TODO: to be stored on safe place and provided as a static field - initialized once (simulate behavior when token is overrided by each login request
        var authToken = apiConfig.getToken();
        return RestAssured.given()
                .baseUri("https://api.themoviedb.org/3")
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new CustomAllureRestAssuredFilter());
    }
}
