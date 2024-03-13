package testSections.profile;

import config.TestBase;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import pageObjectElements.authorization.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Feature("Positive and negative cases with user profile")
public class UserProfile extends TestBase{

    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    SystemElements systemElements = new SystemElements();
    ElementsForCatalog elementsForCatalog = new ElementsForCatalog();
    ElementsForCart elementsForCart = new ElementsForCart();

    @Nested
    @Story("Positive cases of changing name, e-mail, sex, checkboxes and bonus cart status")
    class ChangingDataInUserProfile{

        @Story("Changing name")
        @Test
        public void userName() {
            elementsFromMainScreen.turnOnTheApp();

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                elementsFromMainScreen.sendNumber("9995604734");
                elementsFromMainScreen.findCallButton();
                elementsFromMainScreen.findAcceptButton();
                elementsFromMainScreen.sendKeysTEST();
                elementsFromMainScreen.checkAddressModalWindow();

            }

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findProfileButton();

            elementsForProfilePage.changeUserName();
            elementsForProfilePage.findSaveButton();

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findProfileButton();
            assertEquals("Новое имя", elementsForProfilePage.getUserName());

            systemElements.SwipeToCloseAllAppsFromTray();
        }

        @Step("Changing Email")
        @Test
        public void userEmail() {
            elementsFromMainScreen.turnOnTheApp();

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                elementsFromMainScreen.sendNumber("9995604734");
                elementsFromMainScreen.findCallButton();
                elementsFromMainScreen.findAcceptButton();
                elementsFromMainScreen.sendKeysTEST();
                elementsFromMainScreen.checkAddressModalWindow();

            }

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findProfileButton();

            elementsForProfilePage.changeUserEmail();
            elementsForProfilePage.findSaveButton();

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findProfileButton();
            assertEquals("change@gmail.com", elementsForProfilePage.getUserEmail());

            systemElements.SwipeToCloseAllAppsFromTray();
        }

        @Step("Changing sex")
        @Test
        public void userSex(){
            elementsFromMainScreen.turnOnTheApp();

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                elementsFromMainScreen.sendNumber("9995604734");
                elementsFromMainScreen.findCallButton();
                elementsFromMainScreen.findAcceptButton();
                elementsFromMainScreen.sendKeysTEST();
                elementsFromMainScreen.checkAddressModalWindow();

            }

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findProfileButton();

            elementsForProfilePage.changeUserSex();
            elementsForProfilePage.findSaveButton();

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findProfileButton();
            assertEquals("Женский", elementsForProfilePage.getUserSex());

            systemElements.SwipeToCloseAllAppsFromTray();
        }

        @Step("Checking checkboxes")
        @Test
        public void checkboxes(){
            elementsFromMainScreen.turnOnTheApp();

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                elementsFromMainScreen.sendNumber("9995604734");
                elementsFromMainScreen.findCallButton();
                elementsFromMainScreen.findAcceptButton();
                elementsFromMainScreen.sendKeysTEST();
                elementsFromMainScreen.checkAddressModalWindow();

            }

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findProfileButton();

            elementsForProfilePage.uncheckSmsCheckbox();
            elementsForProfilePage.uncheckEmailCheckbox();
            elementsForProfilePage.findSaveButton();

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findProfileButton();

            assertEquals(!(elementsForProfilePage.getSmsCheckbox().isSelected()), elementsForProfilePage.getSmsCheckbox().isSelected());
            assertEquals(!(elementsForProfilePage.getEmailCheckbox().isSelected()), elementsForProfilePage.getEmailCheckbox().isSelected());

            systemElements.SwipeToCloseAllAppsFromTray();
        }

    }


}
