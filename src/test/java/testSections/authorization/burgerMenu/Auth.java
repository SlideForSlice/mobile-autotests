package testSections.authorization.burgerMenu;

import config.TestBase;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pageObjectElements.allElements.ElementsForBurgerMenu;
import pageObjectElements.allElements.ElementsForMainScreen;
import pageObjectElements.allElements.ElementsForProfilePage;
import pageObjectElements.allElements.SystemElements;

@Feature("Positive and negative cases for auth with call, sms, Tg, WA from burger menu")
public class Auth extends TestBase {

    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    SystemElements systemElements = new SystemElements();


    @Nested
    @Story("Positive cases")
    class PositiveAuth {

        @Description("Auth with the call from burger menu")
        @Test
        public void authWithCall() {
            //Go to burger menu
            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.findSkipButton();
            elementsFromMainScreen.checkAddressModalWindow();
            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findLoginButton();

            //Use common logic
            elementsFromMainScreen.sendNumber();
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

        @Description("Auth with the sms from burger menu")
        @Test
        public void authWithSms() {

            //Go to burger menu
            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.findSkipButton();
            elementsFromMainScreen.checkAddressModalWindow();
            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findLoginButton();

            //Use common logic
            elementsFromMainScreen.sendNumber();
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

        @Description("Auth with the telegram from burger menu")
        @Test
        public void authWithTelegram() throws InterruptedException {

            //Go to burger menu
            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.findSkipButton();
            elementsFromMainScreen.checkAddressModalWindow();
            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findLoginButton();

            //Use common logic
            elementsFromMainScreen.sendNumber();
            elementsFromMainScreen.findTelegramButton();
            elementsFromMainScreen.findAcceptButton();
            assertEquals("Для завершения авторизации перейдите в Telegram", elementsFromMainScreen.getTitleFromTelegramAuthPage());

            sleep(3000);
            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();
        }

        @Description("Auth with the whatsapp from burger menu")
        @Test
        public void authWithWhatsapp() throws InterruptedException {

            //Go to burger menu
            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.findSkipButton();
            elementsFromMainScreen.checkAddressModalWindow();
            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findLoginButton();

            //Use common logic
            elementsFromMainScreen.sendNumber();
            elementsFromMainScreen.findWhatsappButton();
            elementsFromMainScreen.findAcceptButton();
            assertEquals("Для завершения авторизации перейдите в WhatsApp", elementsFromMainScreen.getTitleFromWhatsappAuthPage());

            sleep(3000);
            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();
        }
    }
}