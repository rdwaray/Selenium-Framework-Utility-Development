package automation.base;

import org.openqa.selenium.WebDriver;
import automation.utils.driverFactory;

public class baseTest {
    protected WebDriver driver;

    public void setUp() {
        driver = driverFactory.getDriver();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
