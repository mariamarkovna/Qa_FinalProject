package e2e.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderMenuStudent {

    private static SelenideElement loggedInIcon= $x("//div[@class='MuiBox-root css-4tv0ih']//button[@type='button']");
    private static SelenideElement sudentDirectoryBtn = $("a.MuiButtonBase-root:nth-child(4)");

    private static SelenideElement menuProfile = $x("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiPaper-root MuiMenu-paper MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper css-19dtroz'");

    private static SelenideElement signOutBtn = $x("/html/body/div[1]/div[1]/div/div[3]/ul/a[2]");


    public SelenideElement verifyAuthIcon() {

        return $(loggedInIcon);
    }
    public void clickStudentDirectoryBtn(){

        $(sudentDirectoryBtn).click();
    }

    public SelenideElement verifyDropDownMenu(){
        return $(menuProfile);
    }

    public void clickSignOutBtn(){

        $(signOutBtn).click();
    }


}
