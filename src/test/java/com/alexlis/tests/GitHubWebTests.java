package com.alexlis.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("Lisenkov")
@Feature("GitHub")
public class GitHubWebTests extends TestBase {


    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Search allure repo")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Search Issue in Allure-Example repository")
    public void searchAllureExampleIssueTest() {
        pages.openMainPage();
        pages.searchForRepository(pages.getRepo());
        pages.openRepository(pages.getRepo());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Team Page")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Open Team page")
    public void testGoToTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.checkText();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Team Page")
    @DisplayName("Assertion of text on Team page inside")
    public void testAssertTextOnTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.checkTextInside();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Team Page")
    @DisplayName("Check login page")
    public void testSignUpForFreeTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.signUpButtonPush();
        pages.checkLoginPage();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Team Page")
    @DisplayName("Check create account button")
    public void testContinueWithTeamOnTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.pressContinue();
        pages.createAccountCheck();
    }
}
