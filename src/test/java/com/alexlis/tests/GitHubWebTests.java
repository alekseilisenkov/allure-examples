package com.alexlis.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Owner("eazovtseva")
@Feature("GitHub")
public class GitHubWebTests extends TestBase {


    @Test
    @Story("Search from main Page")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Search Issue in Allure-Example repository")
    public void searchAllureExampleIssueTest() {

        pages.openMainPage();
        pages.searchForRepository(getRepo());
        pages.openRepository(getRepo());
        pages.openIssuesTub();
        pages.shouldSeeIssueNumber();
    }

    @Test
    @Story("Team Page")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Open Team page")
    public void testGoToTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.checkText();
    }

    @Test
    @Story("Team Page")
    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Check SignUpForFree button")
    public void testSignUpForFreeTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.signUpButtonPush();
        pages.createAccountCheck();
    }

    @Test
    @Story("Team Page")
    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Check Create your account button")
    public void testContinueWithTeamOnTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.pressContinue();
        pages.createAccountCheck();
    }
}
