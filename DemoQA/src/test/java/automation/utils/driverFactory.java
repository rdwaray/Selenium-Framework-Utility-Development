package automation.utils;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class driverFactory {
    private static WebDriver driver;
    private static Faker faker;
    private static WebDriverWait wait;


    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);

            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public static Faker getFaker() {
        if (faker == null) {
            faker = new Faker();
        }
        return faker;
    }
    public static WebDriverWait getWait() {
        return wait;
    }

}
