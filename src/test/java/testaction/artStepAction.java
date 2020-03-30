package testaction;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import util.Constants;

public class artStepAction {
	public static WebDriver driver= new ChromeDriver();
	@Test(dataProvider="getTestCaseDate")
	public static void artStep(Map<String,String> param) throws Exception {
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		loginAction.login(driver,param.get(Constants.USERNAME),param.get(Constants.PASSWORD));
	
	}
	
	
	private static String file = "..\\data\\testdata\\testdatas.xlsx";
	@DataProvider(name="getTestCaseData")
	public Object[][] readTestCaseSheet() throws Exception{
		String sheetName = "测试数据";
		Object[][] object = ExcelUtil.readeExcelForName(file,sheetName,1,null,0,null);
		return object;
	}
}
