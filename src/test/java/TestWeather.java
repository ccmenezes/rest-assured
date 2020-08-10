import io.restassured.response.ValidatableResponse;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Test;
import utils.Schema;
import weather.Weather;


import static org.junit.Assert.assertEquals;

public class TestWeather {

    @Test
    public void testWeatherByCity() {

        String city = "London";
        int statusCode = HttpStatus.OK_200;
        String pathName = "name";
        String responseCity;
        String schemaPath = "schemas/weather";

        ValidatableResponse validatableResponse = Weather.getWeatherByCity(city, statusCode);

        responseCity = validatableResponse.extract().response().jsonPath().getString(pathName);

        assertEquals(statusCode, validatableResponse.extract().response().getStatusCode());
        assertEquals(city, responseCity);
        Schema.schemaValidator(validatableResponse, schemaPath);
    }

    @Test
    public void testWeatherByInexistentCity() {

        String city = "XPTO";
        int statusCode = HttpStatus.NOT_FOUND_404;
        String schemaPath = "schemas/cityNotFound";

        ValidatableResponse validatableResponse = Weather.getWeatherByCity(city, statusCode);

        Schema.schemaValidator(validatableResponse, schemaPath);
    }

}
