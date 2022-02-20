package testPackage1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		String ParentWin = driver.getWindowHandle();
		System.out.println("before cliking on new window  " + ParentWin);
		WebElement newWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
		// WebElement newTab =
		// driver.findElement(By.xpath("//button[@id='tabButton']"));
		// tab and window works the same.
		newWindow.click();

		System.out.println("after cliking on new window ");

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> itr = handles.iterator();

		while (itr.hasNext()) {
			String currentVal = itr.next();
			System.out.println(currentVal);

			if (!currentVal.equals(ParentWin)) {
				driver.switchTo().window(currentVal);
			}
		}
		WebElement heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("the heading of the second window is " + heading.getText());
		driver.close();
		driver.switchTo().window(ParentWin);
		System.out.println("back to first window");

		WebElement newTab = driver.findElement(By.xpath("//button[@id='tabButton']"));
		newTab.click();
	}

}
