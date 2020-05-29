package utils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;

public class Schema {

    public static void schemaValidator(ValidatableResponse validatableResponse, String schemaPath) {
        validatableResponse.extract().response().then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
    }
}
