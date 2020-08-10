package utils;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Config {

    private static final String env;

    static{

        env = System.getProperty("common");
    }

    public static String getPropertyValue(String property) {
        Configurations configs = new Configurations();
        String value = "";
        try {
            // Obtain the configuration from the associated environment file
            FileBasedConfigurationBuilder<PropertiesConfiguration> builder =
                    configs.propertiesBuilder("env" + "properties");
            PropertiesConfiguration config = builder.getConfiguration();
            // Get property value
            value = config.getString(property);
            if (value == null || value.isEmpty()) {
                throw new ConfigurationException("Error getting property: " + property);
            } else {
                return value;
            }
        } catch (ConfigurationException cex) {
            System.out.println("Exception getting property value: " + cex);
        }
        return value;
    }
}
