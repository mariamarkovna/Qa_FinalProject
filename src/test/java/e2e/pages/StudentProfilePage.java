package e2e.pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StudentProfilePage {

    private static SelenideElement studentName = $x("//h1[@xpath=\"1\"]");


    public SelenideElement studentsNameIsShown() {
        return $(studentName);}

}
