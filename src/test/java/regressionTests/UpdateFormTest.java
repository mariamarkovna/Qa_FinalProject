package regressionTests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import model.Helper;
import model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class UpdateFormTest extends BaseTest {

    public User student = User.builder()
            .email("kali@gmail.com")
            .password("12ka34")
            .newFull_name("Sasha")
            .newEmail("sas@gmail.com")
            .aboutMe("Hi!")
            .externalProfile("sas.linkedin")
            .major("Astrology")
            .build();
    public User teacher = User.builder()
            .email("van@gmail.com")
            .password("223344")
            .newFull_name("Picasso")
            .newEmail("pic@gmail.com")
            .aboutMe("Hi!")
            .externalProfile("pic.linkedin")
            .build();

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][]{
                {student, "student"},
                {teacher, "teacher"},
        };
    }

    @BeforeMethod
    public void preconditions() {
        new HeaderMenu().clickSignInBtn();
    }

    @Issue("d_udp3")
    @Test(dataProvider = "userData", testName = "tc_udp3,tc_udp14: Change all field values in Update profile form.")
    @Description("Change all Field values")
    public void changeAllFieldValues(User userData, String role) {
        new SignInPage().signIn(userData.getEmail(), userData.getPassword());
        new HeaderMenuStudent().clickMyProfile();
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.fillStudUpdateProfileForm(userData.getNewFull_name(), userData.getEmail(), userData.getAboutMe(), userData.getExternalProfile());
        updateProfilePage.fillMajor(userData.getMajor());
        updateProfilePage.clickUpdateProfileBtn();
        Helper helper = new Helper();
        helper.goToProfileCheckAllFields(role);
    }

    @Issue("d_udp3")
    @Test(dataProvider = "userData", testName = "tc_udp5,tc_udp16: Check Email field values in Update profile form.")
    @Description("Check email field")
    public void checkEmailField(User userData, String role) {
        new SignInPage().signIn(userData.getEmail(), userData.getPassword());
        new HeaderMenuStudent().clickMyProfile();
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.verifyUpdateForm();
        updateProfilePage.fillEmail(userData.getEmail());
        updateProfilePage.clickUpdateProfileBtn();
        Helper helper = new Helper();
        helper.goToProfileCheckEmail(role);
    }

    @Issue("d_udp4")
    @Test(dataProvider = "userData", testName = "tc_udp7,tc_udp18: Add a photo in Avatar image field with Browse button.")
    @Description("Add photo to avatar field")
    public void addAPhotoAvatarField(User userData, String role) {
        new SignInPage().signIn(userData.getEmail(), userData.getPassword());
        new HeaderMenuStudent().clickMyProfile();
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.chosePhoto();
        updateProfilePage.clickUpdateProfileBtn();
        Helper helper = new Helper();
        helper.goToProfileCheckAvatar(role);
    }

    @AfterMethod
    public void tearDown() {
        HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
        headerMenuStudent.clickSignOut();
    }
}
