package ru.iFellow.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({"classpath:app.properties"})
public interface Props extends Config {
    Props PROPS = ConfigFactory.create(Props.class);

    @Key("login")
    String login();

    @Key("password")
    String password();
}
