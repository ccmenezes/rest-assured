package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class DefaultResponse {

    public static ResponseSpecification responseSpecification(int statusCode, ContentType contentType) {

        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectContentType(contentType)
                .build();
    }
}
