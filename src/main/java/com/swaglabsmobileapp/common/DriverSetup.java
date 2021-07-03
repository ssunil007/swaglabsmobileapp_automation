/**
 * @author sunil_s
 * @created on 06/26/2021
 * @description Class containing Driver Setup Initialization for Appium Session
 */
package com.swaglabsmobileapp.common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglabsmobileapp.utils.CommonUtils;

public class DriverSetup {

	SetupObjRepo setupor = new SetupObjRepo();
	CommonUtils commonUtils = new CommonUtils();
	WebDriver driver;

	public static String platform;
	public static String deviceName;
	public static String platformVersion;
	public static String appPath;
	public static String logfilePath;

	
	// Getter Method for Platform Variable
	public static String getPlatform() {
		return platform;
	}

	// Setter Method for Platform Variable
	public static void setPlatform(String platform) {
		DriverSetup.platform = platform;
	}

	// Getter Method for DeviceName Variable
	public static String getDeviceName() {
		return deviceName;
	}

	// Setter Method for DeviceName Variable
	public static void setDeviceName(String deviceName) {
		DriverSetup.deviceName = deviceName;
	}

	// Getter Method for Platform Version Variable
	public static String getPlatformVersion() {
		return platformVersion;
	}

	// Setter Method for Platform Version Variable
	public static void setPlatformVersion(String platformVersion) {
		DriverSetup.platformVersion = platformVersion;
	}

	// Getter Method for AppPath Variable
	public static String getAppPath() {
		return appPath;
	}

	// Setter Method for AppPath Variable
	public static void setAppPath(String appPath) {
		DriverSetup.appPath = appPath;
	}

	// Getter Method for LogFilePath Variable
	public static String getLogfilePath() {
		return logfilePath;
	}

	// Setter Method for LogfilePath Variable
	public static void setLogfilePath(String logfilePath) {
		DriverSetup.logfilePath = logfilePath;
	}

	// Getter Method for Setup Object Repo Variable
	public SetupObjRepo getSetupor() {
		return setupor;
	}

	// Getter Method for Common Utils Variable
	public CommonUtils getCommonUtils() {
		return commonUtils;
	}

	// Getter Method for Driver
	public WebDriver getDriver() {
		return driver;
	}

	DesiredCapabilities capabilities = new DesiredCapabilities();

	/**
	 * @author sunil_s
	 * @description Test Method to set capabilities required for Appium session
	 * @param environment
	 * @param platform
	 * @param deviceName
	 * @param platformVersion
	 * @param appPath
	 * @param logfilePath
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeTest
	@Parameters({"platform", "deviceName", "platformVersion", "appPath", "logFilePath" })
	public void setUpAppium( String platform, String deviceName, String platformVersion,
			String appPath, String logfilePath) throws IOException, InterruptedException {

		setPlatform(platform);
		setDeviceName(deviceName);
		setPlatformVersion(platformVersion);
		
		final String APPPATH = System.getProperty("user.dir")+appPath;
		setAppPath(APPPATH);
		
		final String LOGFILEPATH = System.getProperty("user.dir")+logfilePath;
		setLogfilePath(LOGFILEPATH);
		
		
		File app = new File(APPPATH); // File Path of APK file

		if (platform.equalsIgnoreCase("iOS")) {

			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformName", platform);
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("app", app);
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("newCommandTimeout", 280);
		} else {

			capabilities.setCapability("device", deviceName);

			// Mandatory Capabilities
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformName", platform);
			capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
			capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
			capabilities.setCapability("automationName", "UiAutomator1");
			capabilities.setCapability("noReset", "false");
			capabilities.setCapability("newCommandTimeout", 280);
			capabilities.setCapability("autoDismissAlerts", true);
			capabilities.setCapability("autoAcceptAlerts", true);

			// Other capabilities
			capabilities.setCapability("app", app);
		}
	}

	/**
	 * @author sunil_s
	 * @description Test Method to create a Appium Session
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void driverSet() throws IOException, InterruptedException {
			driver = SingletonDriver.getInstance(platform, capabilities).getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	/**
	 * @author sunil_s
	 * @description Method to print Test ScriptExecution Info
	 * @param tc
	 */
	public void printTestScriptExecutionInfo(String tc) {
		String CName = Thread.currentThread().getStackTrace()[2].getClassName();
		String MName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("Current Execution: " + CName + "." + MName + " < " + tc + " >");
	}

}
