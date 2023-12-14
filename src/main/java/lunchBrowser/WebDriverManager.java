package lunchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set the path to your ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\dsouh\\OneDrive\\Bureau\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            // Create a new instance of the ChromeDriver
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            // Close the browser window
            driver.quit();
            driver = null;
        }
    }
}
