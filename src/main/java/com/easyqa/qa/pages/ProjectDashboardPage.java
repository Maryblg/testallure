package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ProjectDashboardPage {
    @FindBy(xpath = "//h2[.='Project Overview']")
    public SelenideElement ProjectOverview;

    @FindBy(xpath = "//span[@class='icon-issues-icon']")
    public SelenideElement issueLink;

    @Step
    public void chekProjectDashboardPage() {
        ProjectOverview.shouldBe(Condition.visible);
    }

    @Step
    public IssuePage openIssues() {
        issueLink.click();
        ;
        return page(IssuePage.class);
    }


}
