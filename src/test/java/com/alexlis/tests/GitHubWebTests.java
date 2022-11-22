package com.alexlis.tests;

import com.alexlis.pages.GitHubSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Owner("eazovtseva")
@Feature("GitHub")
public class GitHubWebTests extends TestBase {
    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    @Story("Search from main Page")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Search Issue in Allure-Example repository")
    public void searchAllureExampleIssueTest(){

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssuesTub();
        steps.shouldSeeIssueNumber(76);
    }

    @Test
    @Story("Team Page")
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Open Team page")
    public void testGoToTeamPage() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажать на ссылку Team в меню", () -> {
            $(linkText("Team")).click();
        });
        step("Проверить отображение «Build like the best teams on the planet»", () -> {
            $(".h1-mktg").shouldHave(Condition.text("Build like the best teams on the planet"));
        });
    }

    @Test
    @Story("Team Page")
    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Check SignUpForFree button")
    public void testSignUpForFreeTeamPage() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажать на ссылку Team в меню", () -> {
            $(linkText("Team")).click();
        });
        step("Нажать на кнопку «Sign up for free»", () -> {
            $(".btn-large-mktg").click();
        });
        step("Проверить отображение «Create your account»", () -> {
            $(".container-md").shouldHave(Condition.text("Join GitHub\n" +
                    "First, let's create your user account"));
        });
    }

    @Test
    @Story("Team Page")
    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Check Create your account button")
    public void testContinueWithTeamOnTeamPage() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажать на ссылку Team в меню", () -> {
            $(linkText("Team")).click();
        });
        step("Нажать на кнопку «Continue with Team»", () -> {
            $(".js-pricing-upgrade-path").click();
        });
        step("Проверить отображение «Create your account»", () -> {
            $(".container-md").shouldHave(Condition.text("Join GitHub\n" +
                    "First, let's create your user account\n" +
                    "Already have an account? Sign in"));
        });
    }

//    @Test
//    public void testContactSalesOnMainPage() {
//        step("Перейти на главную страницу", () -> {
//            open(baseUrl);
//        });
//        step("Нажать на кнопку «ContactSales»", () -> {
//            $(".btn-subtle-mktg").scrollIntoView(true).click();
//        });
//        step("Проверить отображение «Create your account»", () -> {
//            $(".pb-md-6").shouldHave(Condition.text("Talk to our sales team"));
//        });
//    }
}
