package e2e.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StudentDirectoryPage {

    private static By wellcomeGreetings= By.xpath("//h1[contains(text(),'Welcome to our')]");

    private static By searchField= By.xpath("//input[@id=':r0:']");
    private SelenideElement viewProfileBtn= $x("//a[@type='button']");
    private SelenideElement studentProfile= $x("//div[@class='list-item-wrapper MuiBox-root css-ga4y95']");


    public SelenideElement appearStDirectoryPage() {

        return $(wellcomeGreetings);

    }
    public void choseAStudent(String studentName) {

        $(searchField).val(studentName);

    }
    public void choseStudentOfList() {
        $(studentProfile).click();
    }
    public void clickViewProfileBtn(){
        $(viewProfileBtn).click();
    }
}
