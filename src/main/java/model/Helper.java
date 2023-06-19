package model;

import com.codeborne.selenide.Condition;
import pages.*;

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
        studentEmailsText();
    }

    public static void CheckTeacherEmailChange() {
        goToProfessorSpotlight();
        teacherEmailsText();

    }

    public static void CheckStudentAllFieldsChange() {
        goToStudentDirectory();
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentEmailsText();

    }

    public static void CheckTeacherAllFieldsChange() {
        goToProfessorSpotlight();
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        teacherEmailsText();
        professorProfilePage.teacherImageChanged();

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
            CheckStudentEmailChange();
        } else if (role.equals("teacher")) {
            CheckTeacherEmailChange();
        }
    }

    public static void studentEmailsText() {
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.studentsEmailIsShown().shouldHave(Condition.text("sas@gmail.com"));
    }

    public static void teacherEmailsText() {
        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.teacherEmail().shouldHave(Condition.text("pic@gmail.com"));
    }
}
