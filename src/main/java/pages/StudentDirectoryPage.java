package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StudentDirectoryPage {
    private static By wellcomeGreetings = By.xpath("//h1[contains(text(),'Welcome to our')]");
    private static By searchField = By.xpath("//input[@id=':r0:']");
    private SelenideElement viewProfileBtn = $x("//a[@type='button']");
    private SelenideElement studentProfile = $x("//div[@class='list-item-wrapper MuiBox-root css-mza73d']");

    @Step("Appear Student directory")
    public SelenideElement appearStDirectoryPage() {
        return $(wellcomeGreetings);
    }

    @Step("Enter a Student name")
    public void enterAStudentName(String studentName) {
        $(searchField).val(studentName);
    }

    @Step("Chose a Student of List")
    public void choseStudentOfList() {
        $(studentProfile).click();
    }

    @Step("Click View profile button")
    public void clickViewProfileBtn() {
        $(viewProfileBtn).click();
    }
}
