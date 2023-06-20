package regressionTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import model.Helper;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    HomePage homePage = new HomePage();
    HomePageUser homePageUser = new HomePageUser();
    HeaderMenu headerMenu = new HeaderMenu();
    HeaderMenuUser headerMenuUser = new HeaderMenuUser();
    SignInPage signInPage = new SignInPage();
    UpdateProfilePage updateProfilePage = new UpdateProfilePage();
    ProfessorProfilePage professorProfilePage = new ProfessorProfilePage();
    StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
    StudentProfilePage studentProfilePage = new StudentProfilePage();
    Helper helper = new Helper();


    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        open("https://erich416.softr.app");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
