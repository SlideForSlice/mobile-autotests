package pageObjectElements.allElements;

import config.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class ElementsForCatalog extends TestBase {

    @Step("Searching for product card")
    public void findProductCard() {
        var margaritaPhoto = driver.findElement(AppiumBy
                .xpath("(//android.widget.ImageView[@content-desc=\"Фото\"])[5]"));
        margaritaPhoto.click();
    }

    @Step("Searching for price button on product card")
    public void findPriceButtonOnProductCard() {
        var priceButton = driver.findElement(AppiumBy.id("ru.goulash.develop:id/calculate_price"));
        priceButton.click();
    }

    @Step("Scroll down to close product card")
    public void scrollDownToCloseProductCard(){
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(565, 208);
        var end = new Point (556, 1757);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    @Step("Searching for Cart button")
    public void findCartButton(){
        var goToCartButton = driver.findElement(AppiumBy.id("ru.goulash.develop:id/tv_to_cart"));
        goToCartButton.click();
    }

}
