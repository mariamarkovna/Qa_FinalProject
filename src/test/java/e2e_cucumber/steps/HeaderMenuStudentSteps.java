package e2e_cucumber.steps;

import pages.HeaderMenuUser;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.page;

public class HeaderMenuStudentSteps implements En {
    HeaderMenuUser headerMenuUser;

    public HeaderMenuStudentSteps() {
        When("user icon shows that we're logged in", () -> {
            headerMenuUser = page(HeaderMenuUser.class);
            headerMenuUser.verifyAuthIcon();
        });

        Then("we click Student Directory button", () -> {
            headerMenuUser.clickStudentDirectoryBtn();
        });
    }
}
