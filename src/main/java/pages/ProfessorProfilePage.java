package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfessorProfilePage {
    private static SelenideElement professorProfilePageElement = $x("//h2[@class='sw-font-size-3xl sw-text-color-default sw-font-family-default sw-font-weight-default sw-padding-top-none sw-padding-bottom-6xs sw-letter-spacing-normal sw-line-height-normal']");
    private static SelenideElement professorEmail = $x("//span[@style='font-size: 1rem; color: rgb(1, 70, 177);']");
    private static SelenideElement professorsName = $x("//h1[@class='sw-font-size-4xl sw-text-color-383B3D sw-font-family-default sw-font-weight-bold sw-text-align-left sw-letter-spacing-normal sw-padding-top-none sw-padding-bottom-5xs sw-padding-left-2xs sw-padding-right-none sw-margin-top-none sw-margin-bottom-none MuiBox-root css-n7odd3']");
    private static SelenideElement professorAboutMe = $x("//p[@class='sw-font-size-m sw-text-color-5a5d63 sw-font-family-default sw-font-weight-normal sw-text-align-left sw-letter-spacing-normal sw-padding-top-7xs sw-padding-bottom-5xs sw-padding-left-2xs sw-padding-right-none sw-margin-top-none sw-margin-bottom-none MuiBox-root css-pbf4sg']");
    private static SelenideElement professorRole = $x("//p[@class='sw-font-size-m sw-text-color-5A5D63 sw-font-family-default sw-font-weight-semibold sw-text-align-left sw-letter-spacing-widest sw-padding-top-6xs sw-padding-bottom-none sw-padding-left-none sw-padding-right-none MuiBox-root css-0']");
    private static SelenideElement roleBtn = $x("//span[@style='font-size: 0.75rem; color: rgb(97, 97, 97);']");

    @Step("Professor spotlight shown")
    public SelenideElement professorProfileIsShow() {
        return $(professorProfilePageElement);
    }

    @Step("Professor name shown")
    public SelenideElement teacherName() {
        return $(professorsName);
    }

    @Step("About me shown")
    public SelenideElement teacherAboutMe() {
        return $(professorAboutMe);
    }

    @Step("Professor email shown")
    public SelenideElement teacherEmail() {
        return $(professorEmail);
    }

    @Step("Image of teacher avatar changed")
    public void teacherImageChanged() {
        boolean teacherImageVisible = $("img[src = 'https://v5.airtableusercontent.com/v1/18/18/1686945600000/vz3UICQTIeH0F4hQGYVVCw/EXicjqjTZS7qetw4ALwd-UFX7trOfQZ6FfkB1FvAAG8Ab_yrdk7sDVsDXXlsJX6PvPLneM4UTE7K0Yq__wi63rdlA6dV533OvXBqgqMaNHTeX5UN0lS4jvEa1kLfqBMPzdoBr2IaCy6SNlIXW6e8sA/hk-7RXqDlTPCLaOSWkZnhYasvwLMkm0OkB30GiBDfMs']").isDisplayed();
    }

    @Step("Professor role shown")
    public SelenideElement teacherRole() {
        return $(professorRole);
    }

    @Step("Role button shown")
    public SelenideElement checkRoleBtn() {
        return $(roleBtn);
    }
}
