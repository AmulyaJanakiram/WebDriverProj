package testPackage1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("number of rows " + rows.size());
		List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("number of rows using a another xpath " + rows1.size());
		List<WebElement> col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		System.out.println("number of columns " + col.size());
		List<WebElement> col1 = driver.findElements(By.xpath("//table[@id='customers']/tbody//th"));
		System.out.println("number of columns using a another xpath" + col1.size());

		List<WebElement> rowdata = driver.findElements(By.xpath("//table[@id='customers']//tr[4]/td"));
		System.out.println("data from the a particular row");
		for (WebElement ele : rowdata) {
			System.out.println(ele.getText());
		}
		// bottom up approach for find a row using a text //td[text()='Island
		// Trading']/parent::tr/td

		List<WebElement> coldata = driver.findElements(By.xpath("//table[@id='customers']//tr/td[1]"));
		System.out.println("data from the a particular column");
		for (WebElement ele : coldata) {
			System.out.println(ele.getText());
		}

		// table[@id='customers']//tr/td[1]
	}

}
