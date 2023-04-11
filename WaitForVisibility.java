package week7day1.LeafTap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitForVisibility  {
@Test
	public  void runVisible() throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/waits.xhtml");
	
		WebElement visibleclick = driver.findElement(By.xpath("(//span[text()='Click'])[1]"));
		visibleclick.click();
		
		WebDriverWait waitone = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitone.until(ExpectedConditions.visibilityOf(visibleclick));
		
		String output = driver.findElement(By.xpath("//span[text()='I am here']")).getText();
		System.out.println("the wait to visibility click --- "+output);
		Thread.sleep(3000);
		driver.close();
		
	}

}
