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

    @Key("chrome.driver.location")
    String getChromedriverLocation();

    @Key("base.url")
    String getBaseUrl();

    @Key("test.selenium.url")
    String getTestSeleniumUrl();

    @Key("reported.by.me.url")
    String getReportedByMeUrl();

    @Key("all.issues.url")
    String getAllIssuesUrl();
}
