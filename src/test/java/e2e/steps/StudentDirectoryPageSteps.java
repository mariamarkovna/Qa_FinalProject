package e2e.steps;


import pages.StudentDirectoryPage;
import io.cucumber.java8.En;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class StudentDirectoryPageSteps implements En {


    StudentDirectoryPage studentDirectoryPage;

    public StudentDirectoryPageSteps(){

        When("we see 'Welcome to our student directory'", () ->{
            studentDirectoryPage = page(StudentDirectoryPage.class);

            studentDirectoryPage.appearStDirectoryPage().shouldHave(text("Welcome to our"));
//            $(byText("Welcome to our")).should(exist);
        });

        Then("we enter existing name of Student in search field", () ->{
            studentDirectoryPage.enterAStudentName("Malik");

        });

        And("we see profile of this student",() ->{
            studentDirectoryPage.choseStudentOfList();
        });

        When("we press View Profile button",() ->{

            studentDirectoryPage.clickViewProfileBtn();

        });
    }

}
