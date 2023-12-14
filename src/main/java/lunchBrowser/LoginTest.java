package lunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	public static void runLoginTest() {
		   WebDriver driver = WebDriverManager.getDriver();


        // Set the base URL for your application
        String baseUrl = "https://localhost:7258/Account";

        // Navigate to the login page
        driver.get(baseUrl + "/login");

        // Find the input fields and submit button
        WebElement emailInput = driver.findElement(By.name("EmailAddress"));
        WebElement passwordInput = driver.findElement(By.name("Password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter your test email address and password
        emailInput.sendKeys("admin@etickets.com");
        passwordInput.sendKeys("Coding@1234?");

        // Click the login button
        loginButton.click();

        // You can add assertions here to check if the login was successful or handle the response accordingly
        // For example, you might want to check if the error message is displayed in case of invalid credentials
        // WebElement errorMessage = driver.findElement(By.cssSelector(".alert-danger"));
        // assertTrue(errorMessage.getText().contains("Invalid credentials"));
        // Introduce a delay of 5 seconds (5000 milliseconds)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    }

}
