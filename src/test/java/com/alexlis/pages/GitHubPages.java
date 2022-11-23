package com.alexlis.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GitHubPages {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    public String getRepo() {
        return REPOSITORY;
    }

    SelenideElement searchInput = $(".header-search-input");
    SelenideElement bestBuildForm = $(".h1-mktg");
    SelenideElement signUpButton = $(".btn-large-mktg");
    SelenideElement createTextCheckForm = $(".container-md");
    SelenideElement continueButton = $(".js-pricing-upgrade-path");
    SelenideElement loginForm = $(".text-mono");

    @Step("Open main page GitHubCom")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Search repository {repository}")
    public void searchForRepository(String repository) {
        searchInput.click();
        searchInput.sendKeys(repository);
        searchInput.pressEnter();
    }

    @Step("GOTO {repository}")
    public void openRepository(String repository) {
        $(linkText(repository)).should(Condition.visible);
    }

    @Step("Нажать на ссылку Team в меню")
    public void pushButtonByText(String text) {
        $(linkText(text)).scrollTo().click();
    }

//    @Step("Открыть вкладку Issues")
//    public void openIssuesTub() {
//        $(partialLinkText("Issues")).should(Condition.visible);
//    }

    @Step("Проверить отображение «Build like the best teams on the planet»")
    public void checkText() {
        bestBuildForm.shouldHave(Condition.text("Build like the best teams on the planet"));
    }

    @Step("Проверить отображение вложенного текста на странице вкладки Team")
    public void checkTextInside() {
        bestBuildForm.shouldHave(Condition.text("With CI/CD, Dependabot, and the world’s largest developer community," +
                " GitHub gives your team everything they need to ship better software faster."));
    }
    @Step("Проверить отображение «Welcome to GitHub!»")
    public void checkLoginPage() {
        loginForm.shouldHave(Condition.text("Welcome to GitHub!"));
    }


//    @Step("Проверить issue")
//    public void shouldSeeIssueNumber() {
//        $("#issue_81_link").should(Condition.visible);
//    }

    @Step("Нажать на кнопку «Sign up for free»")
    public void signUpButtonPush() {
        signUpButton.click();
    }

    @Step("Проверить отображение «Create your account»")
    public void createAccountCheck() {
        createTextCheckForm.shouldHave(Condition.text("Join GitHub\n" +
                "First, let's create your user account"));
    }

    @Step("Нажать на кнопку «Continue with Team»")
    public void pressContinue() {
        continueButton.click();
    }
}
