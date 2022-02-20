package testPackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		// Alert : clicking on ok button of a pop up
		WebElement button = driver.findElement(By.xpath("//button[@id='alertButton']"));
		button.click();
		Alert al = driver.switchTo().alert(); // Alert is a class. al is the object and use al's methods
		System.out.println(al.getText());
		al.accept(); //

		// Alert : clicking on cancel button of a pop up
		WebElement button2 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		button2.click();
		Alert alert1 = driver.switchTo().alert(); // Alert is a class. al is the object and use al's methods
		System.out.println(alert1.getText());
		alert1.dismiss();

		// Alert : Message
		WebElement button3 = driver.findElement(By.xpath("//button[@id='promtButton']"));

		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", button3); // sroll to a particular element

		button3.click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.sendKeys("textentered");
		Thread.sleep(4000);
		alert2.accept();
	}

}
