package e2e_cucumber.steps;

import com.codeborne.selenide.Condition;
import pages.HeaderMenuStudent;
import pages.StudentProfilePage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentProfilePageSteps implements En {
    StudentProfilePage studentProfilePage;
    HeaderMenuStudent headerMenuStudent;

    public StudentProfilePageSteps() {
        Then("we can see all information about this student", () -> {
            studentProfilePage = page(StudentProfilePage.class);
            studentProfilePage.studentsNameIsShown().shouldHave(text("Malik"));
            studentProfilePage.studentsEmailIsShown().shouldHave(text("malik@example.com"));
            studentProfilePage.studentRoleIsShown().shouldHave(text("student"));
            studentProfilePage.studentsPhotoIsShown();
            studentProfilePage.aboutMeIsShown().shouldHave(text("My hobby is"));
            studentProfilePage.majorFieldIsShown().shouldHave(text("Majoring in"));
            studentProfilePage.majorNameIsShown().shouldHave(text("Marketing"));
            studentProfilePage.backToDirectotyIsShown();
            studentProfilePage.roleIsShown().shouldHave(text("Role"));
            studentProfilePage.studentIsShown().shouldHave(text("student"));
        });

        And("click profile icon", () -> {
            headerMenuStudent = page(HeaderMenuStudent.class);
            headerMenuStudent.clickProfileIcon();
        });

        When("we see drop-down menu", () -> {
            headerMenuStudent.verifyDropDownMenu();
        });

        Then("we click SignOut button", () -> {
            headerMenuStudent.clickSignOutBtn();
        });
    }
}
