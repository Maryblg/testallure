import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.easyqa.qa.pages.*;
import com.easyqa.qa.pages.util.CardData;
import com.easyqa.qa.pages.util.UserData;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest {
 /* private WebDriver driver;/*
   private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();*/

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
       /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);*/
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserCapabilities.setAcceptInsecureCerts(true);
        Configuration.browser = "chrome";
       // Configuration.browserSize = "1600x1000";
    }

    @Test
    public void loginAsRegistrereadUser() {
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
        loginPage.enterLogin("maryamguxi@gmail.com");
        loginPage.enterPassword("45test45");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();

/*
      Selenide.$(UIMap.login).click();
      Selenide.$(UIMap.login).clear();
      Selenide.$(UIMap.login).sendKeys("maryamguxi@gmail.com");

      Selenide.$(UIMap.password).click();
      Selenide.$(UIMap.password).clear();
      Selenide.$(UIMap.password).sendKeys("45test45");

      Selenide.$(UIMap.loginBtn).click();

       Selenide.$(By.id("user_email")).click();
      Selenide.$(By.id("user_email")).clear();
      Selenide.$(By.id("user_email")).sendKeys("maryamguxi@gmail.com");

        Selenide.$(By.id("user_password")).click();
        Selenide.$(By.id("user_password")).clear();
        Selenide.$(By.id("user_password")).sendKeys("45test45");

        Selenide.$(By.name("commit")).click();
    driver.get("https://app.geteasyqa.com/users/sign_in");
        driver.findElement(By.id("user_email")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("maryamguxi@gmail.com");
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("45test45");
        driver.findElement(By.name("commit")).click();*/
    }

@Test

public void openProjects(){
    LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
    loginPage.enterLogin("maryamguxi@gmail.com");
    loginPage.enterPassword("45test45");
    DashboardPage dashboardPage = loginPage.clickLoginBtn();
    dashboardPage.checkUserAuthorized();
    ProjectsPage projectsPage = dashboardPage.openMyProjects();
    projectsPage.chekProjectsPages();
}

    @Test
    public void createCard(){
        CardData issue = new CardData("test5", "test description8", "1");
        UserData userdate = new UserData("maryamguxi@gmail.com", "45test45","https://app.geteasyqa.com/users/sign_in" );
        LoginPage loginPage = open(userdate.getAuthPage(), LoginPage.class);
        loginPage.enterLogin(userdate.getUserName());
        loginPage.enterPassword(userdate.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.chekProjectsPages();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.chekProjectDashboardPage();
        IssuePage issuePage = projectDashboardPage.openIssues();
        issuePage.chekIssuesPage();
        issuePage.clickAddNewIssue();
        issuePage.addNewIssue(issue.getCardName(), issue.getCardDescription(), issue.getCardPriority());
        issuePage.checkIssueAdded(issue.getCardName());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        /*driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);*/
        close();
    }
/*
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }*/
}

