package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfessorProfilePage {
    private static SelenideElement professorProfilePageElement = $x("//h2[@class='sw-font-size-3xl sw-text-color-default sw-font-family-default sw-font-weight-default sw-padding-top-none sw-padding-bottom-6xs sw-letter-spacing-normal sw-line-height-normal']");

    public SelenideElement professorProfileIsShow() {
        return $(professorProfilePageElement);
    }

    @Step("Image of teacher avatar changed")
    public void teacherImageChanged() {
        boolean teacherImageVisible = $("img[src = 'https://v5.airtableusercontent.com/v1/18/18/1686945600000/vz3UICQTIeH0F4hQGYVVCw/EXicjqjTZS7qetw4ALwd-UFX7trOfQZ6FfkB1FvAAG8Ab_yrdk7sDVsDXXlsJX6PvPLneM4UTE7K0Yq__wi63rdlA6dV533OvXBqgqMaNHTeX5UN0lS4jvEa1kLfqBMPzdoBr2IaCy6SNlIXW6e8sA/hk-7RXqDlTPCLaOSWkZnhYasvwLMkm0OkB30GiBDfMs']").isDisplayed();
    }
}
