package lunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsActorTest {
	
    public static void testDetailsActorView(WebDriver driver, String actorId) {
        driver = WebDriverManager.getDriver();
		   
        // Set the base URL for your application
        String baseUrl = "https://localhost:7258/Actors";

        // Navigate to the details page
        driver.get(baseUrl + "/Details/" + actorId);
        
        WebElement actorDetails = driver.findElement(By.cssSelector(".row.text h1"));
        assert actorDetails.isDisplayed() : "Actor Details not found!";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
