package weather;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specs.*;
import utils.Config;

public class Weather {
    private static String uri = "http://api.openweathermap.org/data/2.5";
    private static String path= "/weather";
    private static String apiKey = Config.getPropertyValue("api.key");
    private static String apiValue = Config.getPropertyValue("api.value");

    public static ValidatableResponse getWeatherByCity(String city, int statusCode) {
        ContentType contentType = ContentType.JSON;

        RequestSpecification requestSpecification = DefaultRequest.requestSpecification(uri, path)
                .queryParam("q", city)
                .queryParam(apiKey, apiValue);
        ResponseSpecification responseSpecification = DefaultResponse.responseSpecification(statusCode, contentType);

        return RestAssured
                .given(requestSpecification, responseSpecification)
                .get()
                .then();
    }
}
