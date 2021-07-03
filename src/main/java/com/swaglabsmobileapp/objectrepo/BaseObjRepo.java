/**
 * @author sunil_s
 * @created on 06/26/2021
 * @description Class containing declarations of Locator Elements
 */
package com.swaglabsmobileapp.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseObjRepo {

	// Locators of Login Screen
	public abstract WebElement biometricLoginBtn(WebDriver dr);
	
	public abstract WebElement plsSignTxt(WebDriver dr);
	
	public abstract WebElement fingerprintIcon(WebDriver dr);
	
	public abstract WebElement touchFingerprintSensorTxt(WebDriver dr);
	
	public abstract WebElement cancelBtn(WebDriver dr);
	

}
