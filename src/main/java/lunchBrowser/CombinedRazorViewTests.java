package lunchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CombinedRazorViewTests {

    private static final String BASE_URL = "https://localhost:7258";  // Replace with your actual base URL

    
        WebDriver driver = new ChromeDriver();

        public static void runTests(WebDriver driver) {
            testListOfActorsView(driver);
            System.out.println("Running List Of Actors Test");
            testAddActorView(driver);
            System.out.println("Running Add Actors Test");
            testDeleteActorView(driver);
            System.out.println("Running Delete Actors Test");
            /*testDetailsActorView(driver);
            System.out.println("Running Details Actors Test");
            testUpdateActorView(driver);
            System.out.println("Running Update Actors Test");*/
        }
    

    private static void testListOfActorsView(WebDriver driver) {
        navigateToView(driver, "/Actors/Index");

        // Perform actions/assertions specific to the List of Actors view
        // (e.g., check if the table headers are displayed, etc.)
        // For demonstration, let's check if the actor table is present
        WebElement actorTable = driver.findElement(By.cssSelector("table.table"));
        assert actorTable.isDisplayed() : "List of Actors table not found!";
    }

    private static void testAddActorView(WebDriver driver) {
        navigateToView(driver, "/Actors/Create");

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
        driver.navigate().to(BASE_URL + "/Actors/Index");


        // Perform assertions based on the success or failure of the form submission
        // For demonstration, let's check if the actor table is present on the redirected page
        WebElement actorTable = driver.findElement(By.cssSelector("table.table"));
        assert actorTable.isDisplayed() : "List of Actors table not found after form submission!";
    }
    
 private static void testDeleteActorView(WebDriver driver) {
        String actorId = "10";
        // Navigate to the delete actor view for a specific actor
        navigateToView(driver, "/Actors/Delete/" + actorId);

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
        driver.navigate().to(BASE_URL + "/Actors/Index");
        // Perform assertions based on the Show All button after deletion
        WebElement showAllButton = driver.findElement(By.cssSelector("a.btn.btn-outline-secondary[asp-action='Index']"));
        assert showAllButton.isDisplayed() : "Show All Button not found!";
    }
    private static void testDetailsActorView(WebDriver driver) {
        navigateToView(driver, "/Actors/Details/123");
        WebElement actorDetails = driver.findElement(By.cssSelector(".row.text h1"));
        assert actorDetails.isDisplayed() : "Actor Details not found!";
    }

    private static void testUpdateActorView(WebDriver driver) {
        navigateToView(driver, "/Actors/Edit/123");
        WebElement updateForm = driver.findElement(By.cssSelector("form[asp-action='Edit']"));
        assert updateForm.isDisplayed() : "Update Actor form not found!";
    }

    // Add similar methods for other views (delete, details, update)...

    private static void navigateToView(WebDriver driver, String viewPath) {
        driver.get(BASE_URL + viewPath);
    }
}

	

