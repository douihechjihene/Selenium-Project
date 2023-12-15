package lunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListOfActorsTest {
	
	   public static void testListOfActorsView(WebDriver driver) {
		    driver = WebDriverManager.getDriver();
		   
	        // Set the base URL for your application
	        String baseUrl = "https://localhost:7258/Actors";

	        // Navigate to the list page
	        driver.get(baseUrl + "/Index");
	        WebElement actorTable = driver.findElement(By.cssSelector("table.table"));
	        assert actorTable.isDisplayed() : "List of Actors table not found!";
	    }

}
