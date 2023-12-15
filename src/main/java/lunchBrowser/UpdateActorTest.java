package lunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateActorTest {
	
    public static void testUpdateActorView(WebDriver driver, String actorId) {
	    driver = WebDriverManager.getDriver();
	    String baseUrl = "https://localhost:7258/Actors";

	    // Navigate to the update page
	    driver.get(baseUrl + "/Edit/" + actorId);
	    
	    WebElement updateForm = driver.findElement(By.cssSelector("form[asp-action='Edit']"));
	    assert updateForm.isDisplayed() : "Update Actor form not found!";
	}
}
