package automation.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import automation.utils.utilities;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import automation.utils.driverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class testCase1 {
    private WebDriver driver = driverFactory.getDriver();
    private WebDriverWait wait = driverFactory.getWait();
    private Faker faker = driverFactory.getFaker();

    private String fakeFirstName;


    @Given("I am on the homepage DEMOQA")
    public void iAmOnTheHomepageDEMOQA() {
    }

    @Then("I go to Element test page")
    public void iGoToElementTestPage() {
        By button = By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[name()='svg']");
        utilities.safeClick(driver, button);
    }

    @And("I click on Text Box test")
    public void iClickOnTextBoxTest() {
        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);

        utilities.loading(1000);
        By buttonTextBox = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
        utilities.safeClick(driver, buttonTextBox);
    }

    @And("I fill full name, email, Current Address, Permanent Address with fake data")
    public void iFillFullNameEmailCurrentAddressPermanentAddressWithFakeData() {
        String fullname = utilities.generateFullName();
        By nameBox = By.id("userName");
        utilities.sendKeys(driver, nameBox, fullname);

        String email = utilities.generateEmail();
        By emailBox = By.id("userEmail");
        utilities.sendKeys(driver, emailBox, email);

        String currentAddress = utilities.generateAddress();
        By currentAddressBox = By.id("currentAddress");
        utilities.sendKeys(driver, currentAddressBox, currentAddress);

        String permanentAddress = utilities.generateAddress();
        By permanentAdressBox = By.id("permanentAddress");
        utilities.sendKeys(driver, permanentAdressBox, permanentAddress);
    }

    @Then("I click on submit form button")
    public void iClickOnSubmitFormButton() {
//        WebElement middle = driver.findElement(By.id("submit"));

        By submitForm = By.id("submit");
        utilities.findElement(driver, submitForm, "center");
        utilities.safeClick(driver, submitForm);

        utilities.loading(1000);

        String submitFormText = utilities.getElementTextSafe(driver, By.xpath("//*[@id=\"output\"]/div"), "Message Not Found");
        System.out.println(submitFormText);
    }

    @Given("I am on the DEMOQA homepage")
    public void iAmOnTheDEMOQAHomepage() {
        driver.get("https://demoqa.com/");

    }

    @Then("I on Check Box test")
    public void iOnCheckBoxTest() {

        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);

        utilities.loading(1000);
        By buttonTextBox = By.xpath("//span[normalize-space()='Check Box']");
        utilities.safeClick(driver, buttonTextBox);
    }

    @And("I click on Home drag down button")
    public void iClickOnHomeDragDownButton() {
        By homeToggle = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button");
        utilities.safeClick(driver, homeToggle);
    }

    @And("I click on Desktop drag down button")
    public void iClickOnDesktopDragDownButton() {
        By desktopToggle = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button");
        utilities.safeClick(driver, desktopToggle);
    }

    @And("I click on Documents drag down button")
    public void iClickOnDocumentsDragDownButton() {
        By desktopToggle = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button");
        utilities.safeClick(driver, desktopToggle);
    }

    @And("I click on Download drag down button")
    public void iClickOnDownloadDragDownButton() {
        By desktopToggle = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button");
        utilities.safeClick(driver, desktopToggle);
    }

    @When("I click on all check boxes")
    public void iClickOnAllCheckBoxes() {
        List<By> multipleButton = Arrays.asList(
                By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]"),
                By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]"),
                By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/label/span[1]"),
                By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/label/span[1]"),
                By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label/span[1]"),
                By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]")
        );
        utilities.clickMultipleElements(driver, multipleButton);
    }

    @Then("I should get the selected box name list")
    public void iShouldGetTheSelectedBoxNameList() {
        By resultBox = By.id("result");
        WebElement resultBoxElement = driver.findElement(resultBox);
        utilities.findElement(driver, resultBox, "center");
        String submitCheckBox = utilities.getElementTextSafe(driver, By.id("result"), "Message Not Found");
        System.out.println(submitCheckBox);
    }

    @Given("I on radio test")
    public void iOnRadioTest() {
        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);

        utilities.loading(1000);
        By buttonTextBox = By.xpath("//span[normalize-space()='Radio Button']");
        utilities.safeClick(driver, buttonTextBox);
    }

    @Then("I click on Yes button")
    public void iClickOnYesButton() {
        By yesButton = By.xpath("//label[@for='yesRadio']");
        utilities.safeClick(driver, yesButton);

    }

    @And("I should see radio button message")
    public void iShouldSeeRadioButtonMessage() {
        String submitCheckBox = utilities.getElementTextSafe(driver, By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/p"), "Message Not Found");
        System.out.println(submitCheckBox);
    }

    @Then("I click on Impresssive button")
    public void iClickOnImpresssiveButton() {
        By impressiveButton = By.xpath("//label[@for='impressiveRadio']");
        utilities.safeClick(driver, impressiveButton);

    }

    @When("I click on No Button")
    public void iClickOnNoButton() {
        By noButton = By.id("//label[@for='noRadio']");
        utilities.isElementPresent(driver, noButton, 100);

    }

    @Then("The button cannot be pressed")
    public void theButtonCannotBePressed() {
        String noButton = utilities.getElementTextSafe(driver, By.xpath("//label[@for='noRadio']"), "Message Not Found");
        System.out.println(noButton);

    }

    @Given("I am on Web Tables test")
    public void iAmOnWebTablesTest() {
        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);

        utilities.loading(1000);
        By webTablesBox = By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']");
        utilities.safeClick(driver, webTablesBox);
    }

    @Then("I should add data")
    public void iShouldAddData() {
        By addData = By.id("addNewRecordButton");
        utilities.safeClick(driver, addData);
    }

    @And("I fill First Name")
    public void iFillFirstName() {
        String fakeFirstName = faker.name().firstName();
        By firstNameBox = By.id("firstName");
        utilities.sendKeys(driver, firstNameBox, fakeFirstName);
    }

    @And("I fill Last Name")
    public void iFillLastName() {
        String fakeLastName = faker.name().lastName();
        By lastNameBox = By.id("lastName");
        utilities.sendKeys(driver, lastNameBox, fakeLastName);
    }

    @And("I fill email")
    public void iFillEmail() {
        String fakeEmail = faker.internet().emailAddress();
        By emailBox = By.id("userEmail");
        utilities.sendKeys(driver, emailBox, fakeEmail);
    }

    @And("I fill age")
    public void iFillAge() {
        int age = faker.number().numberBetween(20, 33);
        String fakeAge = String.valueOf(age);
        By ageBox = By.id("age");
        utilities.sendKeys(driver, ageBox, fakeAge);
    }

    @And("I fill salary")
    public void iFillSalary() {
        int salary = faker.number().numberBetween(1000, 5000);
        String fakeSalary = String.valueOf(salary);
        By salaryBox = By.id("salary");
        utilities.sendKeys(driver, salaryBox, fakeSalary);
    }

    @And("I fill departement")
    public void iFillDepartement() {
        String fakeDepartment = faker.address().city();
        By departmentBox = By.id("department");
        utilities.sendKeys(driver, departmentBox, fakeDepartment);
    }

    @When("I click on submit registration form")
    public void iClickOnSubmitRegistrationForm() {
        By submitRegistrationForm = By.id("submit");
        utilities.safeClick(driver, submitRegistrationForm);
    }

    @Then("I should see the data form")
    public void iShouldSeeTheDataForm() {
        String rowData = utilities.getElementTextSafe(driver, By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div"), "Message Not Found");
        System.out.println(rowData);
    }

    @When("I search {string}")
    public void iSearch(String cierra) {
        By seachBox = By.id("searchBox");
        utilities.sendKeys(driver, seachBox, cierra);
    }

    @Then("I should see Cierra data")
    public void iShouldSeeCierraData() {
        String rowData = utilities.getElementTextSafe(driver, By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]"), "Message Not Found");
        System.out.println(rowData);
    }

    @Then("I change form row to {int} to {int}")
    public void iChangeFormRowToTo(int arg0, int arg1) {
        utilities.selectDropdownByVisibleText(driver, By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select"), "100 rows");
        By resultBox = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select");
        utilities.findElement(driver, resultBox, "center");

        utilities.selectDropdownByVisibleText(driver, By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select"), "50 rows");
        utilities.selectDropdownByVisibleText(driver, By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select"), "25 rows");
        utilities.selectDropdownByVisibleText(driver, By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select"), "20 rows");
        utilities.selectDropdownByVisibleText(driver, By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select"), "5 rows");

    }

    @When("I change Cierra first name to {string}")
    public void iChangeCierraFirstNameTo(String cierra) {
        By editData = By.xpath("//*[@id=\"edit-record-1\"]");
        utilities.safeClick(driver, editData);
        By firstNameBox = By.id("firstName");
        utilities.sendKeys(driver, firstNameBox, cierra);

    }


    @Then("I should see Cierra data that changed to {string}")
    public void iShouldSeeCierraDataThatChangedTo(String cierra) {
        By seachBox = By.id("searchBox");
        utilities.sendKeys(driver, seachBox, cierra);
        driver.navigate().refresh();
    }

    @Given("I am on Buttons test")
    public void iAmOnButtonsTest() {
        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);
        utilities.loading(1000);
        By buttonTest = By.xpath("//span[normalize-space()='Buttons']");
        utilities.safeClick(driver, buttonTest);
    }

    @When("I click on Double Click Me button")
    public void iClickOnDoubleClickMeButton() {
        By doubleClick = By.id("doubleClickBtn");
        utilities.doubleClick(driver, doubleClick);
    }

    @Then("I should see input double click message")
    public void iShouldSeeInputDoubleClickMessage() {
        String doubleClickMessage = utilities.getElementTextSafe(driver, By.id("doubleClickMessage"), "Message Not Found");
        System.out.println(doubleClickMessage);
    }

    @And("I click on Right Click Me button")
    public void iClickOnRightClickMeButton() {
        By rightClickButton = By.id("rightClickBtn");
        utilities.safeRightClick(driver, rightClickButton);
    }

    @Then("I should see input right click message")
    public void iShouldSeeInputRightClickMessage() {
        String rightClickMessage = utilities.getElementTextSafe(driver, By.id("rightClickMessage"), "Message Not Found");
        System.out.println(rightClickMessage);
    }

    @And("I click on Click Me button")
    public void iClickOnClickMeButton() {
        By dynamicClick = By.xpath("//button[text()='Click Me']");
        utilities.getElementTextSafe(driver, dynamicClick, "Button Not Found");
        System.out.println(dynamicClick);
        utilities.safeClick(driver, dynamicClick);
    }

    @Then("I should see input click message")
    public void iShouldSeeInputClickMessage() {
        String dynamicClickMessage = utilities.getElementTextSafe(driver, By.id("dynamicClickMessage"), "Message Not Found");
        System.out.println(dynamicClickMessage);
    }

    @Given("I am on Links test")
    public void iAmOnLinksTest() {
        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);
        utilities.loading(1000);
        By buttonTest = By.xpath("//span[normalize-space()='Links']");
        utilities.safeClick(driver, buttonTest);
    }

    @When("I click on Home link")
    public void iClickOnHomeLink() {
        By homeLink = By.id("simpleLink");
        utilities.safeClick(driver, homeLink);

    }

    @Then("I should be in different windows tab")
    public void iShouldBeInDifferentWindowsTab() {
        driver.getTitle();
        assertEquals("DEMOQA", driver.getTitle());
    }

    @And("I go back to maintab")
    public void iGoBackToMaintab() {
        utilities.switchToWindowWithTitle(driver, "DEMOQA");
    }

    @Then("I click on HomehrToG link")
    public void iClickOnHomehrToGLink() {
        By dynamicLink = By.id("dynamicLink");
        utilities.safeClick(driver, dynamicLink);

    }

    @When("I click on Created link")
    public void iClickOnCreatedLink() {
        utilities.loading(500);
        By createdLink = By.id("created");
        utilities.findElement(driver, createdLink, "center");
        utilities.safeClick(driver, createdLink);
    }

    @Then("I should see link respone code")
    public void iShouldSeeLinkResponeCode() {
        utilities.loading(500);
        String linkResponseMessage = utilities.getElementTextSafe(driver, By.id("linkResponse"), "Message Not Found");
        System.out.println(linkResponseMessage);

    }

    @And("I click on No Content")
    public void iClickOnNoContent() {
        utilities.loading(500);
        By noContentLink = By.id("no-content");
        utilities.findElement(driver, noContentLink, "center");
        utilities.safeClick(driver, noContentLink);

    }

    @And("I click on Moved link")
    public void iClickOnMovedLink() {
        utilities.loading(500);
        By movedLink = By.id("moved");
        utilities.findElement(driver, movedLink, "center");
        utilities.safeClick(driver, movedLink);
    }

    @And("I click on Bad Request link")
    public void iClickOnBadRequestLink() {
        utilities.loading(500);
        By badRequestLink = By.id("bad-request");
        utilities.findElement(driver, badRequestLink, "center");
        utilities.safeClick(driver, badRequestLink);
    }

    @And("I click on Unauthorized link")
    public void iClickOnUnauthorizedLink() {
        utilities.loading(500);
        By unauthorizedLink = By.id("unauthorized");
        utilities.findElement(driver, unauthorizedLink, "center");
        utilities.safeClick(driver, unauthorizedLink);

    }

    @And("I click on Forbidden link")
    public void iClickOnForbiddenLink() {
        utilities.loading(500);
        By forbiddenLink = By.id("forbidden");
        utilities.findElement(driver, forbiddenLink, "center");
        utilities.safeClick(driver, forbiddenLink);
    }

    @And("I click on Not Found link")
    public void iClickOnNotFoundLink() {
        utilities.loading(500);
        By noFoundLink = By.id("invalid-url");
        utilities.findElement(driver, noFoundLink, "center");
        utilities.safeClick(driver, noFoundLink);
    }

    @Given("I am on Broken link image and link")
    public void iAmOnBrokenLinkImageAndLink() {
        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);
        utilities.loading(1000);
        By buttonTest = By.xpath("//span[normalize-space()='Broken Links - Images']");
        utilities.safeClick(driver, buttonTest);
    }

    @When("I check image validation")
    public void iCheckImageValidation() {
        List<WebElement> images = driver.findElements(By.tagName("img"));

        for (WebElement image : images) {
            String url = image.getAttribute("src");
            iShouldSeeTheValidationImage(url);
        }
    }

    @Then("I should see the validation image {string}")
    public void iShouldSeeTheValidationImage(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - is a broken image");
            }
        } catch (Exception e) {
            System.out.println(url + " - is a broken image");
        }
    }


    @And("I check link validation")
    public void iCheckLinkValidation()  {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            iShouldSeeValidationLink(url);
        }
    }

    @Then("I should see validation link {string}")
    public void iShouldSeeValidationLink(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();


            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link");
        }
    }

    @Given("I am on Upload and Download test")
    public void iAmOnUploadAndDownloadTest() {
        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);
        utilities.loading(1000);
        By downloadTest = By.xpath("//span[normalize-space()='Upload and Download']");
        utilities.safeClick(driver, downloadTest);
    }

    @When("I click on download button")
    public void iClickOnDownloadButton() {
        WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("downloadButton")));
        downloadButton.click();
        downloadButton.sendKeys(Keys.ENTER);
    }

    @Then("I download the file")
    public void iDownloadTheFile() {
        System.out.println("File Downloaded");
        }

    @And("I click on upload button")
    public void iClickOnUploadButton() {
        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadFile")));
        uploadButton.sendKeys("C:\\Users\\Ray\\IdeaProjects\\DEMOQA\\src\\test\\resources\\material\\test.txt");
    }

    @Then("I uploaded file")
    public void iUploadedFile() {
        System.out.println("File Uploaded");

    }

    @Given("I am on Dynamic Properties test")
    public void iAmOnDynamicPropertiesTest() {
        By dropElementBox = By.xpath("//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
        utilities.clickMultipleTimes(driver, dropElementBox, 2, 800);
        utilities.loading(1000);
        By downloadTest = By.xpath("//span[normalize-space()='Dynamic Properties']");
        utilities.safeClick(driver, downloadTest);
    }

    @When("I wait {int} second until button interactable")
    public void iWaitSecondUntilButtonInteractable(int seconds) {
        By enableButton = By.id("enableAfter");
        utilities.isElementPresent(driver,enableButton,100);

        WebElement beforeColorChage = driver.findElement(By.id("colorChange"));
        String color = beforeColorChage.getCssValue("color");
        System.out.println("Warna teks: " + color);



        utilities.loading(6000);
    }

    @Then("I the button should be interactable")
    public void iTheButtonShouldBeInteractable() {
        By enabledButton = By.id("enableAfter");
        utilities.isElementPresent(driver,enabledButton,100);
    }

    @And("I should see button color change")
    public void iShouldSeeButtonColorChange() {
        WebElement afterColorChage = driver.findElement(By.id("colorChange"));
        String color = afterColorChage.getCssValue("color");
        System.out.println("Warna teks: " + color);
    }

    @And("I should see new button appear")
    public void iShouldSeeNewButtonAppear() {
        By visibleButton = By.id("visibleAfter");
        utilities.isElementPresent(driver,visibleButton,100);

    }
}

