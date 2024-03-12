package config;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import java.net.MalformedURLException;


public class TestBase {

    public static AppiumDriver driver;
    public static DriverFactory driverFactory = new DriverFactory();

    @Step("Driver settings")
    @BeforeAll
    public static void setDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
    }


    @Step("Quitting the driver")
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
