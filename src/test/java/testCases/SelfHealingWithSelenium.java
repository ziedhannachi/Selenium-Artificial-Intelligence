package testCases;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * auth Zied HANNACHI
 */

public class SelfHealingWithSelenium {
	
	static private SelfHealingDriver driver;
	
	@BeforeAll
	static public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		
		WebDriver delegate = new ChromeDriver();
		driver = SelfHealingDriver.create(delegate);
		
	}
	
	@AfterAll
	static public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		
	}
	
	@Test
	public void fillMessage() {
		driver.get("http://r4d4.info/form-button-label2");
		WebElement messageNew = driver.findElement(By.id("messageNew"));
		messageNew.clear();
		messageNew.sendKeys("Zied Hannachi");
	}

}
