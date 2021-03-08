package basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeSettings {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		ChromeOptions options = new ChromeOptions();
		//to disable pop up "developer mode extensions" and automation info-bar messages
		options.setExperimentalOption("useAutomationExtension",false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		
		//disable info-bars, pop-up blocking and start maximized
		options.addArguments("disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		options.addArguments("--disable-popup-blocking");
		
		//disable password save pop- up
		
		Map<String, Object> passwordSavePopPref = new HashMap<String, Object>();
		passwordSavePopPref.put("credentials-eable-services", false);
		passwordSavePopPref.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", passwordSavePopPref);
		
		
		WebDriver driver = new ChromeDriver(options);
		
		List <WebElement> date;
		
		date= driver.findElements(By.id("test"));
		
		//loop through list of web element 
		for (int i =0; i<date.size();i++) {
			
			System.out.println(date.get(i).getText());
			
		}
		//for each
		for(WebElement element:date) {
			System.out.println(element.getText());
		}
		//select a value from dropdown loop
		
		for(WebElement element: date) {
			if(element.getText().contentEquals("18")) {
				element.click();
				Thread.sleep(2000);
				break;
			}
		}
		// Advanced find element strategy with webelement
		
		WebElement year;
		List<WebElement> years;
		
		year= driver.findElement(By.id("id"));
		years= driver.findElements(By.tagName("test"));
		System.out.println(years.size());
		
		//uploading a file with robot class
		
		//specify the file location with extension 
		
		StringSelection sel = new StringSelection("filepath ");
		//copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		//scroll down the page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,350)");
		
		//click browser botton
		driver.findElement(By.id("browser")).click();
		//creat object of robot class
		
		Robot robot = new Robot();
		Thread.sleep(1000);
		
		//press enter
		robot.keyPress(KeyEvent.VK_ENTER);
		//Release enter
		robot.keyRelease(KeyEvent.VK_ENTER);
		//press control v
		robot.keyPress(KeyEvent.VK_CONTROL);
		//PRESS V
		robot.keyPress(KeyEvent.VK_V);
		
		//release control v
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		//enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
		//download a file in a fixed location
		
		HashMap<String, Object> chromePref = new HashMap<String, Object>();
		chromePref.put("profile.default_content_settings.popups",0);
		chromePref.put("download.default_directory", "C:\\Working");
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", chromePref);
		option.addArguments("--test-type");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

		
		// TODO Auto-generated method stub

	}

}
