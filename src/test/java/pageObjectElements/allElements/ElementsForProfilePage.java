package pageObjectElements.allElements;

import config.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;


public class ElementsForProfilePage extends TestBase {

    @Step("Searching for logout button")
    public void findLogoutButton(){
        var logoutButton = driver.findElement(AppiumBy
                .xpath("//android.widget.LinearLayout[@resource-id=\"ru.goulash.develop:id/toolbar\"]/android.widget.LinearLayout/android.widget.ImageView[2]"));
        logoutButton.click();
    }

    @Step("Changing user's name")
    public void changeUserName(){
        var nameField = driver.findElement(AppiumBy
                .xpath("//android.widget.EditText[@resource-id=\"ru.goulash.develop:id/edit\"]"));
        nameField.clear();
        nameField.sendKeys("Новое имя");
    }

    @Step("Getting text from user's field")
    public String getUserName(){
        var nameField = driver.findElement(AppiumBy
                .xpath("//android.widget.EditText[@resource-id=\"ru.goulash.develop:id/edit\"]"));
        return nameField.getText();
    }

    @Step("Changing user's email")
    public void changeUserEmail(){
        var emailField = driver.findElement(AppiumBy
                .xpath("//android.widget.EditText[@resource-id=\"ru.goulash.develop:id/edit\" and @text=\"jora@mail.ru\"]"));
        emailField.clear();
        emailField.sendKeys("change@gmail.com");
    }

    @Step("Getting text from user's field")
    public String getUserEmail(){
        var emailField = driver.findElement(AppiumBy
                .xpath("//android.widget.EditText[@resource-id=\"ru.goulash.develop:id/edit\" and @text=\"jora@mail.ru\"]"));
        return  emailField.getText();
    }

    @Step("Changing user's sex")
    public void changeUserSex(){
        var sexField = driver.findElement(AppiumBy
                .xpath("//android.widget.EditText[@resource-id=\"ru.goulash.develop:id/edit\" and @text=\"Мужской\"]"));
        sexField.click();

        var sexWindowTitle = driver.findElement(AppiumBy.id("ru.goulash.develop:id/title"));
        sexWindowTitle.isDisplayed();

        var woman = driver.findElement(AppiumBy.id("ru.goulash.develop:id/female"));
        woman.click();
    }

    @Step("Getting text from user's sex field")
    public String getUserSex(){
        var sexField = driver.findElement(AppiumBy
                .xpath("//android.widget.EditText[@resource-id=\"ru.goulash.develop:id/edit\" and @text=\"Мужской\"]"));
        return sexField.getText();
    }

    @Step("Find sms checkbox")
    public WebElement getSmsCheckbox(){
        return driver.findElement(AppiumBy.id("ru.goulash.develop:id/sms_check"));
    }

    @Step("Checking sms checkbox")
    public void uncheckSmsCheckbox(){
        if (getSmsCheckbox().isSelected()){
            driver.findElement(AppiumBy.id("ru.goulash.develop:id/sms_check")).click();
        }
    }

    @Step("Find email checkbox")
    public WebElement getEmailCheckbox(){
        return driver.findElement(AppiumBy.id("ru.goulash.develop:id/email_check"));
    }

    @Step("Checking email checkbox")
    public void uncheckEmailCheckbox(){

        if (getEmailCheckbox().isSelected()){
            driver.findElement(AppiumBy.id("ru.goulash.develop:id/email_check")).click();
        }
    }

    @Step("Saving changes")
    public void findSaveButton(){
        var saveButton = driver.findElement(AppiumBy.id("ru.goulash.develop:id/submit"));
        saveButton.click();
    }

    @Step("Find delete profile button")
    public void findDeleteProfileButton(){
        var deleteButton = driver.findElement(AppiumBy.id("ru.goulash.develop:id/remove_profile"));
        deleteButton.click();
    }

    @Step("Find confirm delete number")
    public void findAgreeDeleteProfileButton(){
        var agreeButton = driver.findElement(AppiumBy.id("ru.goulash.develop:id/confirm"));
        agreeButton.click();
    }

}
