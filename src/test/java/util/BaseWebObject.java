package util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebObject {
	public static int timeOutInSec=10;
	public static WebElement getWebElement (WebDriver driver,String myLocator) {
		By findby =null;
		if (myLocator.startsWith("css=")) {
			findby=By.cssSelector(myLocator.replace("css=", ""));
		} else if (myLocator.startsWith("//")) {
			findby = By.xpath(myLocator);
		} else if (!myLocator.contains("=")) {
			findby = By.id(myLocator);
		}
		WebElement element=null;
		try {
			element = driver.findElement(findby);
		}
		catch(Exception localException) {}
		return element;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static WebElement getVisibilityWebElement (WebDriver driver,String myLocator) {
		By findby =null;
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSec);
		if (myLocator.startsWith("css=")) {
			findby=By.cssSelector(myLocator.replace("css=", ""));
		} else if (myLocator.startsWith("//")) {
			findby = By.xpath(myLocator);
		} else if (!myLocator.contains("=")) {
			findby = By.id(myLocator);
		}
		WebElement element=null;
		try {
			List<WebElement>els=(List)wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(myLocator)));
			for (WebElement webElement : els) {
				if(webElement.isDisplayed()) {
					return webElement;
				}
			}
		}
		catch(Exception localException) {}
		return element;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<WebElement> getVisibilityWebElements (WebDriver driver,String myLocator) {
		By findby =null;
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSec);
		if (myLocator.startsWith("css=")) {
			findby=By.cssSelector(myLocator.replace("css=", ""));
		} else if (myLocator.startsWith("//")) {
			findby = By.xpath(myLocator);
		} else if (!myLocator.contains("=")) {
			findby = By.id(myLocator);
		}
		List<WebElement> element=null;
		List<WebElement> VisibilityElement = new ArrayList();
		try {
			element = (List)wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findby));
			for (WebElement webElement : element) {
				if(webElement.isDisplayed()) {
					VisibilityElement.add(webElement);
				}
			}
			
		}
		catch(Exception localException) {}
		return VisibilityElement;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<WebElement> getWebElements (WebDriver driver,String myLocator) {
		By findby =null;
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSec);
		if (myLocator.startsWith("css=")) {
			findby=By.cssSelector(myLocator.replace("css=", ""));
		} else if (myLocator.startsWith("//")) {
			findby = By.xpath(myLocator);
		} else if (!myLocator.contains("=")) {
			findby = By.id(myLocator);
		}
		List<WebElement> element=null;
		try {
			element = (List)wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findby));
		}
		catch(Exception localException) {}
		return element;
	}
	
	public static String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
}
