/**
 * @author sunil_s
 * @created on 06/26/2021
 * @description Class to create Singleton Driver Instance
 */
package com.swaglabsmobileapp.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class SingletonDriver {

	private static SingletonDriver driverClass = null;
	private WebDriver driver;
	SetupObjRepo setupor = new SetupObjRepo();

	/**
	 * @author sunil_s
	 * @description Constructor to create single instance of Driver
	 * @param platform
	 * @param capabilities
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public SingletonDriver(String platform, Capabilities capabilities) throws IOException, InterruptedException {
		// TODO Auto-generated constructor stub
		try {
			if (platform.equalsIgnoreCase("iOS")) {
				driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				setupor.ObjRepSetupForDevice(platform);
			} else {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				setupor.ObjRepSetupForDevice(platform);
			}
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author sunil_s
	 * @description Method to get instance Singleton Driver
	 * @param platform
	 * @param desiredCapabilities
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static SingletonDriver getInstance(String platform, Capabilities desiredCapabilities)
			throws IOException, InterruptedException {
		if (driverClass == null) {
			driverClass = new SingletonDriver(platform, desiredCapabilities);
		}
		return driverClass;
	}

	/**
	 * @author sunil_s
	 * @description Method to return singleton driver instance
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

}
