package model;

import com.codeborne.selenide.Condition;
import pages.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

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

    public static void CheckStudentEmailChange() {
        goToStudentDirectory();
        studentEmailsText("sas@gmail.com");
    }

    public static void CheckTeacherEmailChange() {
        goToProfessorSpotlight();
        teacherEmailsText("pic@gmail.com");

    }

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

    public static void CheckTeacherAllFieldsChange() {
        goToProfessorSpotlight();
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.professorProfileIsShow();
        professorProfilePage.teacherName().shouldHave(text("Picasso"));
        professorProfilePage.teacherAboutMe().shouldHave(text("Hi!"));
        ;
        teacherEmailsText("pic@gmail.com");
        professorProfilePage.teacherImageChanged();
        professorProfilePage.teacherRole().shouldHave(text("Role"));
        ;
        professorProfilePage.checkRoleBtn().shouldHave(text("teacher"));

    }

    public void goToProfileCheckAvatar(String role) {
        if (role.equals("student")) {
            CheckStudentAvatar();
        } else if (role.equals("teacher")) {
            CheckTeacherAvatar();
        }
    }

    public void goToProfileCheckEmail(String role) {
        if (role.equals("student")) {
            CheckStudentEmailChange();
        } else if (role.equals("teacher")) {
            CheckTeacherEmailChange();
        }
    }

    public void goToProfileCheckAllFields(String role) {
        if (role.equals("student")) {
            CheckStudentAllFieldsChange();
        } else if (role.equals("teacher")) {
            CheckTeacherAllFieldsChange();
        }
    }

    public static void studentEmailsText(String textEmailStudent) {
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.studentsEmailIsShown().shouldHave(Condition.text(textEmailStudent));
    }

    public static void teacherEmailsText(String textEmailTeacher) {
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.teacherEmail().shouldHave(Condition.text(textEmailTeacher));
    }

    public static void checkCreatedUserViaUI() {
        new HeaderMenu().clickSignInBtn();
        new SignInPage().signIn("faker@gmail.com", "123456");
        new HomePageUser().getUsersHomePageElement().shouldHave(text("NoCode University at a glance"));
    }

    public static void checkDeletedUserViaUI() {
        new HeaderMenu().clickSignInBtn();
        SignInPage signInPage = new SignInPage();
        signInPage.signIn("faker@gmail.com", "123456");
        signInPage.confirmErrorMessage().shouldHave(text("Invalid email or password"));
    }

}
