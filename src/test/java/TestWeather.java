import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import specs.DefaultResponse;
import utils.Schema;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class TestWeather {

    @Steps
    private weather.Weather weather;

    @Test
    public void testWeatherByCity() {

        String city = "London";
        int statusCode = HttpStatus.OK_200;
        String pathName = "name";
        String responseCity;
        String schemaPath = "schemas/weather";

        ValidatableResponse validatableResponse = weather.getWeatherByCity(city, statusCode);

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

        ValidatableResponse validatableResponse = weather.getWeatherByCity(city, statusCode);

        Schema.schemaValidator(validatableResponse, schemaPath);
    }

}
