package testPackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		WebElement ele = driver.findElement(By.xpath("//h2[text()='Table Rows']"));

		// JavacriptExecutor is used to run a script in the browser
		// argument[0] refers to ele, this is dynamic and is done at runtime
		// obj.executeScript("arguments[2].scrollIntoView();", ele1, ele2);

		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", ele); // sroll to a particular element
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);"); // scroll down
		obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");// scroll up

		// https://developer.mozilla.org/en-US/docs/Web/API/Element

	}

}
