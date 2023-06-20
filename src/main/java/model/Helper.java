package model;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.*;

import static com.codeborne.selenide.Condition.text;

public class Helper {
    @Step("Go to student directory")
    public static void goToStudentDirectory(String studentsName) {
        HeaderMenuUser headerMenuStudent = new HeaderMenuUser();
        headerMenuStudent.clickStudentDirectoryBtn();
        StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.appearStDirectoryPage();
        studentDirectoryPage.enterAStudentName(studentsName);
        studentDirectoryPage.choseStudentOfList(studentDirectoryPage.studentProfileKali);
        studentDirectoryPage.clickViewProfileBtn();
    }

    @Step("Go to professor spotlight")
    public static void goToProfessorSpotlight(String teachersName) {
        HeaderMenuUser headerMenuStudent = new HeaderMenuUser();
        headerMenuStudent.clickProfessorsBtn();
        HomePage homePage = new HomePage();
        homePage.PSIsShown();
        homePage.enterATeacherName(teachersName);
        homePage.choseTeacherOfList(homePage.teacherProfileLink);
        homePage.clickOfTeacherProfileBtn();
    }

    @Step("Check students avatar changed")
    public static void CheckStudentAvatar() {
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.imageChanged();
    }

    @Step("Check teachers avatar changed")
    public static void CheckTeacherAvatar() {
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.teacherImageChanged();
    }

    @Step("Check students email changed")
    public static void CheckStudentEmailChange(User userData) {
        studentEmailsText(userData.getNewEmail());
    }

    @Step("Check teachers email changed")
    public static void CheckTeacherEmailChange(User userData) {
        teacherEmailsText(userData.getNewEmail());
    }

    @Step("Check students all fields of update profile form changed")
    public static void CheckStudentAllFieldsChange(User userData) {
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.studentsNameIsShown().shouldHave(text(userData.getNewFull_name()));
        studentEmailsText(userData.getEmail());
        CheckStudentAvatar();
        studentProfilePage.aboutMeIsShown().shouldHave(text(userData.getAboutMe()));
        studentProfilePage.majorNameIsShown().shouldHave(text(userData.getMajor()));
    }

    @Step("Check teacher all fields of update profile form changed")
    public static void CheckTeacherAllFieldsChange(User userData) {
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.professorProfileIsShow();
        professorProfilePage.teacherName().shouldHave(text(userData.getNewFull_name()));
        professorProfilePage.teacherAboutMe().shouldHave(text(userData.getAboutMe()));
        teacherEmailsText(userData.getEmail());
        professorProfilePage.teacherImageChanged();
    }

    @Step("Go to profile check Avatar")
    public void goToProfileCheckAvatar(String role, String studentsName, String teacherName) {
        if (role.equals("student")) {
            goToStudentDirectory(studentsName);
            CheckStudentAvatar();
        } else if (role.equals("teacher")) {
            goToProfessorSpotlight(teacherName);
            CheckTeacherAvatar();
        }
    }

    @Step("Go to profile check email")
    public void goToProfileCheckEmail(String role, User userData, String studentsName, String teacherName) {
        if (role.equals("student")) {
            goToStudentDirectory(studentsName);
            CheckStudentEmailChange(userData);
        } else if (role.equals("teacher")) {
            goToProfessorSpotlight(teacherName);
            CheckTeacherEmailChange(userData);
        }
    }

    @Step("Go to profile check all fieds")
    public void goToProfileCheckAllFields(String role, User userData, String studentsName, String teacherName) {
        if (role.equals("student")) {
            goToStudentDirectory(studentsName);
            CheckStudentAllFieldsChange(userData);
        } else if (role.equals("teacher")) {
            goToProfessorSpotlight(teacherName);
            CheckTeacherAllFieldsChange(userData);
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
