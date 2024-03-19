package ru.iFellow.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {

    private final Properties prop = new Properties();

    public Props() {

        try (InputStream file = getClass().getResourceAsStream("/app.properties")) {
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getLogin() {
        return prop.getProperty("jira.login");
    }

    public String getPassword() {
        return prop.getProperty("jira.password");
    }
}
