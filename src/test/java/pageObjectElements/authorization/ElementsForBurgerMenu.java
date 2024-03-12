package pageObjectElements.authorization;

import config.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;


public class ElementsForBurgerMenu extends TestBase {

    @Step("Searching for burger menu")
    public void findBurgerMenu(){
        var burgerMenuButton = driver.findElement(AppiumBy
                .id("ru.goulash.develop:id/btn_burger"));
        burgerMenuButton.click();
    }

    @Step("Getting title from burger menu")
    public String getTitleFromBurgerMenu(){
        var titleBurgerMenu = driver.findElement(AppiumBy
                .id("ru.goulash.develop:id/mainTitle")).getText();
        return titleBurgerMenu;
    }

    @Step("Searching for profile button")
    public void findProfileButton(){
        var profileButton = driver.findElement(AppiumBy
                .id("ru.goulash.develop:id/mainTitle"));
        profileButton.click();
    }

    @Step("Searching for login button")
    public void findLoginButton(){
        var loginButton = driver.findElement(AppiumBy.id("ru.goulash.develop:id/login"));
        loginButton.click();

    }

}
