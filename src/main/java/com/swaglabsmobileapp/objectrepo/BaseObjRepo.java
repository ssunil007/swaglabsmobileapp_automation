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
	public abstract WebElement getBiometricLoginBtn(WebDriver dr);
	
	public abstract WebElement getPlsSignTxt(WebDriver dr);
	
	public abstract WebElement getFingerprintIcon(WebDriver dr);
	
	public abstract WebElement getTouchFingerprintSensorTxt(WebDriver dr);
	
	public abstract WebElement getCancelBtn(WebDriver dr);
	
	
	// Locators of Home Screen
	public abstract WebElement getHamburgerMenuBtn(WebDriver dr);
	
	public abstract WebElement getSwaglabsTitle(WebDriver dr);
	
	public abstract WebElement getCartIcon(WebDriver dr);
	
	public abstract WebElement getProductsTxt(WebDriver dr,String value);
	
	public abstract WebElement getToggleBtn(WebDriver dr);
	
	public abstract WebElement getFilterIcon(WebDriver dr);
	
	public abstract WebElement getProductNameTxt(WebDriver dr,String value);
	
	public abstract WebElement getProductPriceTxt(WebDriver dr, String value);
	
	public abstract WebElement getAddToCartBtn(WebDriver dr,String value);
	
	public abstract WebElement getRemoveBtn(WebDriver dr,String value);
	
	public abstract WebElement getCartBatchCount(WebDriver dr);
	
	
	// Locators of Your Cart Screen
	public abstract WebElement getYourCartTxt(WebDriver dr,String value);
	
	public abstract WebElement getQTYTxt(WebDriver dr, String value);
	
	public abstract WebElement getDescTxt(WebDriver dr, String value);
	
	public abstract WebElement getItemDescTxt(WebDriver dr,String value);
	
	public abstract WebElement getAmtTxt(WebDriver dr,String value);
	
	public abstract WebElement getRemoveBtn(WebDriver dr);
	
	public abstract WebElement getContinueShoppingBtn(WebDriver dr);
	
	public abstract WebElement getCheckoutBtn(WebDriver dr);
	
	
	// Locators of Checkout INformation
	public abstract WebElement getCheckoutInfoTxt(WebDriver dr);
	
	public abstract WebElement getFirstNameTxtFld(WebDriver dr);
	
	public abstract WebElement getLastNameTxtFld(WebDriver dr);
	
	public abstract WebElement getZipCodeTxtFld(WebDriver dr);
	
	public abstract WebElement getCheckoutInfoCancelBtn(WebDriver dr);
	
	public abstract WebElement getContinueBtn(WebDriver dr);
	
	
	// Locators of Checkout Overview Screen
	public abstract WebElement getCheckoutOverviewTxt(WebDriver dr);
	
	public abstract WebElement getItemTotalTxt(WebDriver dr);
	
	public abstract WebElement getTaxTxt(WebDriver dr);
	
	public abstract WebElement getTotalTxt(WebDriver dr);
	
	public abstract WebElement getFinishBtn(WebDriver dr);
	
	public abstract WebElement getDeleteBtn(WebDriver dr);
	
	public abstract WebElement getItemNum(WebDriver dr);
	
	// Locators of Checkout: Complete Screen
	public abstract WebElement getCheckoutCompleteTxt(WebDriver dr);
	
	public abstract WebElement getThankYouForOrderTxt(WebDriver dr);
	
	public abstract WebElement getBackHomeBtn(WebDriver dr);
	
	
	
	
	
	
	

}
