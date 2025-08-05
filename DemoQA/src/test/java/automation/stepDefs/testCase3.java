package automation.stepDefs;

import automation.utils.driverFactory;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCase3 {

    private WebDriver driver = driverFactory.getDriver();
    private WebDriverWait wait = driverFactory.getWait();
    private Faker faker = driverFactory.getFaker();
    @Then("I go to Alert, Frame, and Windows test page")
    public void iGoToAlertFrameAndWindowsTestPage() {
        By practiceWindow = By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[3]");
        utilities.safeClick(driver, practiceWindow);
    }

//    @Given("I am on browser windows test page")
//    public void iAmOnBrowserWindowsTestPage() {
//        By windowsTest = By.xpath("//span[normalize-space()='Browser Windows']");
//        utilities.safeClick(driver,windowsTest);
//    }
//
//    @Then("I click on New Tab button")
//    public void iClickOnNewTabButton() {
//        By newTabButton = By.id("tabButton");
//        utilities.safeClick(driver, newTabButton);
//    }
//
//    @And("I should be in different windows and back to maintab")
//    public void iShouldBeInDifferentWindowsAndBackToMaintab() {
//        Object[] windowsHandles=driver.getWindowHandles().toArray();
//        driver.switchTo().window((String) windowsHandles[1]);
//        driver.getCurrentUrl();
//        assertEquals("https://demoqa.com/sample", driver.getCurrentUrl());
//        driver.close();
//    }
//
//    @When("I click on New Window")
//    public void iClickOnNewWindow() {
//        Object[] windowsHandles=driver.getWindowHandles().toArray();
//        driver.switchTo().window((String) windowsHandles[0]);
//        utilities.loading(1000);
//        By newTabButton = By.id("windowButton");
//        utilities.safeClick(driver, newTabButton);
//
//    }
//
//    @Then("I should be in new window browser and go back to maintab")
//    public void iShouldBeInNewWindowBrowserAndGoBackToMaintab() {
//        Object[] windowsHandles = driver.getWindowHandles().toArray();
//        driver.switchTo().window((String) windowsHandles[1]);
//        driver.getCurrentUrl();
//        WebElement body = driver.findElement(By.tagName("body"));
//
//        String bodyText = body.getText();
//
//        System.out.println(bodyText);
//        assertEquals("https://demoqa.com/sample", driver.getCurrentUrl());
//        driver.close();
//    }

    @Given("I am on Alert test page")
    public void iAmOnAlertTestPage() {
        By alertTest = By.xpath("//span[normalize-space()='Alerts']");
        utilities.safeClick(driver,alertTest);
    }

    @Then("I click on first alert and click OK")
    public void iClickOnFirstAlertAndClickOK() {
        By alert1 = By.id("alertButton");
        utilities.safeClick(driver,alert1);
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        utilities.acceptAlert(driver);
    }

    @And("I click on second alert, wait for five seconds then click OK")
    public void iClickOnSecondAlertWaitForFiveSecondsThenClickOK() {
        By alert2 = By.id("timerAlertButton");
        utilities.safeClick(driver,alert2);
        utilities.loading(5500);
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        utilities.acceptAlert(driver);
    }

    @And("I click on confirm alert")
    public void iClickOnConfirmAlert() {
        By alert3 = By.id("confirmButton");
        utilities.safeClick(driver, alert3);
        String confirmMessage = driver.switchTo().alert().getText();
        System.out.println(confirmMessage);
        utilities.dismissAlert(driver); //
        By confirmMessageResult = By.xpath("//span[@id='confirmResult']");
        utilities.getElementTextSafe(driver, confirmMessageResult, "Message Not Found");

    }
    @And("I click prompt box alert and fill {string}")
    public void iClickPromptBoxAlertAndFill(String name) {
        By alert4 = By.id("promtButton");
        utilities.safeClick(driver,alert4);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();
    }

    @Given("I am on Frames test page")
    public void iAmOnFramesTestPage() {
        By frameTest = By.xpath("//span[normalize-space()='Frames']");
        utilities.safeClick(driver, frameTest);
    }

    @Then("I switch to iframe one")
    public void iSwitchToIframeOne() {
        driver.switchTo().frame("frame1");
        String frame1Text = driver.findElement(By.tagName("body")).getText();
        System.out.println("Isi frame 1: " + frame1Text);
    }

    @And("I switch to iframe two")
    public void iSwitchToIframeTwo() {
        utilities.loading(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        String frame2Text = driver.findElement(By.tagName("body")).getText();
        System.out.println("Isi frame 2: " + frame2Text);
    }

    @Then("I go back to parent frame")
    public void iGoBackToParentFrame() {
        driver.switchTo().defaultContent();

    }

    @Given("I am on Nested Frames test page")
    public void iAmOnNestedFramesTestPage() {
        By frameTest = By.xpath("//span[normalize-space()='Nested Frames']");
        utilities.safeClick(driver, frameTest);
    }

    @Then("I switch to nested frame one")
    public void iSwitchToNestedFrameOne() {
        driver.switchTo().frame("frame1");
        String parentText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Isi frame 1: " + parentText);
    }

    @And("I switch to nested frame two")
    public void iSwitchToNestedFrameTwo() {
        WebElement childIframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(childIframe);
        WebElement pTag = driver.findElement(By.tagName("p"));
        System.out.println(pTag.getText());
    }

    @Then("I go back to nested parent frame")
    public void iGoBackToNestedParentFrame() {
        driver.switchTo().defaultContent();

    }

    @Given("I am on Modal Dialogs test page")
    public void iAmOnModalDialogsTestPage() {
        By modalTest = By.xpath("//span[normalize-space()='Modal Dialogs']");
        utilities.safeClick(driver, modalTest);
    }

    @Then("I click on Small Modal Button")
    public void iClickOnSmallModalButton() {
        By smallModalButton = By.id("showSmallModal");
        utilities.safeClick(driver,smallModalButton);
    }

    @And("I extract Small Modal text")
    public void iExtractSmallModalText() {
        By smallTextLocator = By.xpath("//div[@class='modal-body']");
        String text = utilities.getElementTextSafe(driver, smallTextLocator, "Message Not Found");
        System.out.println(text);
    }

    @And("Close Small Modal prompt")
    public void closeSmallModalPrompt() {
        By closeSmall = By.id("closeSmallModal");
        utilities.safeClick(driver, closeSmall);
    }

    @Then("I click on Large Modal Button")
    public void iClickOnLargeModalButton() {
        By largeModalButton = By.id("showLargeModal");
        utilities.safeClick(driver,largeModalButton);
    }

    @And("I extract Large Modal text")
    public void iExtractLargeModalText() {
        By modalTextLocator = By.xpath("//div[contains(@class,'modal')]//p[contains(text(),'Lorem Ipsum')]");
        String text = utilities.getElementTextSafe(driver, modalTextLocator, "Message Not Found");
        System.out.println(text);
    }

    @And("Close Large Modal prompt")
    public void closeLargeModalPrompt() {
        By closeLarge = By.id("closeLargeModal");
        utilities.safeClick(driver, closeLarge);
    }
}
