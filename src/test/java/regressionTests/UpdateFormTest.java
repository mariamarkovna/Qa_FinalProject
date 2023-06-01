package regressionTests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderMenu;
import pages.HeaderMenuStudent;
import pages.SignInPage;
import pages.UpdateProfilePage;

public class UpdateFormTest extends BaseTest {

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][]
                {
                        {"malik@example.com", "123456"},
                        {"roxanne@example.com", "123456"}
                };
    }


    @BeforeMethod

    public void preconditions(Object[] userData) {

        new HeaderMenu().clickSignInBtn();
        new SignInPage().signIn((String) userData[0], (String) userData[1]);
        //
        new HeaderMenuStudent().clickMyProfile();

    }

    @Test(dataProvider = "userData", testName = "tc_udp3,tc_udp14: Change all field values in Update profile form.")
    @Description("Change all Field values")
    public void changeAllFieldValues(String email, String password) {
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.fillStudUpdateProfileForm("Sasha", "sas@gmail.com", "Hello World!", "Hi! ");
        updateProfilePage.fillMajor("Astrology");
        updateProfilePage.changeColorBtn();

    }

    @Test(dataProvider = "userData", testName = "tc_udp5,tc_udp16: Check Email field values in Update profile form.")
    @Description("Check email field")
    public void checkEmailField(String email, String password) {
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.verifyUpdateForm();
        updateProfilePage.fillEmail("kali!12QA@gmail.com");
        updateProfilePage.changeColorBtn();
    }

    @Test(dataProvider = "userData", testName = "tc_udp7,tc_udp18: Add a photo in Avatar image field with Browse button.")
    @Description("Add photo to avatar field")
    public void addAPhotoAvatarField(String email, String password) {
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.chosePhoto();
        updateProfilePage.changeColorBtn();

    }

    @AfterMethod
    public void tearDown() {
        HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
        headerMenuStudent.clickSignOut();
    }
}

