package testPackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragdropEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		WebElement fromEle = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		WebElement toEle = driver.findElement(By.xpath("//ol[@id='bank']/li"));

		Actions act = new Actions(driver); // Actions is a class. driver is sent as a constructor.
		act.dragAndDrop(fromEle, toEle).build().perform(); // interactive actions need build.perform methods

		/*
		 * doubleClick(): Performs double click on the element clickAndHold(): Performs
		 * long click on the mouse without releasing it dragAndDrop(): Drags the element
		 * from one point and drops to another moveToElement(): Shifts the mouse pointer
		 * to the center of the element contextClick(): Performs right-click on the
		 * mouse
		 */

	}

}
