package util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Common {
/**
 * 生成身份证号
 * @param birth 出生日期
 * @param sex 性别
 * @return generater.toString 身份证号
 * */
	public static String generate(String birth,int sex) {
		StringBuilder generater = new StringBuilder();
//		generater.append(IdCardGenerator.randomAreaCode);
		generater.append(birth);
//		generater.append(IdCardGenerator.radomCodeBySex(sex));
//		generater.append(IdCardGenerator.calcTrailingNumber(generater.toString().toCharArray()));
		return generater.toString();
	}
	/**
	 * 随机生成N位数
	 * */
	public static String random(int value) {
		String number = "";
		Random random = new Random();
		for(int i = 0;i<value;i++) {
			int num = random.nextInt(10);
			number = number+Integer.toString(num);
		}
		return number;
	}
	public static String timeStamp() {
		long time = new Date().getTime();
		String timeStamp = Long.toString(time);
		return timeStamp;
	}
	
	/**
	 * Web端全屏截图方法
	 * @param driver 驱动
	 * 
	 * @param casename 案例号
	 * 
	 * @param testcaseSescription 截图内容说明
	 * 
	 * @param count 截图排序
	 * */
	public static void fullScreenShot(WebDriver driver,String casename,String testcaseDescription,int count) {
		String filePath = TakeScreenUntil.getPath()+"\\screenshot\\";
		try {
			String targetpath = filePath + casename +"\\"+count +testcaseDescription+".png";
			File fileDir = new File(targetpath);
			if(!fileDir.exists()) {
				fileDir.mkdirs();
			}
			BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(img, "png", fileDir);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 鼠标移动到目标元素上
	 * */
	public static void suspensionMouse(WebDriver driver,WebElement el) {
		String script = "return arguments[0].scrollIntoView();";
		((JavascriptExecutor)driver).executeScript(script,el);
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
