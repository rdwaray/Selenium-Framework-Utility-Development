package automation.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import automation.utils.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import automation.utils.driverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import java.util.Arrays;
import java.util.List;

public class testCase2 {

    private WebDriver driver = driverFactory.getDriver();
    private WebDriverWait wait = driverFactory.getWait();
    private Faker faker = driverFactory.getFaker();

    @Then("I go to Practice Form test page")
    public void iGoToPracticeFormTestPage() {
        By practiceTest = By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[2]");
        utilities.safeClick(driver, practiceTest);

        By practiceForm = By.xpath("//span[normalize-space()='Practice Form']");
        utilities.safeClick(driver, practiceForm);


    }

    @Given("I fill first name with fake data")
    public void iFillFirstNameWithFakeData() {
        String firstName = utilities.generateFirstName();
        By firstNameBox = By.id("firstName");
        utilities.sendKeys(driver, firstNameBox, firstName);

    }

    @And("I fill last name with fake data")
    public void iFillLastNameWithFakeData() {
        String lastName = utilities.generateLastName();
        By lastNameBox = By.id("lastName");
        utilities.sendKeys(driver, lastNameBox, lastName);

    }

    @And("I choose gender")
    public void iChooseGender() {
        By gender1 = By.xpath("//label[@for='gender-radio-1']");
        utilities.safeClick(driver,gender1);

        By gender2 = By.xpath("//label[@for='gender-radio-2']");
        utilities.safeClick(driver,gender2);

        By gender3 = By.xpath("//label[@for='gender-radio-3']");
        utilities.safeClick(driver,gender3);

        By gender4 = By.xpath("//label[@for='gender-radio-1']");
        utilities.safeClick(driver,gender4);



    }

    @And("I fill mobile number with fake data")
    public void iFillMobileNumberWithFakeData() {
        String fakeTenDigitNumber = faker.number().digits(10);
        WebElement numberBox = driver.findElement(By.id("userNumber"));
        numberBox.sendKeys(fakeTenDigitNumber);
    }

    @And("I fill date of birth with fake data")
    public void iFillDateOfBirthWithFakeData() {
        By dateBox = By.id("dateOfBirthInput");
        WebElement dateInput = driver.findElement(dateBox);

        dateInput.click();              // Fokus ke input
        dateInput.sendKeys(Keys.CONTROL + "a"); // Select all text
        dateInput.sendKeys("12 Jun 1919");      // Isi tanggal
        dateInput.sendKeys(Keys.ENTER);

    }

    @And("I fill subject with {string}")
    public void iFillSubjectWith(String Subjects) {

        By box1 = By.id("subjectsInput");
        utilities.findElement(driver, box1, "center");

        WebElement inputSubject = driver.findElement(By.id("subjectsInput"));
        inputSubject.sendKeys("Eng");

        WebElement englishOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id,'react-select') and text()='English']")));
        englishOption.click();


        }

    @And("I choose hobbies")
    public void iChooseHobbies() {

        By boxgender = By.xpath("//label[@for='hobbies-checkbox-1']");
        utilities.findElement(driver, boxgender, "center");

        List<By> multipleHobbies = Arrays.asList(
                By.xpath("//label[@for='hobbies-checkbox-1']"),
        By.xpath("//label[@for='hobbies-checkbox-2']"),
        By.xpath("//label[@for='hobbies-checkbox-3']")
        );
        utilities.clickMultipleElements(driver,multipleHobbies);

    }

    @And("I uploaded picture")
    public void iUploadedPicture() {
        By uploadBox = By.id("uploadPicture");
        utilities.findElement(driver, uploadBox, "center");

        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadPicture")));
        uploadButton.sendKeys("C:\\Users\\Ray\\IdeaProjects\\DEMOQA\\src\\test\\resources\\material\\sampleFile.jpeg");


    }

    @And("I fiil address with fake data")
    public void iFiilAddressWithFakeData() {
        String fakeAddress = utilities.generateAddress();
        By addressBox = By.id("currentAddress");
        utilities.findElement(driver, addressBox, "center");
        utilities.sendKeys(driver,addressBox,fakeAddress);

    }

    @And("I choose state {string} and {string}")
    public void iChooseStateAnd(String state, String city) {

        utilities.findElement(driver, By.id("state"), "center");

// Input STATE
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys(state);

        WebElement stateOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id,'react-select') and text()='" + state + "']")));
        stateOption.click();

// Tunggu sebentar
        utilities.loading(2000);

// Input CITY
        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys(city);

        WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id,'react-select') and text()='" + city + "']")));
        cityOption.click();
}

    @Then("I click on submit practice form")
    public void iClickOnSubmitPracticeForm() {
        By submitFormBox = By.id("submit");
        utilities.safeClick(driver,submitFormBox);

    }

}
