package e2e_cucumber.steps;

import com.codeborne.selenide.Condition;
import pages.HeaderMenuStudent;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.page;

public class HeaderMenuStudentSteps implements En {
    HeaderMenuStudent headerMenuStudent;

    public HeaderMenuStudentSteps() {
        Then("user icon shows that we're logged in", () -> {
            headerMenuStudent = page(HeaderMenuStudent.class);
            headerMenuStudent.verifyAuthIcon().shouldBe(Condition.visible);
        });

        When("we click Student Directory button", () -> {

            headerMenuStudent.clickStudentDirectoryBtn();

        });
    }
}
