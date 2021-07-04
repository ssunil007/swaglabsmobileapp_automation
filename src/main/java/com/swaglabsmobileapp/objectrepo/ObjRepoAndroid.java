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
	public WebElement getBiometricLoginBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-biometry")));
		return element;
	}

	// Login Screen - Please Sign In Text
	@Override
	public WebElement getPlsSignTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.TextView[@resource-id='com.android.systemui:id/title' and @text='Please sign in']")));
		return element;
	}

	// Login Screen - Finger Print Icon
	@Override
	public WebElement getFingerprintIcon(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.systemui:id/biometric_icon")));
		return element;
	}

	// Login Screen - Touch the Fingerprint Sensor Text
	@Override
	public WebElement getTouchFingerprintSensorTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.TextView[@resource-id='com.android.systemui:id/error' and @content-desc='Touch the fingerprint sensor']")));
		return element;
	}

	// Login Screen - Cancel Button
	@Override
	public WebElement getCancelBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.TextView[@resource-id='com.android.systemui:id/button2' and @text='CANCEL']")));
		return element;
	}

	// Home Screen - HamburgerMenu Button
	@Override
	public WebElement getHamburgerMenuBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Menu")));
		return element;
	}

	// Home Screen - Swaglabs Title
	@Override
	public WebElement getSwaglabsTitle(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"test-Menu\"]//following-sibling::android.widget.ImageView")));
		return element;
	}

	// Home Screen - Cart Icon
	@Override
	public WebElement getCartIcon(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Cart")));
		return element;
	}

	// Home Screen - Products Text
	@Override
	public WebElement getProductsTxt(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + value + "']")));
		return element;
	}

	// Home Screen - Toggle Button
	@Override
	public WebElement getToggleBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Toggle")));
		return element;
	}

	// Home Screen - Filter Icon
	@Override
	public WebElement getFilterIcon(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Modal Selector Button")));
		return element;
	}

	// Home Screen - Product Name Text
	@Override
	public WebElement getProductNameTxt(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + value + "']")));
		return element;
	}

	// Home Screen - Product Price Text
	@Override
	public WebElement getProductPriceTxt(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + value + "']")));
		return element;
	}

	// Home Screen - Add To Cart Button
	@Override
	public WebElement getAddToCartBtn(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='"
				+ value + "']//following::android.widget.TextView[@text='ADD TO CART']")));
		return element;
	}

	// Home Screen - Remove Button
	@Override
	public WebElement getRemoveBtn(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='"
				+ value + "']//following::android.widget.TextView[@text='REMOVE']")));
		return element;
	}

	// Home Screen - Cart Batch Count
	@Override
	public WebElement getCartBatchCount(WebDriver dr) {
		wait = new WebDriverWait(dr, 5);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"test-Cart\"]//following-sibling::android.widget.TextView")));
		return element;
	}

	// Your Cart Screen - Title
	@Override
	public WebElement getYourCartTxt(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + value + "']")));
		return element;
	}

	// Your Cart Screen - Qty Text
	@Override
	public WebElement getQTYTxt(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + value + "']")));
		return element;
	}

	// Your Cart Screen - Description Text
	@Override
	public WebElement getDescTxt(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + value + "']")));
		return element;
	}

	// Your Cart Screen - Item Description Text
	@Override
	public WebElement getItemDescTxt(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + value + "']")));
		return element;
	}

	// Your Cart Screen - Item Amount Text
	@Override
	public WebElement getAmtTxt(WebDriver dr, String value) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + value + "']")));
		return element;
	}

	// Your Cart Screen - Remove Button
	@Override
	public WebElement getRemoveBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-REMOVE")));
		return element;
	}

	// Your Cart Screen - Continue Shopping Button
	@Override
	public WebElement getContinueShoppingBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-CONTINUE SHOPPING")));
		return element;
	}

	// Your Cart Screen - Checkout Button
	@Override
	public WebElement getCheckoutBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 10);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-CHECKOUT")));
		return element;
	}

	// Checkout Information - Title
	@Override
	public WebElement getCheckoutInfoTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='CHECKOUT: INFORMATION']")));
		return element;
	}

	// Checkout Information - First Name Input Field
	@Override
	public WebElement getFirstNameTxtFld(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-First Name")));
		return element;
	}

	// Checkout Information - Last Name Input Field
	@Override
	public WebElement getLastNameTxtFld(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Last Name")));
		return element;
	}

	// Checkout Information - ZipCode Input Field
	@Override
	public WebElement getZipCodeTxtFld(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Zip/Postal Code")));
		return element;
	}

	// Checkout Information - Cancel Button
	@Override
	public WebElement getCheckoutInfoCancelBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-CANCEL")));
		return element;
	}

	// Checkout Information - Continue Button
	@Override
	public WebElement getContinueBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-CONTINUE")));
		return element;
	}

	// Checkout Overview - Title
	@Override
	public WebElement getCheckoutOverviewTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")));
		return element;
	}

	// Checkout Overview - Item Total Text
	@Override
	public WebElement getItemTotalTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]//following::android.widget.TextView[contains(@text,'Item total')]")));
		return element;
	}

	// Checkout Overview - Tax Text
	@Override
	public WebElement getTaxTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]//following::android.widget.TextView[contains(@text,'Tax')]")));
		return element;
	}

	// Checkout Overview -Total Text
	@Override
	public WebElement getTotalTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]//following::android.widget.TextView[contains(@text,'Total')]")));
		return element;
	}

	// Checkout Overview - Finish Button
	@Override
	public WebElement getFinishBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-FINISH")));
		return element;
	}

	// Checkout Overview - Delete Button
	@Override
	public WebElement getDeleteBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Delete")));
		return element;
	}
	
	
	// Checkout Overview - Item Number
	@Override
	public WebElement getItemNum(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Amount\"])[1]")));
		return element;
	}

	// Checkout: Complete - Title
	@Override
	public WebElement getCheckoutCompleteTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='CHECKOUT: COMPLETE!']")));
		return element;
	}

	// Checkout: Complete -Thank You For Order Text
	@Override
	public WebElement getThankYouForOrderTxt(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")));
		return element;
	}

	// Checkout: Complete - Back Home Button
	@Override
	public WebElement getBackHomeBtn(WebDriver dr) {
		wait = new WebDriverWait(dr, 25);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-BACK HOME")));
		return element;
	}
	
	
	


}
