package lunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddActorTest {
	
    public static void testAddActorView(WebDriver driver) {
        driver = WebDriverManager.getDriver();
		   
        // Set the base URL for your application
        String baseUrl = "https://localhost:7258/Actors";

        // Navigate to the list page
        driver.get(baseUrl + "/Create");

        // Find form elements
        WebElement profilePictureInput = driver.findElement(By.id("ProfilePictureURL"));
        WebElement fullNameInput = driver.findElement(By.id("FullName"));
        WebElement bioInput = driver.findElement(By.id("Bio"));
        WebElement createButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Fill in the form with test data
        profilePictureInput.sendKeys("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-YhFjA0Tguob3NdQxibv6s4WG9gTJ7KAiuOCBPOzlft7hXcBwHE8g83eOdttmqz3AdMQ&usqp=CAU");
        fullNameInput.sendKeys("Cole Sprouse");
        bioInput.sendKeys("A talented actor");

        // Click the create button
        createButton.click();
        // After submitting the form, navigate to the list page
        driver.navigate().to(baseUrl + "/Index");


        // Perform assertions based on the success or failure of the form submission
        // For demonstration, let's check if the actor table is present on the redirected page
        WebElement actorTable = driver.findElement(By.cssSelector("table.table"));
        assert actorTable.isDisplayed() : "List of Actors table not found after form submission!";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
