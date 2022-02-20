package testPackage1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// telinng the where the driver is
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		// Webdriver interface pointing to ChromeDriver ,creating Webdriver object to
		// implement chromedriver
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);// implicit wait
		WebDriverWait wait = new WebDriverWait(driver, 50); // explicit wait

		WebElement Loginlink = driver.findElement(By.linkText("Log in"));
		wait.until(ExpectedConditions.elementToBeClickable(Loginlink)); // explicit wait
		Loginlink.click();

		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		// WebElement remember = driver.findElement(By.id("remember-me"));
		WebElement remember = driver.findElement(By.className("rememberMe"));

		UserName.sendKeys("abc@abc.com");
		Password.sendKeys("!Adf23kjkj");
		remember.click();
		LoginButton.click();

		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));

		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		if (ActualMsg.equals(ExpMsg))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		// to find all the links/achor tags in a page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links =  " + links.size());

		for (WebElement el : links) {
			System.out.println(el.getAttribute("href"));
		}

		driver.close();

	}

}
