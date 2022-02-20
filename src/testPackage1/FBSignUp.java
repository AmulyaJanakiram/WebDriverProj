package testPackage1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);// implicit wait

		WebElement NewAccount = driver.findElement(By.xpath("//a[contains(@data-testid,'open-registration')]"));
		NewAccount.click();

		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		// WebElement firstname =
		// driver.findElement(By.xpath("//input[@aria-label='First name']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement pwd = driver.findElement(By.xpath("//input[@data-type='password']"));

		firstname.sendKeys("abc");
		lastname.sendKeys("xyz");
		email.sendKeys("9878979");
		pwd.sendKeys("sdfad343#A");

		String Gen = "Female";
		// label[text()='Female']/following-sibling::input
		String GenXpath = "//label[text()='" + Gen + "']/following-sibling::input"; // dyamic xpath
		WebElement gender = driver.findElement(By.xpath(GenXpath));
		gender.click();

		// select[@name='birthday_month']/option

		List<WebElement> months = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));
		for (WebElement elm : months)
			System.out.println(elm.getText());

		WebElement currentMonth = driver
				.findElement(By.xpath("//select[@name='birthday_month']/option[@selected='1']"));
		System.out.println("Current month is " + currentMonth.getText());

		List<WebElement> days = driver.findElements(By.xpath("//select[@name='birthday_day']/option"));

		WebElement selectDay = driver.findElement(By.xpath("//select[@id='day']"));
		Select ddDay = new Select(selectDay);
		ddDay.selectByVisibleText("27");

		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select ddMonth = new Select(selectMonth);
		ddMonth.selectByVisibleText("Jun");

		WebElement selectYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select ddYear = new Select(selectYear);
		ddYear.selectByVisibleText("1982");

		// driver.close();
	}

}
