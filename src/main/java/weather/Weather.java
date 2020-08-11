package weather;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specs.*;
import utils.Config;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Weather {

    private static String uri = "http://api.openweathermap.org/data/2.5";
    private static String path= "/weather";

    public static ValidatableResponse getWeatherByCity(String city, int statusCode) throws IOException {
        ContentType contentType = ContentType.JSON;
        String apiKey =  Config.getPropValues("api_key");
        String apiValue = Config.getPropValues("api_value");

        System.out.printf("API KEY" +apiKey + "API VALUE" + apiValue);

        RequestSpecification requestSpecification = DefaultRequest.requestSpecification(uri, path)
                .queryParam("q", city)
                .queryParam(apiKey, apiValue);
        ResponseSpecification responseSpecification = DefaultResponse.responseSpecification(statusCode, contentType);

        return
                given(requestSpecification, responseSpecification)
                .get()
                .then();
    }
}
