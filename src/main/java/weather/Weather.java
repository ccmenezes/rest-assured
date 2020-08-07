package weather;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import specs.*;

public class Weather {
    private String uri = "http://api.openweathermap.org/data/2.5";
    private String path= "/weather";
    private String apiKey = "appid";
    private String apiValue = "678d018075e1c68247482e6ddc6b3f56";

    @Step("Call current weather data for one location by city")
    public ValidatableResponse getWeatherByCity(String city, int statusCode) {

        ContentType contentType = ContentType.JSON;

        RequestSpecification requestSpecification = DefaultRequest.requestSpecification(uri)
                .basePath(path)
                .queryParam("q", city)
                .queryParam(apiKey, apiValue);
        ResponseSpecification responseSpecification = DefaultResponse.responseSpecification(statusCode, contentType);

        return SerenityRest.given(requestSpecification, responseSpecification).get().then();
    }
}
