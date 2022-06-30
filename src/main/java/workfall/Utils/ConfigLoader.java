package workfall.Utils;

import java.util.Properties;

public class ConfigLoader {

    private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";

    private Properties prop;

    private String getPropertyValue(String propertyKey) {
        String property= prop.getProperty(propertyKey);
        if (property != null) {
            return property.trim();
        } else {
            throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
        }
    }

    public String getSendEmailToUsers() {
        return prop.getProperty(SEND_EMAIL_TO_USERS);
    }
}
