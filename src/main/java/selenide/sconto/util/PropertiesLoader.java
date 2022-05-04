package selenide.sconto.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Class that extracts properties from the prop file.
 *
 * @author Sebastiano Armeli-Battana
 */
public class PropertiesLoader {  // класс, который позволяет выгружать данные
    private static final String PROP_FILE = "/sconto_test.properties";

    private PropertiesLoader() {
    }

    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertiesLoader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}
