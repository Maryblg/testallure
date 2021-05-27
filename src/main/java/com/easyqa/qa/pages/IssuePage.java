package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class IssuePage {
    @FindBy(xpath = "//h2[.='Issues summary']")
    public SelenideElement issuesHeader;

    @FindBy(xpath = "//a[.='Add new issue']")
    public SelenideElement addNewIssueBtn;

    @FindBy(id = "issue_summary")
    public SelenideElement issueSummary;

    @FindBy(id = "issue_description")
    public SelenideElement issueDescription;

    @FindBy(id = "type-view")
    public SelenideElement IssueTypeSelector;

    @FindBy(xpath = "//label[.='Bug']")
    public SelenideElement IssueTypeBug;

    @FindBy(id = "issue_priority")
    public SelenideElement IssuePrioritySelector;

    @FindBy(xpath = "//label[.='High']")
    public SelenideElement IssuePriorityHight;

    @FindBy(xpath = "//label[.='Low']")
    public SelenideElement IssuePriorityLow;

    @FindBy(xpath = "//label[.='Medium']")
    public SelenideElement IssuePriorityMedium;

    @FindBy(xpath = "//label[.='Critical']")
    public SelenideElement IssuePriorityCritical;


    @FindBy(name = "commit")
    public SelenideElement issueSaveBtn;

    @FindBy(xpath = "//div[@class='card_message']")
    public SelenideElement cardName;

    @Step
    public void chekIssuesPage() {
        issuesHeader.shouldBe(Condition.visible);
        addNewIssueBtn.shouldBe(Condition.visible);
    }

    @Step
    public void clickAddNewIssue() {
        addNewIssueBtn.click();
    }

    @Step
    public void setIssueTypeBug() {
        IssueTypeSelector.click();
        IssueTypeBug.click();
    }

    @Step
    public void setIssuePriorityHight() {
        IssuePrioritySelector.click();
        IssuePriorityHight.click();
    }

    @Step
    public void setIssuePriorityLow() {
        IssuePrioritySelector.click();
        IssuePriorityLow.click();
    }

    @Step
    public void setIssuePriorityMedium() {
        IssuePrioritySelector.click();
        IssuePriorityMedium.click();
    }

    @Step

    public void setIssuePriorityCritical() {
        IssuePrioritySelector.click();
        IssuePriorityCritical.click();
    }

    @Step

    public void addNewIssue(String issueName, String issueDesc, String issuePriority) {
        issueSummary.click();
        issueSummary.sendKeys(issueName);

        issueDescription.click();
        issueDescription.sendKeys(issueDesc);
        setIssueTypeBug();
        setPriority(issuePriority);
        issueSaveBtn.click();
    }

    @Step
    public void checkIssueAdded(String issueName) {
        cardName.shouldBe(Condition.text(issueName));
    }

    @Step
    public void setPriority(String priority) {
        switch (priority) {
            case "1":
                setIssuePriorityLow();
                break;
            case "2":
                setIssuePriorityMedium();
                break;
            case "3":
                setIssuePriorityHight();
                break;
            case "4":
                setIssuePriorityCritical();
                break;

        }
    }
}
