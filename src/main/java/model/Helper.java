package model;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.*;

import static com.codeborne.selenide.Condition.text;

public class Helper {
    static HomePage homePage = new HomePage();
    static HomePageUser homePageUser = new HomePageUser();
    static HeaderMenu headerMenu = new HeaderMenu();
    static HeaderMenuUser headerMenuUser = new HeaderMenuUser();
    static SignInPage signInPage = new SignInPage();
    static UpdateProfilePage updateProfilePage = new UpdateProfilePage();
    static ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
    static StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
    static StudentProfilePage studentProfilePage = new StudentProfilePage();

    @Step("Go to student directory")
    public static void goToStudentDirectory(String studentsName) {
        headerMenuUser.clickStudentDirectoryBtn();
        studentDirectoryPage.appearStDirectoryPage();
        studentDirectoryPage.enterAStudentName(studentsName);
        studentDirectoryPage.choseStudentOfList(studentDirectoryPage.studentProfileKali);
        studentDirectoryPage.clickViewProfileBtn();
    }

    @Step("Go to professor spotlight")
    public static void goToProfessorSpotlight(String teachersName) {
        headerMenuUser.clickProfessorsBtn();
        homePage.PSIsShown();
        homePage.enterATeacherName(teachersName);
        homePage.choseTeacherOfList(homePage.teacherProfileLink);
        homePage.clickOfTeacherProfileBtn();
    }

    @Step("Check students avatar changed")
    public static void CheckStudentAvatar() {
        studentProfilePage.imageChanged();
    }

    @Step("Check teachers avatar changed")
    public static void CheckTeacherAvatar() {
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
        studentProfilePage.studentsNameIsShown().shouldHave(text(userData.getNewFull_name()));
        studentEmailsText(userData.getEmail());
        CheckStudentAvatar();
        studentProfilePage.aboutMeIsShown().shouldHave(text(userData.getAboutMe()));
        studentProfilePage.majorNameIsShown().shouldHave(text(userData.getMajor()));
    }

    @Step("Check teacher all fields of update profile form changed")
    public static void CheckTeacherAllFieldsChange(User userData) {
        professorProfilePage.professorProfileIsShow();
        professorProfilePage.teacherName().shouldHave(text(userData.getNewFull_name()));
        professorProfilePage.teacherAboutMe().shouldHave(text(userData.getAboutMe()));
        teacherEmailsText(userData.getEmail());
        professorProfilePage.teacherImageChanged();
    }

    @Step("Go to profile check Avatar")
    public void goToProfileCheckAvatar(String role, String studentsName, String teacherName, User userData) {
        if (role.equals("student")) {
            goToStudentDirectory(studentsName);
            CheckStudentAvatar();
            returnStudentOldPhoto(userData);
        } else if (role.equals("teacher")) {
            goToProfessorSpotlight(teacherName);
            CheckTeacherAvatar();
            returnTeacherOldPhoto(userData);
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
        studentProfilePage.studentsEmailIsShown().shouldHave(Condition.text(textEmailStudent));
    }

    @Step("teachers email text")
    public static void teacherEmailsText(String textEmailTeacher) {
        professorProfilePage.teacherEmail().shouldHave(Condition.text(textEmailTeacher));
    }

    @Step("check create user via UI")
    public static void checkCreatedUserViaUI() {
        headerMenu.clickSignInBtn();
        signInPage.signIn("faker@gmail.com", "123456");
        homePageUser.getUsersHomePageElement().shouldHave(text("NoCode University at a glance"));
    }

    @Step("check delete user via UI")
    public static void checkDeletedUserViaUI() {
        headerMenu.clickSignInBtn();
        signInPage.signIn("faker@gmail.com", "123456");
        signInPage.confirmErrorMessage().shouldHave(text("Invalid email or password"));
    }

    @Step("return old students photo")
    public static void returnStudentOldPhoto(User userData) {
        headerMenuUser.clickMyProfile();
        updateProfilePage.setPhoto(userData.getOldPhoto());
        updateProfilePage.clickUpdateProfileBtn();
        updateProfilePage.refreshPage();
    }

    @Step("return old teachers photo")
    public static void returnTeacherOldPhoto(User userData) {
        headerMenuUser.clickMyProfile();
        updateProfilePage.setPhoto(userData.getOldPhoto());
        updateProfilePage.clickUpdateProfileBtn();
        updateProfilePage.refreshPage();
    }
}
