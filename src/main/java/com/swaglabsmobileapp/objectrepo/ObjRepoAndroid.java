/**
 * @author sunil_s
 * @created on 06/26/2021
 * @description Class containing locators for Android Elements
 */
package com.swaglabsmobileapp.objectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjRepoAndroid extends BaseObjRepo {

	private static WebElement element = null;
	private static List<WebElement> elements = null;
	WebDriverWait wait = null;
	
	// Login Screen - Biometric Login Button
	@Override
	public WebElement biometricLoginBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("test-biometry")));
		return element;
	}
	
	// Login Screen - Please Sign In Text
	@Override
	public WebElement plsSignTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.TextView[@resource-id='com.android.systemui:id/title' and @text='Please sign in']")));
		return element;
	}
	
	// Login Screen - Finger Print Icon 
	@Override
	public WebElement fingerprintIcon(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("com.android.systemui:id/fingerprint_icon")));
		return element;
	}
	
	// Login Screen - Touch the Fingerprint Sensor Text
	@Override
	public WebElement touchFingerprintSensorTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.TextView[@resource-id='com.android.systemui:id/error' and @text='Touch the fingerprint sensor']")));
		return element;
	}
	
	// Login Screen - Cancel Button
	@Override
	public WebElement cancelBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.TextView[@resource-id='com.android.systemui:id/button2' and @text='CANCEL']")));
		return element;
	}
	
	

	
}
