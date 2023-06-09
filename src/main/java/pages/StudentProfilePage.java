package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class StudentProfilePage {
    public HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
    private static SelenideElement studentName = $x("//h1");
    private static SelenideElement studentEmail = $x("//p");
    private static SelenideElement studentRole = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[1]/div[2]/div[3]/div/div/div/span/span");
    private static SelenideElement studentPhoto = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[1]/div[1]/div/div/div/div");
    private static SelenideElement studentAboutMe = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[2]/div/div/div/div/div/p");
    private static SelenideElement majorField = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[1]/p");
    private static SelenideElement majorName = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[1]/div/div/div/div/p");
    private static SelenideElement BackToDirectoryBtn = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[2]/div/div/a");
    private static SelenideElement studentRoleField = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[3]/p");
    private static SelenideElement studentRoleName = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[3]/div/div/div/div/div");

    @Step("Student name shown")
    public SelenideElement studentsNameIsShown() {
        return $(studentName);
    }

    @Step("Student email shown")
    public SelenideElement studentsEmailIsShown() {
        return $(studentEmail);
    }

    @Step("Student role shown")
    public SelenideElement studentRoleIsShown() {
        return $(studentRole);
    }

    @Step("Student Photo shown")
    public SelenideElement studentsPhotoIsShown() {
        return $(studentPhoto);
    }

    @Step("Student 'about me' information shown")
    public SelenideElement aboutMeIsShown() {
        return $(studentAboutMe);
    }

    @Step("'Major in' shown")
    public SelenideElement majorFieldIsShown() {
        return $(majorField);
    }

    @Step("Major name shown")
    public SelenideElement majorNameIsShown() {
        return $(majorName);
    }

    @Step("'Back to directory' button shown")
    public SelenideElement backToDirectotyIsShown() {
        return $(BackToDirectoryBtn);
    }

    @Step("Role shown")
    public SelenideElement roleIsShown() {
        return $(studentRoleField);
    }

    @Step("'Student'  role shown")
    public SelenideElement studentIsShown() {
        return $(studentRoleName);
    }
}
