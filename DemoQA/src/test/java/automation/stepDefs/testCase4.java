package automation.stepDefs;

import automation.utils.driverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import automation.utils.utilities;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class testCase4 {
    private WebDriver driver = driverFactory.getDriver();
    private WebDriverWait wait = driverFactory.getWait();
    @Then("I go to Widgets test page")
    public void iGoToWidgetsTestPage() {
        By widgetTest = By.xpath("//h5[normalize-space()='Widgets']");
        utilities.safeClick(driver, widgetTest);
    }

    @Given("I go to Accordian test page")
    public void iGoToAccordianTestPage() {
        By accordianTest = By.xpath("//span[normalize-space()='Accordian']");
        utilities.safeClick(driver, accordianTest);
    }

    @Then("I click on Accordian one")
    public void iClickOnAccordianOne() {
        By block1 = By.id("section1Heading");
        utilities.clickMultipleTimes(driver,block1,2,200);
    }

    @And("I extract Accordian one text")
    public void iExtractAccordianOneText() {
        By block1Text = By.id("section1Content");
        String blockMessage1 = utilities.getElementTextSafe(driver,block1Text,"Message Not Found");
        System.out.println(blockMessage1);
    }

    @Then("I click on Accordian two")
    public void iClickOnAccordianTwo() {
        By block2 = By.id("section2Heading");
        utilities.safeClick(driver, block2);
    }

    @And("I extract Accordian two text")
    public void iExtractAccordianTwoText() {
        By block2Text = By.id("section2Content");
        utilities.findElement(driver,block2Text, "center");
        String block2Message = utilities.getElementTextSafe(driver,block2Text,"Message Not Found");
        System.out.println(block2Message);
    }

    @Then("I click on Accordian three")
    public void iClickOnAccordianThree() {
        By block3 = By.id("section3Heading");
        utilities.safeClick(driver, block3);
        utilities.findElement(driver,block3,"center");

    }

    @And("I extract Accordian three text")
    public void iExtractAccordianThreeText() {
        By block3Text = By.id("section3Content");
        utilities.findElement(driver,block3Text,"center");
        String block3Message = utilities.getElementTextSafe(driver,block3Text,"Message Not Found");
        System.out.println(block3Message);
    }

    @Given("I go to Auto Complete Test Page")
    public void iGoToAutoCompleteTestPage() {
        By autoCompleteTest = By.xpath("//span[normalize-space()='Auto Complete']");
        utilities.safeClick(driver, autoCompleteTest);

    }

    @Then("I fill multiple form  with {string}")
    public void iFillMultipleFormWith(String color1) {
        By multipleBox = By.xpath("//div[@id='autoCompleteMultipleContainer']//input");
        utilities.sendKeys(driver,multipleBox, color1);

    }

    @And("I choose multiple color {string}")
    public void iChooseMultipleColor(String choose1) {
        By multipleBox = By.xpath("//div[@id='autoCompleteMultipleContainer']//input");
        WebElement colorChoose = driver.findElement(multipleBox);
        colorChoose.sendKeys(Keys.ENTER);
    }

    @Then("I fill multiple form again with {string}")
    public void iFillMultipleFormAgainWith(String color2) {
        By multipleBox = By.xpath("//div[@id='autoCompleteMultipleContainer']//input");
        utilities.sendKeys(driver,multipleBox, color2);
    }

    @And("I choose the next multiple color {string}")
    public void iChooseTheNextMultipleColor(String arg0) {
        By multipleBox = By.xpath("//div[@id='autoCompleteMultipleContainer']//input");
        WebElement colorChoose = driver.findElement(multipleBox);
        colorChoose.sendKeys(Keys.ENTER);
    }

    @Then("I fill single form with {string}")
    public void iFillSingleFormWith(String color3) {
        By multipleBox = By.xpath("//div[@id='autoCompleteSingleContainer']//input");
        utilities.sendKeys(driver,multipleBox, color3);
    }

    @And("I choose single color {string}")
    public void iChooseSingleColor(String colos) {
        By multipleBox = By.xpath("//div[@id='autoCompleteSingleContainer']//input");
        WebElement colorChoose = driver.findElement(multipleBox);
        colorChoose.sendKeys(Keys.ENTER);
    }

    @Given("I am on Date Picker Test")
    public void iAmOnDatePickerTest() {
        By dateTimeTest = By.xpath("//span[normalize-space()='Date Picker']");
        utilities.safeClick(driver, dateTimeTest);
    }

    @Then("I input Date")
    public void iInputDate() {
        By dateBox = By.id("datePickerMonthYearInput");
        WebElement dateInput = driver.findElement(dateBox);

        dateInput.click();
        dateInput.sendKeys(Keys.CONTROL + "a");
        dateInput.sendKeys("06/03/2021");
        dateInput.sendKeys(Keys.ENTER);
    }

    @And("I input date and time")
    public void iInputDateAndTime() {
        By dateTimeBox = By.id("dateAndTimePickerInput");
        WebElement dateInput = driver.findElement(dateTimeBox);

        dateInput.click();
        dateInput.sendKeys(Keys.CONTROL + "a");
        dateInput.sendKeys("June 3, 2021 11:59 AM");
        dateInput.sendKeys(Keys.ENTER);
    }

    @Given("I am on Slider test page")
    public void iAmOnSliderTestPage() {
        By dateTimeTest = By.xpath("//span[normalize-space()='Slider']");
        utilities.safeClick(driver, dateTimeTest);
    }


    @Then("I am changing the value of slider")
    public void iAmChangingTheValueOfSlider() {
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, 70, 0).build();
        action.perform();
    }

    @Given("I am on Progress Bar test Page")
    public void iAmOnProgressBarTestPage() {
        By progressBarTest = By.xpath("//span[normalize-space()='Progress Bar']");
        utilities.safeClick(driver, progressBarTest);
    }

    @Then("I click start progress button")
    public void iClickStartProgressButton() {
        By startButton = By.id("startStopButton");
        utilities.safeClick(driver,startButton);
    }

    @And("I click stop")
    public void iClickStop() {
        utilities.loading(2345);
        By stopButton = By.id("startStopButton");
        utilities.safeClick(driver,stopButton);
    }

    @And("I extract progress bar value")
    public void iExtractProgressBarValue() {
        By progressBar = By.cssSelector("div.progress-bar.bg-info");
        String progressValue = utilities.getElementTextSafe(driver,progressBar,"Message Not Found");
        System.out.println(progressValue);
    }

    @Given("I am on Tabs test page")
    public void iAmOnTabsTestPage() {
        By progressBarTest = By.xpath("//span[normalize-space()='Tabs']");
        utilities.safeClick(driver, progressBarTest);
    }

    @Then("I click on What Tab")
    public void iClickOnWhatTab() {
        By whatTab = By.id("demo-tab-what");
        utilities.safeClick(driver,whatTab);
        By whatMessage = By.id("demo-tabpane-what");
        utilities.getElementTextSafe(driver,whatMessage,"Message Not Found");
        System.out.println(whatMessage);
    }

    @And("I click on Origin Tab")
    public void iClickOnOriginTab() {
        By originTab = By.id("demo-tab-origin");
        utilities.safeClick(driver,originTab);
        By originMessage = By.id("demo-tabpane-origin");
        utilities.getElementTextSafe(driver,originMessage,"Message Not Found");
        System.out.println(originMessage);
    }

    @And("I click on Use Tab")
    public void iClickOnUseTab() {
        By useTab = By.id("demo-tab-use");
        utilities.safeClick(driver,useTab);
        By useMessage = By.id("demo-tabpane-use");
        utilities.getElementTextSafe(driver,useTab,"Message Not Found");
        System.out.println(useMessage);
    }

    @And("I click on More Tab")
    public void iClickOnMoreTab() {
        By moreTab = By.id("demo-tab-more");
        utilities.isElementPresent(driver,moreTab,100);
    }

    @Given("I am on Tool Tips test page")
    public void iAmOnToolTipsTestPage() {
        By progressBarTest = By.xpath("//span[normalize-space()='Tool Tips']");
        utilities.safeClick(driver, progressBarTest);
    }

    @Then("I hover mouse to element one")
    public void iHoverMouseToElementOne() {
        WebElement hoverOne = driver.findElement(By.id("toolTipButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOne).perform();

    }

    @And("I hover mouse to element two")
    public void iHoverMouseToElementTwo() {
        WebElement hoverTwo = driver.findElement(By.id("toolTipTextField"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverTwo).perform();


    }

    @And("I hover mouse to element three")
    public void iHoverMouseToElementThree() {
        WebElement hoverThree = driver.findElement(By.xpath("//a[normalize-space()='Contrary']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverThree).perform();

    }

    @And("I hover mouse to element four")
    public void iHoverMouseToElementFour() {
        WebElement hoverFour = driver.findElement(By.xpath("//a[normalize-space()='1.10.32']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverFour).perform();
    }

    @Given("I on on Menu test page")
    public void iOnOnMenuTestPage() {
        By progressBarTest = By.xpath("//span[normalize-space()='Menu']");
        utilities.safeClick(driver, progressBarTest);
    }


    @Then("I am hovering Main Item one")
    public void iAmHoveringMainItemOne() {
        WebElement menu1 = driver.findElement(By.xpath("//a[normalize-space()='Main Item 1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).perform();

    }

    @When("I am hovering Main Item two")
    public void iAmHoveringMainItemTwo() {
        WebElement menu2 = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu2).perform();


        WebElement menu2a = driver.findElement(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[@class='col-12 mt-4 col-md-6']/div[@class='nav-menu-container']/ul[@id='nav']/li/ul/li[1]/a[1]"));
        actions.moveToElement(menu2a).perform();

        WebElement menu2b = driver.findElement(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[@class='col-12 mt-4 col-md-6']/div[@class='nav-menu-container']/ul[@id='nav']/li/ul/li[2]/a[1]"));
        actions.moveToElement(menu2b).perform();

        WebElement menu2c = driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"));
        actions.moveToElement(menu2c).perform();

        WebElement menu2c1= driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 1']"));
        actions.moveToElement(menu2c1).perform();

        WebElement menu2c2= driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 2']"));
        actions.moveToElement(menu2c2).perform();


    }

    @And("I am Hovering Main Item three")
    public void iAmHoveringMainItemThree() {
        WebElement menu3 = driver.findElement(By.xpath("//a[normalize-space()='Main Item 3']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu3).perform();

    }

    @Given("I am on Select Menu test page")
    public void iAmOnSelectMenuTestPage() {
        By progressBarTest = By.xpath("//span[normalize-space()='Select Menu']");
        utilities.safeClick(driver, progressBarTest);
    }

}

