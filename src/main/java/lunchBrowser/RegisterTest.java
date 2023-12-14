package lunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterTest {
	   public static void runRegisterTest() {
		   WebDriver driver = WebDriverManager.getDriver();
		   
	        String baseUrl = "https://localhost:7258/Account";

	        // Navigate to the register page
	        driver.get(baseUrl + "/register");

	        // Find the input fields and submit button
	        WebElement fullNameInput = driver.findElement(By.name("FullName"));
	        WebElement emailInput = driver.findElement(By.name("EmailAddress"));
	        WebElement passwordInput = driver.findElement(By.name("Password"));
	        WebElement confirmPasswordInput = driver.findElement(By.name("ConfirmPassword"));
	        WebElement signUpButton = driver.findElement(By.cssSelector("input[type='submit']"));

	        // Enter your test data
	        fullNameInput.sendKeys("Test Admin");
	        emailInput.sendKeys("admin@etickets.com");
	        passwordInput.sendKeys("Coding@1234?");
	        confirmPasswordInput.sendKeys("Coding@1234?");

	        // Click the sign-up button
	        signUpButton.click();

	        // You can add assertions here to check if the registration was successful or handle the response accordingly
	        // For example, you might want to check if the success message is displayed
	        // WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
	        // assertTrue(successMessage.getText().contains("Registration successful"));

	     // Introduce a delay of 5 seconds (5000 milliseconds)
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}
