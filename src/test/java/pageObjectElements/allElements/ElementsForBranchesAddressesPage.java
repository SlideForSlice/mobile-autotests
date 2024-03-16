package pageObjectElements.allElements;

import config.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class ElementsForBranchesAddressesPage extends TestBase {

    @Step("Find list button")
    public void findBranchesList(){
        var listButton = driver.findElement(AppiumBy.id("ru.goulash.develop:id/radio_list"));
        listButton.click();
    }

    @Step("Find branch")
    public void branchIsVisible(){
        var branch = driver.findElement(AppiumBy
                .xpath("(//android.view.ViewGroup[@resource-id=\"ru.goulash.develop:id/list_item_department_image\"])[1]"));
        branch.isDisplayed();
    }


}
