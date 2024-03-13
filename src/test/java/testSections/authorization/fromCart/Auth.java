package testSections.authorization.fromCart;

import config.TestBase;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import pageObjectElements.authorization.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@Feature("Positive and negative cases for auth with call, sms, Tg, WA from cart")
public class Auth extends TestBase {

    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    SystemElements systemElements = new SystemElements();
    ElementsForCatalog elementsForCatalog = new ElementsForCatalog();
    ElementsForCart elementsForCart = new ElementsForCart();

    @Nested
    @Story("Positive cases")
    class PositiveAuth {

        @Story("Auth with the call from cart")
        @Test
        public void authWithCall() {
            //Go to catalog
            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.findSkipButton();
            elementsFromMainScreen.checkAddressModalWindow();

            //Put product in cart, then go to cart
            elementsForCatalog. findProductCard();
            elementsForCatalog.findPriceButtonOnProductCard();
            elementsForCatalog.scrollDownToCloseProductCard();
            elementsForCatalog.findCartButton();

            //Use common logic
            elementsFromMainScreen.sendNumber("9995604734");
            elementsFromMainScreen.findCallButton();
            elementsFromMainScreen.findAcceptButton();
            elementsFromMainScreen.sendKeysTEST();

            //Checking cart
            elementsForCart.findCartTitle();
            elementsForCart.findClearCartIcon();
            elementsForCart.findClearCartButton();

            //Logout
            elementsFromMainScreen.checkAddressModalWindow();
            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            elementsForBurgerMenu.findProfileButton();
            elementsForProfilePage.findLogoutButton();

            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();

        }

        @Story("Auth with the sms from cart")
        @Test
        public void authWithSms() {
            //Go to catalog
            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.findSkipButton();
            elementsFromMainScreen.checkAddressModalWindow();

            //Put product in cart, then go to cart
            elementsForCatalog. findProductCard();
            elementsForCatalog.findPriceButtonOnProductCard();
            elementsForCatalog.scrollDownToCloseProductCard();
            elementsForCatalog.findCartButton();

            //Use common logic
            elementsFromMainScreen.sendNumber("9995604734");
            elementsFromMainScreen.findSmsButton();
            elementsFromMainScreen.findAcceptButton();
            elementsFromMainScreen.sendKeysTEST();

            //Checking cart
            elementsForCart.findCartTitle();
            elementsForCart.findClearCartIcon();
            elementsForCart.findClearCartButton();

            //Logout
            elementsFromMainScreen.checkAddressModalWindow();
            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            elementsForBurgerMenu.findProfileButton();
            elementsForProfilePage.findLogoutButton();

            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();

        }

        @Story("Auth with the telegram from cart")
        @Test
        public void authWithTelegram() throws InterruptedException {
            //Go to catalog
            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.findSkipButton();
            elementsFromMainScreen.checkAddressModalWindow();

            //Put product in cart, then go to cart
            elementsForCatalog. findProductCard();
            elementsForCatalog.findPriceButtonOnProductCard();
            elementsForCatalog.scrollDownToCloseProductCard();
            elementsForCatalog.findCartButton();

            //Use common logic
            elementsFromMainScreen.sendNumber("9995604734");
            elementsFromMainScreen.findTelegramButton();
            elementsFromMainScreen.findAcceptButton();
            assertEquals("Для завершения авторизации перейдите в Telegram", elementsFromMainScreen.getTitleFromTelegramAuthPage());

//
//            //Checking cart
//            elementsForCart.findCartTitle();
//            elementsForCart.findClearCartButton();
            //elementsForCart.findClearCartButton();
//
//            //Logout
//            elementsFromMainScreen.checkAddressModalWindow();
//            elementsForBurgerMenu.findBurgerMenu();
//            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());
//
//            elementsForBurgerMenu.findProfileButton();
//            elementsForProfilePage.findLogoutButton();

            sleep(3000);
            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();

        }

        @Story("Auth with the whatsapp from cart")
        @Test
        public void authWithwhatsapp() throws InterruptedException {
            //Go to catalog
            elementsFromMainScreen.turnOnTheApp();
            elementsFromMainScreen.findSkipButton();
            elementsFromMainScreen.checkAddressModalWindow();

            //Put product in cart, then go to cart
            elementsForCatalog. findProductCard();
            elementsForCatalog.findPriceButtonOnProductCard();
            elementsForCatalog.scrollDownToCloseProductCard();
            elementsForCatalog.findCartButton();

            //Use common logic
            elementsFromMainScreen.sendNumber("9995604734");
            elementsFromMainScreen.findWhatsappButton();
            elementsFromMainScreen.findAcceptButton();
            assertEquals("Для завершения авторизации перейдите в WhatsApp", elementsFromMainScreen.getTitleFromWhatsappAuthPage());

//
//            //Checking cart
//            elementsForCart.findCartTitle();
//            elementsForCart.findClearCartButton();
//          //elementsForCart.findClearCartButton();
//            //Logout
//            elementsFromMainScreen.checkAddressModalWindow();
//            elementsForBurgerMenu.findBurgerMenu();
//            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());
//
//            elementsForBurgerMenu.findProfileButton();
//            elementsForProfilePage.findLogoutButton();

            sleep(3000);
            systemElements.goToSystemTray();
            systemElements.SwipeToCloseAllAppsFromTray();

        }
    }



}