package testPackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		WebElement ele = driver.findElement(By.xpath("//input[@name='uploadfile_0']"));

		ele.sendKeys("E:\\_SimpliLearn\\UploadExSimpliLearn.txt");

		WebElement check = driver.findElement(By.xpath("//input[@name='terms']"));
		check.click();

		WebElement but = driver.findElement(By.xpath("//button[@name='send']"));
		but.click();

	}

}
