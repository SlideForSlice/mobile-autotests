package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static AppiumDriver driver;

    public AppiumDriver setUp(Platform platform) throws MalformedURLException {
        switch (platform){
            case ANDROID:
                return createAndroidDriver();
            case IOS:
                return createIosDriver();
            default: throw new IllegalArgumentException("No such Platform");
        }
    }

    public IOSDriver createIosDriver(){
        return null;
    }

    public AndroidDriver createAndroidDriver() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return (AndroidDriver) driver;
    }
}
