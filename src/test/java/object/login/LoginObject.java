package object.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.BaseWebObject;
public class LoginObject extends BaseWebObject{
	/**用户名*/
	public static WebElement getUsername (WebDriver driver) {
		return getVisibilityWebElement(driver,LoginLocator.USERNAME);
	}
	/**密码*/
	public static WebElement getPassword (WebDriver driver) {
		return getVisibilityWebElement(driver,LoginLocator.PASSWORD);
	}
	/**登录按钮*/
	public static WebElement getLoginBtn (WebDriver driver) {
		return getVisibilityWebElement(driver,LoginLocator.LOGINBTN);
	}
}
