package pageObjectElements.authorization;

import config.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;


public class ElementsForProfilePage extends TestBase {

    @Step("Searching for logout button")
    public void findLogoutButton(){
        var logoutButton = driver.findElement(AppiumBy
                .xpath("//android.widget.LinearLayout[@resource-id=\"ru.goulash.develop:id/toolbar\"]/android.widget.LinearLayout/android.widget.ImageView[2]"));
        logoutButton.click();
    }


}
