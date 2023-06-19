package model;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.*;

import static com.codeborne.selenide.Condition.text;

public class Helper {
    public static void goToStudentDirectory() {
        HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
        headerMenuStudent.clickStudentDirectoryBtn();
        StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.appearStDirectoryPage();
        studentDirectoryPage.enterAStudentName("Kali");
        studentDirectoryPage.choseStudentOfList(studentDirectoryPage.studentProfileKali);
        studentDirectoryPage.clickViewProfileBtn();
    }

    public static void goToProfessorSpotlight() {
        HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
        headerMenuStudent.clickProfessorsBtn();
        HomePage homePage = new HomePage();
        homePage.PSIsShown();
        homePage.enterATeacherName("Van");
        homePage.choseTeacherOfList(homePage.teacherProfileLink);
        homePage.clickOfTeacherProfileBtn();
    }

    public static void CheckStudentAvatar() {
        goToStudentDirectory();
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.imageChanged();
    }

    public static void CheckTeacherAvatar() {
        goToProfessorSpotlight();
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.teacherImageChanged();
    }

    @Step("Check students email change")
    public static void CheckStudentEmailChange() {
        goToStudentDirectory();
        studentEmailsText("sas@gmail.com");
    }

    @Step("Check teacher email change")
    public static void CheckTeacherEmailChange() {
        goToProfessorSpotlight();
        teacherEmailsText("pic@gmail.com");
    }

    @Step("Check students all fields of update profile form changed")
    public static void CheckStudentAllFieldsChange() {
        goToStudentDirectory();
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.studentsNameIsShown().shouldHave(text("Sasha"));
        studentEmailsText("sas@gmail.com");
        studentProfilePage.studentRoleIsShown().shouldHave(text("student"));
        CheckStudentAvatar();
        studentProfilePage.aboutMeIsShown().shouldHave(text("Hi!"));
        studentProfilePage.majorFieldIsShown().shouldHave(text("Majoring in"));
        studentProfilePage.majorNameIsShown().shouldHave(text("Astrology"));
        studentProfilePage.backToDirectotyIsShown();
        studentProfilePage.roleIsShown().shouldHave(text("Role"));
        studentProfilePage.studentIsShown().shouldHave(text("student"));
    }

    @Step("Check teacher all fields of update profile form changed")
    public static void CheckTeacherAllFieldsChange() {
        goToProfessorSpotlight();
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.professorProfileIsShow();
        professorProfilePage.teacherName().shouldHave(text("Picasso"));
        professorProfilePage.teacherAboutMe().shouldHave(text("Hi!"));
        teacherEmailsText("pic@gmail.com");
        professorProfilePage.teacherImageChanged();
        professorProfilePage.teacherRole().shouldHave(text("Role"));
        professorProfilePage.checkRoleBtn().shouldHave(text("teacher"));
    }

    @Step("Go to profile check Avatar")
    public void goToProfileCheckAvatar(String role) {
        if (role.equals("student")) {
            CheckStudentAvatar();
        } else if (role.equals("teacher")) {
            CheckTeacherAvatar();
        }
    }

    @Step("Go to profile check email")
    public void goToProfileCheckEmail(String role) {
        if (role.equals("student")) {
            CheckStudentEmailChange();
        } else if (role.equals("teacher")) {
            CheckTeacherEmailChange();
        }
    }

    @Step("Go to profile check all fieds")
    public void goToProfileCheckAllFields(String role) {
        if (role.equals("student")) {
            CheckStudentAllFieldsChange();
        } else if (role.equals("teacher")) {
            CheckTeacherAllFieldsChange();
        }
    }

    @Step("students email text")
    public static void studentEmailsText(String textEmailStudent) {
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.studentsEmailIsShown().shouldHave(Condition.text(textEmailStudent));
    }

    @Step("teachers email text")
    public static void teacherEmailsText(String textEmailTeacher) {
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.teacherEmail().shouldHave(Condition.text(textEmailTeacher));
    }

    @Step("check create user via UI")
    public static void checkCreatedUserViaUI() {
        new HeaderMenu().clickSignInBtn();
        new SignInPage().signIn("faker@gmail.com", "123456");
        new HomePageUser().getUsersHomePageElement().shouldHave(text("NoCode University at a glance"));
    }

    @Step("check delete user via UI")
    public static void checkDeletedUserViaUI() {
        new HeaderMenu().clickSignInBtn();
        SignInPage signInPage = new SignInPage();
        signInPage.signIn("faker@gmail.com", "123456");
        signInPage.confirmErrorMessage().shouldHave(text("Invalid email or password"));
    }
}
