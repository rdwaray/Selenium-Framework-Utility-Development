package automation.utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class utilities {
    private static final Faker faker = new Faker();


    // ==================== WebElement Utilities ====================

    // Menunggu elemen terlihat (timeout dalam milliseconds)
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutMillis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutMillis));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Klik kiri menggunakan JavaScript
    public static void clickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // Safe klik kiri dengan fallback JS
    public static void safeClick(WebDriver driver, By locator) {
        try {
            waitForElementVisible(driver, locator, 800).click();
        } catch (Exception e) {
            System.err.println("[ERROR] Klik biasa gagal, coba klik dengan JS untuk locator: " + locator);
            WebElement el = driver.findElement(locator);
            clickWithJS(driver, el);
        }
    }

    // Klik kiri berkali kali
    public static void clickMultipleTimes(WebDriver driver, By locator, int times, int delayMillis) {
        for (int i = 0; i < times; i++) {
            safeClick(driver, locator);
            loading(delayMillis);
        }
    }

    // Double klik (kadang tidak bisa dengan fungsi diatas)
    public static void doubleClick(WebDriver driver, By locator){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.doubleClick(element).perform();
    }

    public static void rightClickWithJS(WebDriver driver, WebElement element) {
        String script = "var event = new MouseEvent('contextmenu', {" +
                "bubbles: true, cancelable: true, view: window" +
                "}); arguments[0].dispatchEvent(event);";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }


    public static void safeRightClick(WebDriver driver, By locator) {
        try {
            WebElement element = waitForElementVisible(driver, locator, 800);
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();  // Klik kanan
        } catch (Exception e) {
            System.err.println("[ERROR] Klik kanan biasa gagal, coba pakai JS untuk locator: " + locator);
            WebElement el = driver.findElement(locator);
            rightClickWithJS(driver, el);
        }
    }

    // Loading Delay
    public static void loading(int timeoutMillis) {
        try {
            Thread.sleep(timeoutMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread terinterupsi saat menunggu " + timeoutMillis + "ms");
        }
    }

    // Input teks ke elemen
    public static void sendKeys(WebDriver driver, By locator, String text) {
        WebElement element = waitForElementVisible(driver, locator, 800);
        element.clear();
        element.sendKeys(text);
    }

    // Pilih dropdown by visible text
    public static void selectDropdownByVisibleText(WebDriver driver, By locator, String text) {
        WebElement dropdown = waitForElementVisible(driver, locator, 800);
        new Select(dropdown).selectByVisibleText(text);
    }
    // Mencari Element
    public static void findElement(WebDriver driver, By locator, String blockPosition) {
        WebElement element = waitForElementVisible(driver, locator, 800); // atau driver.findElement(locator)
        scrollToElement(driver, element, blockPosition);
    }
    // Scroll ke elemen (posisi tengah default)
    public static void scrollToElement(WebDriver driver, WebElement element, String blockPosition) {
        if (!(blockPosition.equals("start") || blockPosition.equals("center") || blockPosition.equals("end"))) {
            blockPosition = "center";
        }
        String script = String.format("arguments[0].scrollIntoView({block: '%s'});", blockPosition);
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    // Cek apakah elemen ada (tanpa harus terlihat)
    public static boolean isElementPresent(WebDriver driver, By locator, int timeoutMillis) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutMillis));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Cek apakah elemen visible (default timeout 10 detik)
    public static boolean isVisibleElementPresent(WebDriver driver, By locator) {
        try {
            waitForElementVisible(driver, locator, 800);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    // Ambil teks dari elemen, dengan nilai default jika gagal
    public static String getElementTextSafe(WebDriver driver, By locator, String defaultValue) {
        try {
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    // Ambil teks dari alert
    public static String getAlertText(WebDriver driver) {
        try {
            return driver.switchTo().alert().getText();
        } catch (Exception e) {
            System.err.println("[ERROR] Tidak bisa switch ke alert atau ambil teks");
            return null;
        }
    }

    // Accept alert
    public static void acceptAlert(WebDriver driver) {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.err.println("[ERROR] Tidak bisa accept alert");
            throw new RuntimeException(e);
        }
    }

    // Dismiss alert
    public static void dismissAlert(WebDriver driver) {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            System.err.println("[ERROR] Tidak bisa dismiss alert");
            throw new RuntimeException(e);
        }
    }

    // Ganti window/tab berdasarkan title
    public static void switchToWindowWithTitle(WebDriver driver, String title) {
        String currentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)) {
                return;
            }
        }
        driver.switchTo().window(currentWindow);
        throw new RuntimeException("Window dengan title '" + title + "' tidak ditemukan");
    }

    // Drag & drop sederhana
    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    // Drag & drop manual
    public static void dragAndDropManual(WebDriver driver, WebElement source, WebElement target) {
        new Actions(driver).clickAndHold(source).moveToElement(target).release().perform();
    }

    // Klik multiple element
    public static void clickMultipleElements(WebDriver driver, List<By> locators) {
        for (By locator : locators) {
            safeClick(driver, locator);
        }
    }


    // ==================== Faker Data Utilities ====================

    public static String generateFullName() {
        return faker.name().fullName();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateAddress() {
        return faker.address().fullAddress();
    }

    public static String generatePhoneNumber() {return faker.phoneNumber().phoneNumber();
    }

    public static String generateCompanyName() {
        return faker.company().name();
    }

    public static String generateFirstName() { return faker.name().firstName();}

    public static String generateLastName() {return faker.name().lastName();}

    public static String generateBirthDate() {
        Date birthDate = faker.date().birthday(22, 39);
        return new SimpleDateFormat("MM/dd/yyyy").format(birthDate);
    }


    public static void sendKeys(Keys keys) {

    }
}

