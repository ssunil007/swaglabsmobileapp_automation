/**
 * @author sunil_s
 * @created on 06/26/2021
 * @description Class containing all the functions relating to perform mobile gestures
 */
package com.swaglabsmobileapp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.swaglabsmobileapp.common.DriverSetup;
import com.swaglabsmobileapp.objectrepo.BaseObjRepo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class CommonUtils {

	String platFormName = DriverSetup.getPlatform();
	String logFilePath = DriverSetup.getLogfilePath();
	SimpleDateFormat formater = new SimpleDateFormat("ddMMyyyy_HHmmss");
	Calendar calendar = Calendar.getInstance();

	/**
	 * @author sunil_s
	 * @description Method to print current test execution method with test case no.
	 * @param driver
	 * @param tc
	 */
	public void printMethodNameWithTC(WebDriver driver, String tc) {
		String CName = Thread.currentThread().getStackTrace()[2].getClassName();
		String MName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("Current Execution: " + CName + "." + MName + " < " + tc + " >");
	}

	/**
	 * @author sunil_s
	 * @description Method to capture screenshot
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public String catpureScreenshot(WebDriver driver) throws InterruptedException {
		Thread.sleep(10000);
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileLocation = logFilePath + "/screenshots/" + "_" + formater.format(calendar.getTime()) + ".png";
		File destination = new File(fileLocation);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileLocation;
	}

	/**
	 * @author sunil_s
	 * @description Method to swipe/scroll right to left in tab bar
	 * @param driver
	 */
	public void swipe_righttoleft(AndroidDriver<?> driver) {
		Dimension size = driver.manage().window().getSize();
		int x_start = (int) (size.width * 0.80);
		int x_end = (int) (size.width * 0.20);
		int y = 405; // 208;
		driver.swipe(x_start, y, x_end, y, 1000);
	}

	/**
	 * @author sunil_s
	 * @description Method to swipe/scroll left to right in tab bar
	 * @param driver
	 */
	public void swipe_lefttoright(AndroidDriver<?> driver) {
		Dimension size = driver.manage().window().getSize();
		int x_start = (int) (size.width * 0.80);
		int x_end = (int) (size.width * 0.20);
		int y = 405; // 208;
		driver.swipe(x_end, y, x_start, y, 1000);
	}

	
	/**
	 * @author sunil_s
	 * @description Method to scroll down in the pod(s) list of dash board
	 * @param driver
	 */
	public void scroll_down(AndroidDriver<?> driver) {
		Dimension size = driver.manage().window().getSize();
		int y_start = (int) (size.width * 1.20);
		int y_end = (int) (size.width * 0.03);
		int x = 380;
		driver.swipe(x, y_start, x, y_end, 3000);
	}

	/**
	 * @author sunil_s
	 * @description Method to scroll down in the pod(s) list of dash board
	 * @param driver
	 */
	public void scroll_down2(AndroidDriver<?> driver) {
		Dimension size = driver.manage().window().getSize();
		int y_start = (int) (size.width * 1.20);
		int y_end = (int) (size.width * 0.25);
		int x = 380;
		driver.swipe(x, y_start, x, y_end, 3000);
	}

	/**
	 * @author sunil_s
	 * @description Method To scroll up in the pod(s) list of dash board
	 * @param driver
	 */
	public void scroll_up(AndroidDriver<?> driver) {
		Dimension size = driver.manage().window().getSize();
		int y_start = (int) (size.height * 0.70);
		int y_end = (int) (size.height * 0.20);
		int x = size.width / 2;
		driver.swipe(x, y_end, x, y_start, 3000);
	}

	/**
	 * @author sunil_s
	 * @description Method to double click/tap on pod(s)
	 * @param driver
	 * @param ele
	 */
	public void double_click(AndroidDriver<?> driver, WebElement ele) {
		TouchAction action = new TouchAction(driver);
		action.press(ele).press(ele).perform();
	}
	
	
	/**
	 * @author sunil_s
	 * @description Method to perform scroll down operation - iOS
	 * @param dr
	 */
	public void scrollTo_iOS(WebDriver dr) {
		JavascriptExecutor js1 = (JavascriptExecutor) dr;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js1.executeScript("mobile: scroll", scrollObject);
	}

	/**
	 * @author sunil_s
	 * @description Method to perform scroll up operation - iOS
	 * @param dr
	 */
	public void scrollTo_iOS_up(WebDriver dr) {
		JavascriptExecutor js1 = (JavascriptExecutor) dr;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "up");
		js1.executeScript("mobile: scroll", scrollObject);
	}

	/**
	 * @author sunil_s
	 * @description Method to perform scroll right operation - iOS
	 * @param dr
	 */
	public void scrollTo_iOS_right(WebDriver dr) {
		JavascriptExecutor js1 = (JavascriptExecutor) dr;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "right");
		js1.executeScript("mobile: swipe", scrollObject);
	}

	/**
	 * @author sunil_s
	 * @description Method to perform scroll left operation - iOS
	 * @param dr
	 */
	public void scrollTo_iOS_left(WebDriver dr) {
		JavascriptExecutor js1 = (JavascriptExecutor) dr;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "left");
		js1.executeScript("mobile: scroll", scrollObject);
	}

	/**
	 * @author sunil_s
	 * @description Method to perform scroll down to element operation - iOS
	 * @param dr
	 */
	public void scrollToElement_iOS(WebDriver dr, String element) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		scrollObject.put("xpath", element);
		js.executeScript("mobile: scroll", scrollObject);
	}

	/**
	 * @author sunil_s
	 * @description Method to perform scroll to element operation - iOS
	 * @param dr
	 */
	public void scrollTo_String(IOSDriver<?> driver, String element) {
		driver.scrollTo(element);
	}

	/**
	 * @author sunil_s
	 * @description Method to perform scroll based on position operation -
	 *              Vertical
	 * @param dr
	 */
	public void scrollToEle(WebDriver driver, double x, double y) {

		try {
			Dimension dSize = driver.manage().window().getSize();
			int starty = (int) (dSize.height * x);
			int endy = (int) (dSize.height * y);
			int startx = dSize.width / 2;

			if ("ANDROID".equalsIgnoreCase(platFormName)) {
				AndroidDriver<?> androidDriver = ((AndroidDriver<?>) driver);
				Thread.sleep(4000);
				androidDriver.swipe(startx, starty, startx, endy, 1000);
				Thread.sleep(2000);
			} else {
				IOSDriver<?> iOSDriver = ((IOSDriver<?>) driver);
				Thread.sleep(1000);
				iOSDriver.swipe(startx, starty, startx, endy, 1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author sunil_s
	 * @description Method to perform scroll based on position operation -
	 *              Horizontal
	 * @param dr
	 */
	public void horizontalScroll(WebDriver driver, double x, double y) {

		try {
			Dimension dSize = driver.manage().window().getSize();
			int startx = (int) (dSize.width * x);
			int endx = (int) (dSize.width * y);
			int starty = dSize.height / 2;
			if ("ANDROID".equalsIgnoreCase(platFormName)) {
				AndroidDriver<?> androidDriver = ((AndroidDriver<?>) driver);
				Thread.sleep(1000);
				androidDriver.swipe(startx, starty, endx, starty, 1000);
			} else {
				IOSDriver<?> iOSDriver = ((IOSDriver<?>) driver);
				Thread.sleep(1000);
				iOSDriver.swipe(startx, starty, endx, starty, 1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author sunil_s
	 * @description Method to perform double tap operation - iOS
	 * @param dr
	 * @param ele
	 */
	public void doubleTap_iOS(WebDriver dr, MobileElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		HashMap<String, String> tapObject = new HashMap<String, String>();
		tapObject.put("element", (ele).getId());
		js.executeScript("mobile:doubleTap", tapObject);
	}

	/**
	 * @author sunil_s
	 * @description Method to enter Amount using Keypad
	 * @param ele
	 * @param inputValue
	 */
	public void enter_amount_using_keypad(WebDriver dr, String inputValue) {
		WebElement element;
		if (isNumber(inputValue) == true) {
			for (int i = 0; i <= inputValue.length() - 1; i++) {
				element = dr.findElement(By.xpath("//android.widget.Button[@text='" + inputValue.charAt(i) + "']"));
				element.click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			element = dr.findElement(By.xpath("//android.widget.Button[@text='" + inputValue + "']"));
			element.click();
		}
		
	}
	
	/**
	 * @author sunil_s
	 * @description Method to check whether given number is integer or not
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
	    try {
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	    }
	    return false;
	}
	
	/**
	 * @author sunil_s
	 * @description Method to getDate
	 * @param value
	 * @return
	 */
	public Date getDate(int value){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, value);
		Date date = cal.getTime();
		return date;
	}
	
	/**
	 * @author sunil_s
	 * @description Method to enable finger print authentication
	 * @param pin
	 * @return
	 * @throws Exception
	 */
	public boolean enablingFingerPrintAuthentication(String pin) throws Exception {

		String cmd1 = System.getProperty("user.home") + "/Library/Android/sdk/platform-tools/adb -e emu finger touch "
				+ pin;
		String[] command = { "zsh", "-c", cmd1 };
		try {

			String data = "";
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String error = "";

			while ((error = bre.readLine()) != null && !error.equals("null")) {
				data += error + "\n";
			}

			String line = "";
			while ((line = bri.readLine()) != null && !line.equals("null")) {
				data += line + "\n";
			}
			bri.close();
			bre.close();
			p.waitFor();
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @author sunil_s
	 * @description Method to login with finger print authentication
	 * @param obj
	 * @return
	 */
	public boolean loginWithFingerAuthentication(WebDriver dr, BaseObjRepo obj, String pin) {

		try {
			obj.getBiometricLoginBtn(dr).click();
			obj.getPlsSignTxt(dr).isDisplayed();
			obj.getFingerprintIcon(dr).isDisplayed();
			obj.getTouchFingerprintSensorTxt(dr).isDisplayed();
			Thread.sleep(2000);
			enablingFingerPrintAuthentication(pin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	


}


