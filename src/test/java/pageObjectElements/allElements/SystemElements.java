package pageObjectElements.allElements;

import config.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

public class SystemElements extends TestBase {

    @Step("Closing app from system tray")
    public void SwipeToCloseAllAppsFromTray(){
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(30, 1082);
        var end = new Point (1061, 1078);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        driver.findElement(AppiumBy.id("com.google.android.apps.nexuslauncher:id/clear_all")).click();
    }

    @Step("Enter in system tray")
    public void goToSystemTray(){
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 187)));
    }

}