//// 1. waitForElementVisible
//WebElement element1 = utilities.waitForElementVisible(driver, By.id("username"), 10);
//
//// 2. clickWithJS
//WebElement button = driver.findElement(By.id("submit"));
//utilities.clickWithJS(driver, button);
//
//// 3. safeClick
//utilities.safeClick(driver, By.xpath("//button[text()='Login']"));
//
//// 4. sendKeys
//        utilities.sendKeys(driver, By.name("email"), "example@example.com");
//
//// 5. selectDropdownByVisibleText
//        utilities.selectDropdownByVisibleText(driver, By.id("country"), "Indonesia");
//
//// 6. scrollToElement
//WebElement footer = driver.findElement(By.cssSelector("footer"));
//utilities.scrollToElement(driver, footer, "center");
//
//// 7. isElementPresent (dengan timeout)
//boolean isPresent = utilities.isElementPresent(driver, By.id("popup"), 5);
//
//// 8. isElementPresent (default timeout & visible)
//boolean isVisible = utilities.isElementPresent(driver, By.className("alert"));
//
//// 9. getElementTextSafe
//String welcomeText = utilities.getElementTextSafe(driver, By.id("welcome"), "Welcome message not found");
//
//// 10. getAlertText
//String alertMessage = utilities.getAlertText(driver);
//
//// 11. acceptAlert
//utilities.acceptAlert(driver);
//
//// 12. dismissAlert
//utilities.dismissAlert(driver);
//
//// 13. switchToWindowWithTitle
//utilities.switchToWindowWithTitle(driver, "New Window Title");
//
//// 14. dragAndDrop
//WebElement source = driver.findElement(By.id("drag"));
//WebElement target = driver.findElement(By.id("drop"));
//utilities.dragAndDrop(driver, source, target);
//
//// 15. dragAndDropManual
//utilities.dragAndDropManual(driver, source, target);
//
//// 16. generateFullName
//String fullName = utilities.generateFullName();
//
//// 17. generateEmail
//String email = utilities.generateEmail();
//
//// 18. generateAddress
//String address = utilities.generateAddress();
//
//// 19. generatePhoneNumber
//String phone = utilities.generatePhoneNumber();
//
//// 20. generateCompanyName
//String company = utilities.generateCompanyName();
//String fullname = utilities.generateFullName();
//utilities.sendKeys(driver, By.name("fullname"), fullname);
//
//String email = utilities.generateEmail();
//utilities.sendKeys(driver, By.name("email"), email);
//// 21. clickMultipleTimes
//By iconButton = By.cssSelector(".icon-svg");
//utilities.clickMultipleTimes(driver, iconButton, 3, 500
//// 22. Loding
// utilities.Loading(driver, By.id("loading-spinner"), 15000); // 15 detik
