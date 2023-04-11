package week7day1.LeafTap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitsInvisibility {
@Test
	public void runInvisible() throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/waits.xhtml");
		WebElement clickthree = driver.findElement(By.xpath("(//span[text()='Click'])[2]"));
		clickthree.click();
		
		String outputtext = driver.findElement(By.xpath("//span[text()='I am about to hide']")).getText();
		System.out.println("the text is --- "+outputtext);
		
		WebElement waitsfor = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
		WebDriverWait newwaits = new WebDriverWait(driver, Duration.ofSeconds(10));
		newwaits.until(ExpectedConditions.invisibilityOf(waitsfor));
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
