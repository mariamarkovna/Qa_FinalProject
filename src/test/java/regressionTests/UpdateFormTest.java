package regressionTests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class UpdateFormTest extends BaseTest {

    public User student = User.builder()
            .email("kali@gmail.com")
            .password("12ka34")
            .newFull_name("Sasha")
            .newEmail("sas@gmail.com")
            .aboutMe("Hi!")
            .photo("dog-7991199_192_1.jpg")
            .externalProfile("sas.linkedin")
            .major("Astrology")
            .oldPhoto("mother-5709418_1280.png")
            .build();
    public User teacher = User.builder()
            .email("van@gmail.com")
            .password("223344")
            .newFull_name("Picasso")
            .newEmail("pic@gmail.com")
            .aboutMe("Hi!")
            .photo("2308809_1.webp")
            .externalProfile("pic.linkedin")
            .oldPhoto("imgpreview2.jpg")
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
        headerMenu.clickSignInBtn();
    }

    @Issue("d_udp3")
    @Test(dataProvider = "userData", testName = "tc_udp3,tc_udp14: Change all field values in Update profile form.")
    @Description("Change all Field values")
    public void changeAllFieldValues(User userData, String role) {
        signInPage.signIn(userData.getEmail(), userData.getPassword());
        headerMenuUser.clickMyProfile();
        updateProfilePage.fillStudUpdateProfileForm(userData.getNewFull_name(), userData.getEmail(), userData.getAboutMe(), userData, userData.getExternalProfile());
        updateProfilePage.fillMajor(userData.getMajor());
        updateProfilePage.clickUpdateProfileBtn();
        helper.goToProfileCheckAllFields(role, userData, "Sasha", "Picasso");
    }

    @Issue("d_udp3")
    @Test(dataProvider = "userData", testName = "tc_udp5,tc_udp16: Check Email field values in Update profile form.")
    @Description("Check email field")
    public void checkEmailField(User userData, String role) {
        signInPage.signIn(userData.getEmail(), userData.getPassword());
        headerMenuUser.clickMyProfile();
        updateProfilePage.verifyUpdateForm();
        updateProfilePage.fillEmail(userData.getEmail());
        updateProfilePage.clickUpdateProfileBtn();
        helper.goToProfileCheckEmail(role, userData, "Kali", "Van");
    }

    @Issue("d_udp4")
    @Test(dataProvider = "userData", testName = "tc_udp7,tc_udp18: Add a photo in Avatar image field with Browse button.")
    @Description("Add photo to avatar field")
    public void addAPhotoAvatarField(User userData, String role) throws InterruptedException {
        signInPage.signIn(userData.getEmail(), userData.getPassword());
        headerMenuUser.clickMyProfile();
        updateProfilePage.setPhoto(userData.getPhoto());
        updateProfilePage.clickUpdateProfileBtn();
        Thread.sleep(2000);
        updateProfilePage.refreshPage();
        helper.goToProfileCheckAvatar(role, "Kali", "Van", userData);
    }

    @AfterMethod
    public void tearDown() {
        headerMenuUser.clickSignOut();
    }
}
