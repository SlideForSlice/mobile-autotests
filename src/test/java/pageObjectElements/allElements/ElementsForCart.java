package pageObjectElements.allElements;

import config.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;


public class ElementsForCart extends TestBase {


    public void findCartTitle(){
        var cartTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Корзина\"]"));
        cartTitle.isDisplayed();
    }

    @Step("Searching for clean cart icon")
    public void findClearCartIcon(){
        var clearIcon =  driver.findElement(AppiumBy
                .xpath("//android.widget.LinearLayout[@resource-id=\"ru.goulash.develop:id/title\"]/android.widget.LinearLayout/android.widget.ImageView[2]"));
        clearIcon.click();
    }

    @Step("Searching for clean cart button")
    public void findClearCartButton(){
        var clearButton = driver.findElement(AppiumBy
                .xpath("//android.widget.TextView[@text=\"Очистить корзину\"]"));
        clearButton.click();
    }

    @Step("Way to clear the cart")
    public void clearTheCart(){
        findCartTitle();
        findClearCartIcon();
        findClearCartButton();
    }



}
