package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
public class AppTest {
	WebDriver driver = null;
	String url="http://jqueryui.com/droppable";
    ChromeOptions options = new ChromeOptions();
	@BeforeTest
	public void beforeTest() throws IOException {
		System.setProperty("webdriver.chrome.driver", "/home/code/project/workspace/chromedriver");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		
	}

   @Test
   public void testcase_1() throws InterruptedException
   {
	  driver.manage().window().maximize(); 
	  driver.get(url);
	 String title = driver.getTitle();
	 Assert.assertEquals(title, "Droppble | jQuery UI");
   }

	@Test
	public void testcase_2() throws InterruptedException 
      {
	      WebElement webFrame = driver.findElement(By.className("demo-frame")); 
               
		   driver.switchTo().frame(webFrame);
		    WebElement source = driver.findElement(By.id("draggable"));
		    WebElement target = driver.findElement(By.id("droppable"));

		    Actions action = new Actions(driver);

		    String colourBeforeDnD = target.getCssValue("color");

		    action.dragAndDrop(source, target).build().perform();

		    String colorAfterDnD = target.getCssValue("color");
		    if((colourBeforeDnD.equals(colcorAfterDnD))){
			    Assert.assertTrue(false);
		    }else{
			    Assert.assertTrue(true);
		    }
		    String text=driver.findElement(By.id("droppable"));
		   Assert.assertEquals("Dropped!", text);
	}
	@Test
	public void testcase_3() throws InterruptedException 
	{

	}

	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}