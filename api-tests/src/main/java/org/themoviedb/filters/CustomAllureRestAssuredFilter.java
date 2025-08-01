package org.themoviedb.filters;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.UUID;

public class CustomAllureRestAssuredFilter extends AllureRestAssured {

    @Override
    public Response filter(final FilterableRequestSpecification requestSpec,
                           final FilterableResponseSpecification responseSpec,
                           final FilterContext filterContext) {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.startStep(UUID.randomUUID().toString(), new StepResult().setStatus(Status.PASSED).setName(String.format("%s: %s", requestSpec.getMethod(), requestSpec.getURI())));
        lifecycle.stopStep();
        return super.filter(requestSpec, responseSpec, filterContext);
    }
}
