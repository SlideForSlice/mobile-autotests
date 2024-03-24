package testSections.authorization;

import config.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pageObjectElements.allElements.*;
import testSections.authorization.mainLogic.AppActions;
import testSections.authorization.mainLogic.AuthType;
import testSections.authorization.mainLogic.CommonAuthLogic;
import testSections.authorization.mainLogic.LoginOrLogout;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@Feature("Positive and negative cases for auth")
public class MainAuth extends TestBase {
    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForCart elementsForCart = new ElementsForCart();
    ElementsForCatalog elementsForCatalog = new ElementsForCatalog();
    CommonAuthLogic commonAuthLogic = new CommonAuthLogic();

    @Nested
    @Story("Positive cases. Main screen")
    class PositiveAuthFromMainScreen {
        @Description("Auth with the call")
        @Test
        public void authWithCall() {

            commonAuthLogic.doWithApp(AppActions.START);

            commonAuthLogic.authWith(AuthType.CALL);

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGOUT);

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

        @Description("Auth with the SMS")
        @Test
        public void authWithSMS(){

            commonAuthLogic.doWithApp(AppActions.START);

            commonAuthLogic.authWith(AuthType.SMS);

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGOUT);

            commonAuthLogic.doWithApp(AppActions.EXIT);


        }

        @Description("Auth with the Telegram")
        @Test
        public void authWithTelegram() throws InterruptedException {

            commonAuthLogic.doWithApp(AppActions.START);

            commonAuthLogic.authWith(AuthType.TG);
            assertEquals("Для завершения авторизации перейдите в Telegram", elementsFromMainScreen.getTitleFromTelegramAuthPage());

            sleep(3000);

            commonAuthLogic.doWithApp(AppActions.EXIT);
        }

        @Description("Auth with the Telegram")
        @Test
        public void authWithWhatsapp() throws InterruptedException {

            commonAuthLogic.doWithApp(AppActions.START);

            commonAuthLogic.authWith(AuthType.WA);
            assertEquals("Для завершения авторизации перейдите в WhatsApp", elementsFromMainScreen.getTitleFromWhatsappAuthPage());

            sleep(3000);

            commonAuthLogic.doWithApp(AppActions.EXIT);
        }
    }

    @Nested
    @Story("Positive cases. Burger menu")
    class PositiveAuthFromBurgerMenu {

        @Description("Auth with the call")
        @Test
        public void authWithCall() {

            commonAuthLogic.doWithApp(AppActions.START);

            elementsFromMainScreen.findSkipButton();

            elementsFromMainScreen.checkAddressModalWindow();

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGIN);

            commonAuthLogic.authWith(AuthType.CALL);

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGOUT);

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

        @Description("Auth with the SMS")
        @Test
        public void authWithSMS() {

            commonAuthLogic.doWithApp(AppActions.START);

            elementsFromMainScreen.findSkipButton();

            elementsFromMainScreen.checkAddressModalWindow();

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGIN);

            commonAuthLogic.authWith(AuthType.SMS);

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGOUT);

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

        @Description("Auth with the Telegram")
        @Test
        public void authWithTelegram() throws InterruptedException {

            commonAuthLogic.doWithApp(AppActions.START);

            elementsFromMainScreen.findSkipButton();

            elementsFromMainScreen.checkAddressModalWindow();

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGIN);

            commonAuthLogic.authWith(AuthType.TG);

            elementsForBurgerMenu.findBurgerMenu();
            assertEquals("Для завершения авторизации перейдите в Telegram", elementsFromMainScreen.getTitleFromTelegramAuthPage());

            sleep(3000);

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

        @Description("Auth with the WhatsApp")
        @Test
        public void authWithWhatsapp() throws InterruptedException {

            commonAuthLogic.doWithApp(AppActions.START);

            elementsFromMainScreen.findSkipButton();

            elementsFromMainScreen.checkAddressModalWindow();

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGIN);

            commonAuthLogic.authWith(AuthType.WA);

            elementsForBurgerMenu.findBurgerMenu();
            assertEquals("Для завершения авторизации перейдите в WhatsApp", elementsFromMainScreen.getTitleFromTelegramAuthPage());

            sleep(3000);

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }



    }

    @Nested
    @Story("Positive cases. From cart")
    class PositiveAuthFromCart{

        @Description("Auth with the call")
        @Test
        public void authWithCall() {

            commonAuthLogic.doWithApp(AppActions.START);

            elementsFromMainScreen.findSkipButton();

            elementsFromMainScreen.checkAddressModalWindow();

            elementsForCatalog.findtProductAndGoToCart();

            commonAuthLogic.authWith(AuthType.CALL);

            elementsForCart.clearTheCart();

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGOUT);

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

        @Description("Auth with the sms")
        @Test
        public void authWithSMS() {

            commonAuthLogic.doWithApp(AppActions.START);

            elementsFromMainScreen.findSkipButton();

            elementsFromMainScreen.checkAddressModalWindow();

            elementsForCatalog.findtProductAndGoToCart();

            commonAuthLogic.authWith(AuthType.SMS);

            elementsForCart.clearTheCart();

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            commonAuthLogic.typeOfLogFromCatalog(LoginOrLogout.LOGOUT);

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

        @Description("Auth with Telegram")
        @Test
        public void authWithTelegram() throws InterruptedException {

            commonAuthLogic.doWithApp(AppActions.START);

            elementsFromMainScreen.findSkipButton();

            elementsFromMainScreen.checkAddressModalWindow();

            elementsForCatalog.findtProductAndGoToCart();

            commonAuthLogic.authWith(AuthType.TG);

            elementsForCart.clearTheCart();

            elementsForBurgerMenu.findBurgerMenu();
            assertEquals("Для завершения авторизации перейдите в Telegram", elementsFromMainScreen.getTitleFromTelegramAuthPage());

            sleep(3000);
            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

        @Description("Auth with Whatsapp")
        @Test
        public void authWithWhatsapp() throws InterruptedException {

            commonAuthLogic.doWithApp(AppActions.START);

            elementsFromMainScreen.findSkipButton();

            elementsFromMainScreen.checkAddressModalWindow();

            elementsForCatalog.findtProductAndGoToCart();

            commonAuthLogic.authWith(AuthType.WA);

            elementsForCart.clearTheCart();

            elementsForBurgerMenu.findBurgerMenu();
            assertEquals("Для завершения авторизации перейдите в WhatsApp", elementsFromMainScreen.getTitleFromWhatsappAuthPage());

            sleep(3000);
            commonAuthLogic.doWithApp(AppActions.EXIT);

        }


    }










}
