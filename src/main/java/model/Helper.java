package model;

import pages.*;

public class Helper {

    public static void checkInfoStudent() {
        HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
        headerMenuStudent.clickStudentDirectoryBtn();

        StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.appearStDirectoryPage();
        studentDirectoryPage.enterAStudentName("Kali");
        studentDirectoryPage.choseStudentOfList(studentDirectoryPage.studentProfileKali);
        studentDirectoryPage.clickViewProfileBtn();

        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.imageChanged();
    }

    public static void checkInfoTeacher() {
        HeaderMenuStudent headerMenuStudent = new HeaderMenuStudent();
        headerMenuStudent.clickProfessorsBtn();

        HomePage homePage = new HomePage();
        homePage.PSIsShown();
        homePage.enterATeacherName("Van");
        homePage.choseTeacherOfList(homePage.teacherProfileLink);
        homePage.clickOfTeacherProfileBtn();

        ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
        professorProfilePage.teacherImageChanged();
    }

    public void goToProfile(String role) {
        if (role.equals("student")) {
            checkInfoStudent();
        } else if (role.equals("teacher")) {
            checkInfoTeacher();
        }
    }
}
