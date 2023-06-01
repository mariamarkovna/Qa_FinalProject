package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StudentProfilePage {

    public HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();

    private static SelenideElement studentName = $x("//h1[@xpath=\"1\"]");

    @Step("Student name shown")
    public SelenideElement studentsNameIsShown() {
        return $(studentName);
    }

}
