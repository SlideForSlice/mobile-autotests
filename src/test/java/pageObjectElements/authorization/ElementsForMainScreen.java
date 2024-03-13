package pageObjectElements.authorization;

import config.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class ElementsForMainScreen extends TestBase {

    @Step("Turn on the App")
    public void turnOnTheApp(){
        var appElement = driver.findElement(AppiumBy.accessibilityId("sdk"));
        appElement.click();
    }

    @Step("Send number to the number field")
    public void sendNumber(String value){
        var numberInputField = driver.findElement(AppiumBy.id("ru.goulash.develop:id/edit"));
        numberInputField.click();
        numberInputField.sendKeys(value);
    }

    @Step("Searching for call button")
    public void findCallButton(){
        var callButton = driver.findElement(AppiumBy
                .xpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"ru.goulash.develop:id/button_login_type\"])[2]"));
        callButton.click();
    }

    @Step("Searching for SMS button")
    public void findSmsButton(){
        var smsButton = driver.findElement(AppiumBy
                .xpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"ru.goulash.develop:id/button_login_type\"])[1]"));
        smsButton.click();
    }

    @Step("Searching for Telegram button")
    public void findTelegramButton(){
        var tgButton = driver.findElement(AppiumBy
                .xpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"ru.goulash.develop:id/button_login_type\"])[3]"));
        tgButton.click();
    }

    @Step("Searching for WhatsApp button")
    public void findWhatsappButton(){
        var waButton = driver.findElement(AppiumBy
                .xpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"ru.goulash.develop:id/button_login_type\"])[4]"));
        waButton.click();
    }

    @Step("Checking for accept button")
    public void findAcceptButton(){
        var acceptButton = driver.findElement(AppiumBy
                .xpath("//android.widget.TextView[@text=\"Подтвердить\"]"));
        acceptButton.click();
    }

    @Step("Send words T E S T")
    public void sendKeysTEST(){

        var inputWord1 = driver.findElement(AppiumBy.id("ru.goulash.develop:id/editCode1"));
        inputWord1.click();
        inputWord1.sendKeys("t");

        var inputWord2 = driver.findElement(AppiumBy.id("ru.goulash.develop:id/editCode2"));
        inputWord2.click();
        inputWord2.sendKeys("e");

        var inputWord3 = driver.findElement(AppiumBy.id("ru.goulash.develop:id/editCode3"));
        inputWord3.click();
        inputWord3.sendKeys("s");

        var inputWord4 = driver.findElement(AppiumBy.id("ru.goulash.develop:id/editCode4"));
        inputWord4.click();
        inputWord4.sendKeys("t");
    }

    @Step("Click YES on address modal window")
    public void checkAddressModalWindow(){
        var modalWindowCheckAddress = driver.findElement(AppiumBy
                .id("ru.goulash.develop:id/_check_address_sure"));

        if (modalWindowCheckAddress.isDisplayed()){
            driver.findElement(AppiumBy.id("ru.goulash.develop:id/button_yes")).click();
        }

    }

    @Step("Getting text from Telegram auth page")
    public String getTitleFromTelegramAuthPage(){
        var finishAuthWithTgText = driver.findElement(AppiumBy
                .id("ru.goulash.develop:id/image_subtitle")).getText();
        return finishAuthWithTgText;
    }

    @Step("Getting text from Telegram auth page")
    public String getTitleFromWhatsappAuthPage(){
        var waText = driver.findElement(AppiumBy
                .id("ru.goulash.develop:id/image_subtitle")).getText();
        return waText;
    }

    @Step("Searching for skip button")
    public void findSkipButton(){
        var skipButton = driver.findElement(AppiumBy
                .xpath("//android.widget.TextView[@text=\"Пропустить\"]"));
        skipButton.click();
    }

    @Step("Getting title from login page")
    public Boolean getTitleFromLoginPage(){
        var loginTitle = driver.findElement(AppiumBy.id("ru.goulash.develop:id/login_text_view"));
        return loginTitle.isDisplayed();
    }




}
