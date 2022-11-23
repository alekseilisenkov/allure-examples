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
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search from main Page")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Search Issue in Allure-Example repository")
    public void searchAllureExampleIssueTest() {
        pages.openMainPage();
        pages.searchForRepository(pages.getRepo());
        pages.openRepository(pages.getRepo());
//        pages.openIssuesTub();
//        pages.shouldSeeIssueNumber();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("Team Page")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Open Team page")
    public void testGoToTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.checkText();
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
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
    @Severity(SeverityLevel.BLOCKER)
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
