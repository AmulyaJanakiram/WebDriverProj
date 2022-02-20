package testPackage1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		// TakesScreenshot is the class from selenium
		TakesScreenshot ob = (TakesScreenshot) driver; // typecasting

		File file = ob.getScreenshotAs(OutputType.FILE);

		// copying file from RAM/runtime to harddisk
		try {
			FileUtils.copyFile(file, new File("img.png")); // project folder
			FileUtils.copyFile(file, new File("E:\\_SimpliLearn\\img.png")); // specific path
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
