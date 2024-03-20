package testSections.authorization.mainScreen;

import config.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pageObjectElements.allElements.ElementsForBurgerMenu;
import pageObjectElements.allElements.ElementsForMainScreen;
import pageObjectElements.allElements.ElementsForProfilePage;
import pageObjectElements.allElements.SystemElements;
import testSections.authorization.AppActions;
import testSections.authorization.AuthType;
import testSections.authorization.CommonAuthLogic;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@Feature("Positive and negative cases for auth with call, sms, Tg, WA from main screen")
public class Auth extends TestBase {
    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    CommonAuthLogic commonAuthLogic = new CommonAuthLogic();

    @Nested
    @Story("Positive cases")
    class PositiveAuth {
        @Description("Auth with the call")
        @Test
        public void authWithCall() {

            commonAuthLogic.doWithApp(AppActions.START);

            commonAuthLogic.authWith(AuthType.CALL);

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            elementsForBurgerMenu.findProfileButton();
            elementsForProfilePage.findLogoutButton();

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

        @Description("Auth with the SMS")
        @Test
        public void authWithSMS(){

            commonAuthLogic.doWithApp(AppActions.START);

            commonAuthLogic.authWith(AuthType.SMS);

            elementsForBurgerMenu.findBurgerMenu();
            assertNotEquals("Здравствуйте,", elementsForBurgerMenu.getTitleFromBurgerMenu());

            elementsForBurgerMenu.findProfileButton();
            elementsForProfilePage.findLogoutButton();

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










}
