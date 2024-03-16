package testSections.branchesAddresses;

import config.TestBase;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pageObjectElements.allElements.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Positive and negative cases with address branches")
public class Branches extends TestBase {

    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    SystemElements systemElements = new SystemElements();
    ElementsForBranchesAddressesPage elementsForBranchesAddressesPage = new ElementsForBranchesAddressesPage();

    @Nested
    @Story("Checking branches addresses page")
    class BranchesAddresses{


        @Step("Checking the map disply")
        @Test
        public void checkingMap(){

            elementsFromMainScreen.turnOnTheApp();

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                elementsFromMainScreen.sendNumber();
                elementsFromMainScreen.findCallButton();
                elementsFromMainScreen.findAcceptButton();
                elementsFromMainScreen.sendKeysTEST();
            }

            elementsFromMainScreen.checkAddressModalWindow();

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findBranches();

            elementsForBranchesAddressesPage.findBranchesList();
            elementsForBranchesAddressesPage.branchIsVisible();
        }

    }

}
