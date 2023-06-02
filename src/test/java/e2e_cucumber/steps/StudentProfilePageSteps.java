package e2e_cucumber.steps;

import com.codeborne.selenide.Condition;
import pages.HeaderMenuStudent;
import pages.StudentProfilePage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.*;

public class StudentProfilePageSteps implements En {

    StudentProfilePage studentProfilePage;
    HeaderMenuStudent headerMenuStudent;

    public StudentProfilePageSteps() {

        Then("we can see all information about this student", () -> {
            studentProfilePage = page(StudentProfilePage.class);

        });

        And("click profile icon", () -> {
            headerMenuStudent = page(HeaderMenuStudent.class);
            headerMenuStudent.clickProfileIcon();
        });


        When("we see drop-down menu", () -> {

            headerMenuStudent.verifyDropDownMenu().shouldBe(Condition.visible);
        });


        Then("we click SignOut button", () -> {
            headerMenuStudent.clickSignOutBtn();
        });
    }
}
