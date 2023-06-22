package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import model.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UpdateProfilePage {
    private static SelenideElement updateForm = $x("//div[contains(@class,'form-box sw-background-color-ffffff sw-border-style-none sw-border-width-none sw-border-color-eaeced sw-border-radius-2xl sw-box-shadow-none ']");
    private static SelenideElement roleInputField = $x("//div[@class='filter-option-inner-inner']");
    private static SelenideElement roleForm = $x("//div[@class='dropdown-menu show']");
    private static SelenideElement studentRole = $x("//a[@id='bs-select-1-1']");
    private static SelenideElement teacherRole = $x("//a[@id='bs-select-1-0']");
    private static SelenideElement fullNameInputField = $x("//input[@id='sw-form-capture-full_name-input']");
    private static SelenideElement emailInputField = $x("//input[@id='sw-form-capture-email-input']");
    private static SelenideElement aboutMeInputField = $x("//textarea[@id='sw-form-capture-About']");
    private static SelenideElement avatarImageInputField = $x("//input[@type='file']");
    private static SelenideElement enternalProfileInputField = $x("//input[@id='sw-form-capture-External Profile URL']");
    private static SelenideElement MajorInputField = $x("//input[@id='sw-form-capture-Major']");
    private static SelenideElement updateProfileBtn = $x("//a[@id='sw-update-profile-btn']");

    @Step("Update profile form is exist")
    public SelenideElement verifyUpdateForm() {
        return $(updateForm);
    }

    @Step("Role form is exist")
    public SelenideElement verifyRoleForm() {
        return $(roleForm);
    }

    @Step("Chose a student role")
    public SelenideElement choseAStudentRole() {
        $(roleInputField).click();
        verifyRoleForm();
        $(studentRole).click();
        return null;
    }

    @Step("Chose a teacher role")
    public SelenideElement choseATeacherRole() {
        $(roleInputField).click();
        verifyRoleForm();
        $(teacherRole).click();
        return null;
    }

    @Step("fill student Update Profile form ")
    public void fillStudUpdateProfileForm(String fullName, String email, String aboutMe, User userData, String enternalProfile) {
        choseAStudentRole();
        $(fullNameInputField).val(fullName);
        fillEmail(email);
        $(aboutMeInputField).val(aboutMe);
        chooseAPhoto(userData);
        $(enternalProfileInputField).val(enternalProfile);
    }

    @Step("enter Email in email field ")
    public void fillEmail(String email) {
        $(emailInputField).click();
        $(emailInputField).val(email);
    }

    @Step("add a photo in Avatar field")
    public void chooseAPhoto(User userData) {
        SelenideElement photoInput = $(avatarImageInputField);
        String filePathPhoto = System.getProperty("user.dir") + "/src/test/resources/images/" + userData.getPhoto();
        photoInput.sendKeys(filePathPhoto);
    }

    @Step("add a old photo in Avatar field")
    public void chooseAOldPhoto(User userData) {
        SelenideElement photoInput = $(avatarImageInputField);
        String filePath = System.getProperty("user.dir") + "/src/test/resources/images/" + userData.getOldPhoto();
        photoInput.sendKeys(filePath);
    }

    @Step("fill Major field")
    public void fillMajor(String major) {
        $(MajorInputField).click();
        $(MajorInputField).val(major);
    }

    @Step("Click Update profile button")
    public void clickUpdateProfileBtn() {
        $(updateProfileBtn).click();
        Selenide.sleep(10000);
    }

    @Step("Refresh page")
    public static void refreshPage() {
        WebDriverRunner.getWebDriver().navigate().refresh();
    }
}