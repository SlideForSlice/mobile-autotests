package testSections.authorization.mainScreen;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.Suite;
import pageObjectElements.authorization.ElementsForBurgerMenu;
import pageObjectElements.authorization.ElementsForMainScreen;
import pageObjectElements.authorization.ElementsForProfilePage;
import pageObjectElements.authorization.SystemElements;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@Feature("Positive and negative cases for auth with call, sms, Tg, WA from main screen")
public class Auth extends ElementsForMainScreen {
    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    SystemElements systemElements = new SystemElements();

    @Nested
    @Story("Positive cases")
    class PositiveAuth {
        @Description("Auth with the call")
        @Test
        public void authWithCall() {

            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.sendNumber("9995604734");
            elementsFromMainScreen.findCallButton();
            elementsFromMainScreen.findAcceptButton();
            elementsFromMainScreen.sendKeysTEST();
            elementsFromMainScreen.checkAddressModalWindow();

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            elementsForBurgerMenu.findProfileButton();
            elementsForProfilePage.findLogoutButton();

            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();

        }

        @Description("Auth with the SMS")
        @Test
        public void authWithSMS(){

            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.sendNumber("9995604734");
            elementsFromMainScreen.findSmsButton();
            elementsFromMainScreen.findAcceptButton();
            elementsFromMainScreen.sendKeysTEST();
            elementsFromMainScreen.checkAddressModalWindow();

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            elementsForBurgerMenu.findProfileButton();
            elementsForProfilePage.findLogoutButton();

            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();


        }

        @Description("Auth with the Telegram")
        @Test
        public void authWithTelegram() throws InterruptedException {

            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.sendNumber("9995604734");
            elementsFromMainScreen.findTelegramButton();
            elementsFromMainScreen.findAcceptButton();
            assertEquals("Для завершения авторизации перейдите в Telegram", elementsFromMainScreen.getTitleFromTelegramAuthPage());

            sleep(3000);
            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();
        }

        @Description("Auth with the Telegram")
        @Test
        public void authWithWhatsapp() throws InterruptedException {

            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.sendNumber("9995604734");
            elementsFromMainScreen.findWhatsappButton();
            elementsFromMainScreen.findAcceptButton();
            assertEquals("Для завершения авторизации перейдите в WhatsApp", elementsFromMainScreen.getTitleFromWhatsappAuthPage());

            sleep(3000);
            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();
        }
    }










}