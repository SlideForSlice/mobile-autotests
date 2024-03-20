package testSections.authorization;

import config.TestBase;
import io.qameta.allure.Step;

import pageObjectElements.allElements.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CommonAuthLogic extends TestBase {

    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    SystemElements systemElements = new SystemElements();
    ElementsForCatalog elementsForCatalog = new ElementsForCatalog();
    ElementsForCart elementsForCart = new ElementsForCart();



    protected void typeOfAuth(AuthType type){
        switch (type){
            case CALL:
                elementsFromMainScreen.findCallButton();
                break;
            case SMS:
                elementsFromMainScreen.findSmsButton();
                break;
            case WA:
                elementsFromMainScreen.findWhatsappButton();
                break;
            case TG:
                elementsFromMainScreen.findTelegramButton();
                break;
            default: throw new IllegalArgumentException("No such type of auth");

        }
    }

    /**
     * Use SMS, CALL, WA, TG
     */
    @Step("Auth with params")
    public void authWith(AuthType type){

        elementsFromMainScreen.sendNumber();

        if (type.equals(AuthType.CALL) || type.equals(AuthType.SMS)){

            typeOfAuth(type);
            elementsFromMainScreen.findAcceptButton();
            elementsFromMainScreen.sendKeysTEST();
            elementsFromMainScreen.checkAddressModalWindow();

        } else if (type.equals(AuthType.WA) || type.equals(AuthType.TG)){

            typeOfAuth(type);
            elementsFromMainScreen.findAcceptButton();

        }

    }


    /**
     * use START, EXIT
     */
    @Step("Turn on or turn off the app")
    public void doWithApp(AppActions action){

        switch (action){
            case START:
                elementsFromMainScreen.turnOnTheApp();
                break;
            case EXIT:
                systemElements.goToSystemTray();
                systemElements.SwipeToCloseAllAppsFromTray();
                break;
            default: throw new IllegalArgumentException("No such type of action");
        }

    }


}
