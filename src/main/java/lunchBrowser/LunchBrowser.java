package lunchBrowser;

import org.openqa.selenium.WebDriver;

public class LunchBrowser {

	public static void main(String[] args) {
        System.out.println("Running RegisterTest...");
       // RegisterTest.runRegisterTest();

        System.out.println("Running LoginTest...");
        LoginTest.runLoginTest();
        
 	    WebDriver driver = WebDriverManager.getDriver();
 	    
 	    //Test CRUD sur actors:
 	    
 	    ListOfActorsTest.testListOfActorsView(driver);
 	    //UpdateActorTest.testUpdateActorView(driver,"2");
 	   // AddActorTest.testAddActorView(driver);
 	    DetailsActorTest.testDetailsActorView(driver,"2");
 	   // DeleteActorTest.testDeleteActorView(driver, "10");

 	    
 	    //ShoppingCartTest.runMovieCartTest(driver);
        System.out.println("Running Razor View Tests...");
        
        driver.navigate().to("https://localhost:7258/Movies");
        // Quit the WebDriver after running all tests
        WebDriverManager.quitDriver();
    }

   
}