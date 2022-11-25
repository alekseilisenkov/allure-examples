package com.alexlis.tests;

import com.alexlis.allure.JiraIssue;
import com.alexlis.allure.Layer;
import com.alexlis.allure.Microservice;
import com.alexlis.allure.TM4J;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("Lisenkov")
@Feature("GitHub")
public class GitHubWebTests extends TestBase {

    @Test
    @JiraIssue("AUTO-1180")
    @Layer("High layer")
    @Microservice("Repository")
    @AllureId("13191")
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
    @JiraIssue("AUTO-1180")
    @Layer("High layer")
    @Microservice("Repository")
    @AllureId("13193")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Team page check")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Open Team page")
    public void testGoToTeamPage() {
        pages.openMainPage();
        pages.pushButtonByText("Team");
        pages.checkText();
    }

    @Test
    @JiraIssue("AUTO-1180")
    @Layer("Low layer")
    @TM4J("")
    @Microservice("Repository_2")
    @AllureId("13194")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Main page text check")
    @DisplayName("Check login page")
    public void testSignUpForFreeTeamPage() {
        pages.openMainPage();
        pages.checkMainPageValue();
    }

    @Test
    @JiraIssue("AUTO-1180")
    @Layer("Low layer")
    @Microservice("Repository_2")
    @AllureId("13192")
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
