package regressionTests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UpdateFormTest extends BaseTest {

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][]
                {
                        {"kali@gmail.com", "12ka34", "Sasha", "sas@gmail.com", "Hi!", "sas.linkedin", "Astrology", "Kali"},
                        {"van@gmail.com", "223344", "Picasso", "pic@gmail.com", "Hi", "pic.linkedin", " ", "Van"}
                };

//        public UserDto createUserDto = UserDto.builder()
//                .email("df")
//                .password("df")
//                .build();
    }

    @BeforeMethod
    public void preconditions(Object[] userData) {
        new HeaderMenu().clickSignInBtn();
        new SignInPage().signIn((String) userData[0], (String) userData[1]);
        new HeaderMenuStudent().clickMyProfile();
    }

    @Issue("d_udp3")
    @Test(dataProvider = "userData", testName = "tc_udp3,tc_udp14: Change all field values in Update profile form.")
    @Description("Change all Field values")
    public void changeAllFieldValues(String email, String password, Object[] userData) {
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.fillStudUpdateProfileForm((String) userData[0], (String) userData[1], (String) userData[2], (String) userData[3]);
        updateProfilePage.fillMajor((String) userData[4]);
        updateProfilePage.clickUpdateProfileBtn();
    }

    @Issue("d_udp3")
    @Test(dataProvider = "userData", testName = "tc_udp5,tc_udp16: Check Email field values in Update profile form.")
    @Description("Check email field")
    public void checkEmailField(String email, String password, Object[] userData) {
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.verifyUpdateForm();
        updateProfilePage.fillEmail((String) userData[1]);
        updateProfilePage.clickUpdateProfileBtn();
    }

    @Issue("d_udp4")
    @Test(dataProvider = "userData", testName = "tc_udp7,tc_udp18: Add a photo in Avatar image field with Browse button.")
    @Description("Add photo to avatar field")
    public void addAPhotoAvatarField(String email, String password, Object[] userData) {
        UpdateProfilePage updateProfilePage = new UpdateProfilePage();
        updateProfilePage.chosePhoto();
        updateProfilePage.clickUpdateProfileBtn();

        HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
        headerMenuStudent.clickStudentDirectoryBtn();

        StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.appearStDirectoryPage();
        studentDirectoryPage.enterAStudentName((String) userData[5]);
        studentDirectoryPage.choseStudentOfList(studentDirectoryPage.studentProfileKali);
        studentDirectoryPage.clickViewProfileBtn();

        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.imageChanged();
    }

    @AfterMethod
    public void tearDown() {
        HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
        headerMenuStudent.clickSignOut();
    }
}

//    @DataProvider(name = "credentials")
//    public Object[][] getCredentials() {
//        return new Object[][]
//                {
//                        {"kali@gmail.com", "12ka34"},
//                        {"van@gmail.com", "223344"}
//                };
//    }
//    Starta Institute 24 10:28
//public UserDto createUserDto = UserDto.builder()
////                .email("df")
////                .password("df")
////                .build();

