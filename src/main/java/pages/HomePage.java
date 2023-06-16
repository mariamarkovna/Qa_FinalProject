package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private static SelenideElement homePageElement = $x("/html/body/div[1]/header/div/div/div[1]/h1");
    private static SelenideElement professorSpotlight = $x("//span[@style='color: rgb(255, 255, 255);']");
    private static SelenideElement searchTeacherField = $x("//input[@id=':r0:']");
    private static SelenideElement teacherProfile = $x("//div[@class='list-item-wrapper MuiBox-root css-mza73d']//div[@class='horizontal-list-item']//div[@class='css-1w7j2y6']");
    private static SelenideElement teacherViewProfileBtn = $x("///a[contains(text(),'View profile')]");

    public HeaderMenu headerMenu = new HeaderMenu();

    @Step("Home page is exist")
    public SelenideElement HPIsShown() {
        return $(homePageElement);
    }

    @Step("Professor spotlight is exist")
    public SelenideElement PSIsShown() {
        return $(professorSpotlight);
    }

    @Step("Enter a Teacher name")
    public void enterATeacherName(String teachertName) {

        $(searchTeacherField).val(teachertName);
    }

    @Step("Chose a Teacher of List")
    public void choseTeacherOfList(SelenideElement element) {
        element.click();
    }

    @Step("Click of teacher's view profile button")
    public void clickOfTeacherProfileBtn() {
        teacherViewProfileBtn.click();
    }


}
