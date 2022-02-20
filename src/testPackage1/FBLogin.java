package testPackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);// implicit wait

		WebElement name = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement pwd = driver.findElement(By.xpath("// input[@name='pass']"));
		WebElement log = driver.findElement(By.xpath("//button[@name='login']"));
		name.sendKeys("asdasdfasdfasdf");
		pwd.sendKeys("!Asdf23");
		String txt = driver.getTitle();
		System.out.println(txt);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testesteteste");
		driver.findElement(By.xpath("// input[@name='pass']")).sendKeys("testesteteste");
		driver.navigate().back();
		driver.navigate().forward();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ams@a.com");
		driver.findElement(By.xpath("// input[@name='pass']")).sendKeys("!Asdf23");
		driver.findElement(By.xpath("//button[@name='login']")).click();

		driver.navigate().to("https://www.facebook.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.getTitle();
		driver.getCurrentUrl();
		driver.getPageSource();

		name.sendKeys("abc");
		name.click();
		name.clear();
		name.getAttribute("class");

		// WebElement ele = driver.findElement(By.c)

	}

}
