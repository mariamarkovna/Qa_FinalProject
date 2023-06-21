package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class StudentProfilePage {
    public HeaderMenuUser headerMenuStudent = new HeaderMenuUser();
    private static SelenideElement studentName = $x("//h1");
    private static SelenideElement studentEmail = $x("//p");
    //private static SelenideElement studentRole = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[1]/div[2]/div[3]/div/div/div/span/span");
    private static SelenideElement studentRole = $x("//span[@style='font-size: 1rem; color: rgb(249, 246, 238);']");
    // private static SelenideElement studentPhoto = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[1]/div[1]/div/div/div/div");
    private static SelenideElement studentPhoto = $x("//div[@class='static-image']");
//    private static SelenideElement studentAboutMe = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[2]/div/div/div/div/div/p");
//    private static SelenideElement majorField = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[1]/p");
//    private static SelenideElement majorName = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[1]/div/div/div/div/p");
//    private static SelenideElement BackToDirectoryBtn = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[2]/div/div/a");
//    private static SelenideElement studentRoleField = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[3]/p");
//    private static SelenideElement studentRoleName = $x("/html/body/div[1]/div[2]/section/div/div/div/div/div/div[3]/div[3]/div/div/div/div/div");

    private static SelenideElement studentAboutMe = $x("//div[@class='sw-font-size-l sw-text-color-5A5D63 sw-font-family-default sw-font-weight-normal sw-text-align-left sw-letter-spacing-normal sw-padding-top-5xs sw-padding-bottom-7xs sw-padding-left-none sw-padding-right-none sw-margin-top-none sw-margin-bottom-none rich-text MuiBox-root css-dne634']");
    private static SelenideElement majorField = $x("//p[@class='sw-font-size-m sw-text-color-2c2921 sw-font-family-default sw-font-weight-extrabold sw-text-align-left sw-letter-spacing-normal sw-padding-top-6xs sw-padding-bottom-none sw-padding-left-none sw-padding-right-none MuiBox-root css-0']");
    private static SelenideElement majorName = $x("//p[@class='sw-font-size-l sw-text-color-967110 sw-font-family-default sw-font-weight-normal sw-text-align-left sw-letter-spacing-normal sw-padding-top-none sw-padding-bottom-5xs sw-padding-left-none sw-padding-right-none MuiBox-root css-1oazf1f']");
    private static SelenideElement BackToDirectoryBtn = $x("//a[@type='button']");
    private static SelenideElement studentRoleField = $x("//p[@class='sw-font-size-m sw-text-color-5A5D63 sw-font-family-default sw-font-weight-semibold sw-text-align-left sw-letter-spacing-widest sw-padding-top-6xs sw-padding-bottom-none sw-padding-left-none sw-padding-right-none MuiBox-root css-0']");
    private static SelenideElement studentRoleName = $x("//span[@style='font-size: 0.75rem; color: rgb(97, 97, 97);']");

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

    @Step("'Student' role shown")
    public SelenideElement studentIsShown() {
        return $(studentRoleName);
    }

    @Step("Image of avatar changed")
    public void imageChanged() {
        boolean studentImageVisible = $("img[src = 'https://v5.airtableusercontent.com/v1/18/18/1686938400000/xqnj_tdhhiWn2x7XJPeGtw/uZ-G7TMSNdRJxM4kHTdilouOQe2mlam1TKEdZqmUUgz3Qhpi7by_yAv2NkvpoiwXYMnhxN413pNu3K-LxjtmXWMnkaypswhnEGii0efYd1hglHYyk2g6kkwhMhKcTzD6IeiCHnDUY-wZEOmcesontA/ylfSo6_v6SSJOLrYRcyQ9AzL8JWg2kzBxftBcVedNzM']").isDisplayed();
    }


}