package week7day1.LeafTap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitsChangeability {
@Test
	public  void runChange() throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/waits.xhtml");
		WebElement clickfour = driver.findElement(By.xpath("(//span[text()='Click'])[3]"));
		clickfour.click();
		
		WebDriverWait waitsfour = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitsfour.until(ExpectedConditions.visibilityOf(clickfour));
		
		String textoutput = driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText();
		System.out.println("the output wait is --- "+textoutput);
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
