package basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBasics {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver.get(baseUrl);
		driver.manage().window().fullscreen();
		String title = driver.getTitle();
		// WebElement element =driver.findElements(By.TagName('a'))

		driver.findElement(By.xpath("//*[@id=\"bmwcheck\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"bmwcheck\"]")).isSelected();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Titel is :" + title);

		/*
		 * Boolean isSelected = false; List <WebElement> rb
		 * =driver.findElements(By.xpath("//*[@id=\"bmwradio\"]")); int size =
		 * rb.size(); for(WebElement e : rb) { isSelected =rb.get(size).isSelected();
		 * 
		 * if(!isSelected) { rb.get(size).click(); Thread.sleep(5); }
		 */

		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);
		sel.selectByVisibleText("BMW");
		sel.selectByValue("benz");
		sel.selectByIndex(2);

		List<WebElement> options = sel.getOptions();
		int size = options.size();

		for (WebElement e : options) {
			String optionName = options.get(size).getText();
			System.out.println(optionName);

		}

		driver.quit();
		// div[1]/div[2]/fieldset/legend

	}

}
