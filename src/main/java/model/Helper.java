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
    public static void CheckStudentEmailChange(User userData) {
        goToStudentDirectory();
        studentEmailsText(userData.getNewEmail());
    }

    @Step("Check teacher email change")
    public static void CheckTeacherEmailChange(User userData) {
        goToProfessorSpotlight();
        teacherEmailsText(userData.getNewEmail());
    }

    @Step("Check students all fields of update profile form changed")
    public static void CheckStudentAllFieldsChange(User userData) {
        goToStudentDirectory();
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.studentsNameIsShown().shouldHave(text(userData.getNewFull_name()));
        studentEmailsText(userData.getEmail());
        CheckStudentAvatar();
        studentProfilePage.aboutMeIsShown().shouldHave(text(userData.getAboutMe()));
        studentProfilePage.majorNameIsShown().shouldHave(text(userData.getMajor()));//
    }

    @Step("Check teacher all fields of update profile form changed")
    public static void CheckTeacherAllFieldsChange(User userData) {
        goToProfessorSpotlight();
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.professorProfileIsShow();
        professorProfilePage.teacherName().shouldHave(text(userData.getNewFull_name()));
        professorProfilePage.teacherAboutMe().shouldHave(text(userData.getAboutMe()));
        teacherEmailsText(userData.getEmail());
        professorProfilePage.teacherImageChanged();
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
    public void goToProfileCheckEmail(String role, User userData) {
        if (role.equals("student")) {
            CheckStudentEmailChange(userData);
        } else if (role.equals("teacher")) {
            CheckTeacherEmailChange(userData);
        }
    }

    @Step("Go to profile check all fieds")
    public void goToProfileCheckAllFields(String role, User userData) {
        if (role.equals("student")) {
            CheckStudentAllFieldsChange(userData);
        } else if (role.equals("teacher")) {
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
