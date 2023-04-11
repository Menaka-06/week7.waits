package week7day1.LeafTap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitForClickability {
	@Test
	public  void runClick() throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/waits.xhtml");
		WebElement clicktwo = driver.findElement(By.xpath("//span[text()='Click First Button']"));
		clicktwo.click();
		
		WebDriverWait waitstwo=new WebDriverWait(driver, Duration.ofSeconds(10));
		waitstwo.until(ExpectedConditions.visibilityOf(clicktwo));
		
		String output = driver.findElement(By.xpath("(//div[@class='ui-growl-message']/span)[2]")).getText();
		System.out.println("the output text is --- "+output);
		Thread.sleep(3000);
		driver.close();
		
	}

}
