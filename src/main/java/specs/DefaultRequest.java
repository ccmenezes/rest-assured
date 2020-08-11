package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static java.util.Arrays.asList;

public class DefaultRequest {

    static Filter requestLog = new RequestLoggingFilter();
    static Filter responseLog = new ResponseLoggingFilter();
    static List<Filter> logs = asList(requestLog, responseLog);

    public static RequestSpecification requestSpecification(String URI, String path) {

        return new RequestSpecBuilder()
                .setBaseUri(URI)
                .setBasePath(path)
                .addFilters(logs)
                .build();
    }
}
