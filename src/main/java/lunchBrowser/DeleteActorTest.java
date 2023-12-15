package lunchBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteActorTest {

    public static void testDeleteActorView(WebDriver driver, String actorId) {
        // Navigate to the delete actor view for a specific actor
        driver = WebDriverManager.getDriver();

        // Set the base URL for your application
        String baseUrl = "https://localhost:7258/Actors";

        // Navigate to the list page
        driver.get(baseUrl + "/Delete/" + actorId);

        // Perform assertions based on the content of the delete confirmation view
        WebElement deleteConfirmationTitle = driver.findElement(By.cssSelector(".row.text h1"));
        assert deleteConfirmationTitle.isDisplayed() : "Delete Confirmation title not found!";

        // Perform assertions based on the actor details displayed for confirmation
        WebElement profilePicture = driver.findElement(By.id("ProfilePicturePreview"));
        assert profilePicture.isDisplayed() : "Profile Picture not found on Delete Confirmation view!";

        WebElement fullName = driver.findElement(By.cssSelector(".form-group label[for='FullName']"));
        assert fullName.isDisplayed() : "Full Name label not found on Delete Confirmation view!";
        WebElement fullNameValue = driver.findElement(By.cssSelector(".form-group input[asp-for='FullName']"));
        assert fullNameValue.isDisplayed() : "Full Name value not found on Delete Confirmation view!";

        WebElement bio = driver.findElement(By.cssSelector(".form-group label[for='Bio']"));
        assert bio.isDisplayed() : "Bio label not found on Delete Confirmation view!";
        WebElement bioValue = driver.findElement(By.cssSelector(".form-group input[asp-for='Bio']"));
        assert bioValue.isDisplayed() : "Bio value not found on Delete Confirmation view!";

        // Perform assertions based on the delete confirmation form
        WebElement confirmForm = driver.findElement(By.cssSelector("form[asp-action='Delete']"));
        assert confirmForm.isDisplayed() : "Delete Confirmation form not found!";

        WebElement confirmButton = driver.findElement(By.cssSelector("input[type='submit'][value='Confirm']"));

        // Create a WebDriverWait instance with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use WebDriverWait to wait for the element to be clickable
        confirmButton = wait.until(ExpectedConditions.elementToBeClickable(confirmButton));

        // Click the confirm button using JavascriptExecutor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", confirmButton);

        // After submitting the form, navigate to the list page
        driver.navigate().to(baseUrl + "/Actors/Index");

        // Perform assertions based on the Show All button after deletion
        WebElement showAllButton = driver.findElement(By.cssSelector("a.btn.btn-outline-secondary[asp-action='Index']"));
        assert showAllButton.isDisplayed() : "Show All Button not found!";
    }
}
