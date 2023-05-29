package e2e.steps;

import com.codeborne.selenide.Condition;
import e2e.pages.HeaderMenuStudent;
import e2e.pages.StudentProfilePage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class StudentProfilePageSteps implements En {

    StudentProfilePage studentProfilePage;
    HeaderMenuStudent headerMenuStudent;

    public StudentProfilePageSteps(){

        Then("we can see all information about this student", () ->{


        });

        And("click profile icon", () ->{
            headerMenuStudent= page(HeaderMenuStudent.class);
            headerMenuStudent.clickStudentDirectoryBtn();

        });


        When("we see drop-down menu", () ->{

            headerMenuStudent.verifyDropDownMenu().shouldBe(Condition.visible);


        });


        Then("we click SignOut button", () ->{
            headerMenuStudent.clickSignOutBtn();

        });
    }
}
