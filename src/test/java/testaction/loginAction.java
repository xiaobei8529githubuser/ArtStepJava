package testaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import object.login.LoginObject;
/**登录*/
public class loginAction {
	/** 用户名 */
	public static void setUsername(WebDriver driver, String value) {
		WebElement el = LoginObject.getUsername(driver);
		el.clear();
		el.sendKeys(value);
	}

	/** 密码 */
	public static void setPassword(WebDriver driver, String value) {
		WebElement el = LoginObject.getPassword(driver);
		el.clear();
		el.sendKeys(value);
	}

	/** 登录按钮 */
	public static void setLoginBtn(WebDriver driver) {
		WebElement el = LoginObject.getLoginBtn(driver);
		el.click();
	}

	/** 登录 */
	public static void login(WebDriver driver, String username, String pwd) {
		driver.get("https://vip.artstep.cn/#/login");
		driver.manage().window().maximize();
		setUsername(driver, username);
		setPassword(driver, pwd);
		setLoginBtn(driver);
	}

}
