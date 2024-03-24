package testSections.profile;

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


@Feature("Positive and negative cases with user profile")
public class UserProfile extends TestBase{

    ElementsForMainScreen elementsFromMainScreen = new ElementsForMainScreen();
    ElementsForBurgerMenu elementsForBurgerMenu = new ElementsForBurgerMenu();
    ElementsForProfilePage elementsForProfilePage = new ElementsForProfilePage();
    SystemElements systemElements = new SystemElements();
    CommonAuthLogic commonAuthLogic = new CommonAuthLogic();
    @Nested
    @Story("Positive cases of changing name, e-mail, sex, checkboxes and bonus cart status")
    class ChangingDataInUserProfile{

        @Story("Changing name")
        @Test
        public void userName() {

            commonAuthLogic.doWithApp(AppActions.START);

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                commonAuthLogic.authWith(AuthType.CALL);
            }

            elementsForBurgerMenu.goToProfileFromCatalog();

            elementsForProfilePage.changeUserNameAndSave();

            elementsForBurgerMenu.goToProfileFromCatalog();

            assertEquals("Новое имя", elementsForProfilePage.getUserName());

            commonAuthLogic.doWithApp(AppActions.EXIT);
        }

        @Step("Changing Email")
        @Test
        public void userEmail() {
            commonAuthLogic.doWithApp(AppActions.START);

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                commonAuthLogic.authWith(AuthType.CALL);
            }

            elementsForBurgerMenu.goToProfileFromCatalog();

            elementsForProfilePage.changeUserEmailAndSave();

            elementsForBurgerMenu.goToProfileFromCatalog();

            assertEquals("change@gmail.com", elementsForProfilePage.getUserEmail());

            commonAuthLogic.doWithApp(AppActions.EXIT);
        }

        @Step("Changing sex")
        @Test
        public void userSex(){
            commonAuthLogic.doWithApp(AppActions.START);

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                commonAuthLogic.authWith(AuthType.CALL);
            }

            elementsForBurgerMenu.goToProfileFromCatalog();

            elementsForProfilePage.changeUserSexAndSave();

            elementsForBurgerMenu.goToProfileFromCatalog();

            assertEquals("Женский", elementsForProfilePage.getUserSex());

            commonAuthLogic.doWithApp(AppActions.EXIT);
        }

        @Step("Checking checkboxes")
        @Test
        public void checkboxes(){
            commonAuthLogic.doWithApp(AppActions.START);

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                commonAuthLogic.authWith(AuthType.CALL);
            }

            elementsForBurgerMenu.goToProfileFromCatalog();

            elementsForProfilePage.uncheckCheckboxesAndSave();

            elementsForBurgerMenu.goToProfileFromCatalog();

            assertEquals(!(elementsForProfilePage.getSmsCheckbox().isSelected()), elementsForProfilePage.getSmsCheckbox().isSelected());
            assertEquals(!(elementsForProfilePage.getEmailCheckbox().isSelected()), elementsForProfilePage.getEmailCheckbox().isSelected());

            commonAuthLogic.doWithApp(AppActions.EXIT);
        }

    }

    @Nested
    @Story("Deleting user profile")
    class DeletingUserProfile {

        @Step("Deleting user profile")
        @Test
        public void DeleteUserProfile(){

            commonAuthLogic.doWithApp(AppActions.START);

            if (elementsFromMainScreen.getTitleFromLoginPage()){

                commonAuthLogic.authWith(AuthType.CALL);
            }

            elementsForBurgerMenu.goToProfileFromCatalog();

            elementsForProfilePage.deleteProfile();

            commonAuthLogic.doWithApp(AppActions.EXIT);

        }

    }


}
