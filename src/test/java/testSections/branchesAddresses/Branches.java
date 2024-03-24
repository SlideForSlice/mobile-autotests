package testSections.branchesAddresses;

import config.TestBase;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pageObjectElements.allElements.*;
import testSections.authorization.mainLogic.AppActions;
import testSections.authorization.mainLogic.AuthType;
import testSections.authorization.mainLogic.CommonAuthLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Positive and negative cases with address branches")
public class Branches extends TestBase {

    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    SystemElements systemElements = new SystemElements();
    ElementsForBranchesAddressesPage elementsForBranchesAddressesPage = new ElementsForBranchesAddressesPage();
    CommonAuthLogic commonAuthLogic = new CommonAuthLogic();

    @Nested
    @Story("Checking branches addresses page")
    class BranchesAddresses{


        @Step("Checking the map display")
        @Test
        public void checkingMap(){

            commonAuthLogic.doWithApp(AppActions.START);

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                commonAuthLogic.authWith(AuthType.CALL);
            }

            elementsForBurgerMenu.findBurgerMenu();
            elementsForBurgerMenu.findBranches();

            elementsForBranchesAddressesPage.findBranchesList();
            elementsForBranchesAddressesPage.branchIsVisible();
        }

    }

}
