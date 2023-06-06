package regressionTests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
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
                        {"kali@gmail.com", "12ka34", "Sasha", "sas@gmail.com", "Hi!", "sas.linkedin", "Astrology"},
                        {"van@gmail.com", "223344", "Picasso", "pic@gmail.com", "Hi", "pic.linkedin"}
                };
    }


    @BeforeMethod

    public void preconditions(Object[] userData) {

        new HeaderMenu().clickSignInBtn();
        new SignInPage().signIn((String) userData[0], (String) userData[1]);
        //
        new HeaderMenuStudent().clickMyProfile();

    }

    @Issue("d_udp3")
    @Test(dataProvider = "userData", testName = "tc_udp3,tc_udp14: Change all field values in Update profile form.")
    @Description("Change all Field values")
    public void changeAllFieldValues(String email, String password, Object[] userData) {
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.fillStudUpdateProfileForm((String) userData[2], (String) userData[3], (String) userData[4], (String) userData[5]);
        updateProfilePage.fillMajor((String) userData[6]);
        updateProfilePage.changeColorBtn();

    }

    @Issue("d_udp3")
    @Test(dataProvider = "userData", testName = "tc_udp5,tc_udp16: Check Email field values in Update profile form.")
    @Description("Check email field")
    public void checkEmailField(String email, String password, Object[] userData) {
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.verifyUpdateForm();
        updateProfilePage.fillEmail((String) userData[3]);
        updateProfilePage.changeColorBtn();
    }

    @Issue("d_udp5")
    @Test(dataProvider = "userData", testName = "tc_udp7,tc_udp18: Add a photo in Avatar image field with Browse button.")
    @Description("Add photo to avatar field")
    public void addAPhotoAvatarField(String email, String password, Object[] userData) {
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

