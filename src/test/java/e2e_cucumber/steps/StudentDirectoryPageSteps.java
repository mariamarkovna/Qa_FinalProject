package e2e_cucumber.steps;

import pages.StudentDirectoryPage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class StudentDirectoryPageSteps implements En {
    StudentDirectoryPage studentDirectoryPage;

    public StudentDirectoryPageSteps() {
        When("we see 'Welcome to our student directory'", () -> {
            studentDirectoryPage = page(StudentDirectoryPage.class);
            studentDirectoryPage.appearStDirectoryPage().shouldHave(text("Welcome to our"));
        });

        Then("we enter existing name of Student in search field", () -> {
            studentDirectoryPage.enterAStudentName("Malik");
        });

        And("we see profile of this student", () -> {
            studentDirectoryPage.choseStudentOfList(studentDirectoryPage.studentProfile);
        });

        When("we press View Profile button", () -> {
            studentDirectoryPage.clickViewProfileBtn();
        });
    }
}
