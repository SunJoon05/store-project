package config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfiguration {
    public static final Properties props = new Properties();

    static {
        try (InputStream in = ApplicationConfiguration.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (in == null) {
                throw new RuntimeException("No se encontro el archivo app.properties");
            }

            props.load(in);
        } catch (IOException e) {
            throw  new RuntimeException("No se pudo cargar la configuración" + e);
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static String getPath(String... keys) {
        String[] properties = new String[keys.length];

        for (int i = 0; i < keys.length; i++) {
            properties[i] = File.separator + ApplicationConfiguration.getProperty(keys[i]);
        }

        return String.join("", properties);
    }
}
