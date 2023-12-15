package lunchBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartTest {
	
	public static void runMovieCartTest(WebDriver driver) {
		 
    try {
        // Navigate to the page with the list of movies
        driver.get("https://localhost:7258/Movies");
        // Use a more specific wait condition to wait for the presence of a specific element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the presence of the element with a specific XPath
        WebElement movieNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-md-4 col-xs-6']/div/div/h5")));

        // Scroll into view to ensure the element is clickable
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", movieNameElement);

        // Use a more specific XPath to locate the "Add to Cart" button based on its text
        WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(text(),'Add to Cart (Price')]"));

        // Click the "Add to Cart


        // Assert that the movie has been added to the cart
        // You may need to navigate to the cart page and check if the added movie is listed there

        System.out.println("Movie added to the cart successfully!");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Quit the WebDriver after the test
        driver.quit();
    }
}


}
