package com.swaglabsmobileapp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.ConnectionClosedException;

import com.swaglabsmobileapp.common.DriverSetup;
import com.swaglabsmobileapp.objectrepo.BaseObjRepo;

import io.appium.java_client.android.AndroidDriver;

public class CheckoutPage extends BasePage {
	
	String platFormName = DriverSetup.getPlatform();
	
	/**
	 * @author sunil_s
	 * @description Method to verify home screen validations
	 * @param TC
	 * @return
	 */
	public boolean HomeScreen_Validations(String TC,WebDriver dr, BaseObjRepo obj, String pin,String actRes, String expRes){
		
		String[] actResult = actRes.split("\\|");
		String[] expResult = expRes.split("\\|");
		
		try {
		
			commonUtils.loginWithFingerAuthentication(dr, obj, pin);
			obj.getHamburgerMenuBtn(dr).isDisplayed();
			obj.getSwaglabsTitle(dr).isDisplayed();
			obj.getCartIcon(dr).isDisplayed();
			obj.getProductsTxt(dr, actResult[0]).getText().trim().equalsIgnoreCase(expResult[0]);
			obj.getToggleBtn(dr).isDisplayed();
			obj.getFilterIcon(dr).isDisplayed();
			
			obj.getProductNameTxt(dr, actResult[1]).getText().trim().equalsIgnoreCase(expResult[1]);
			obj.getProductPriceTxt(dr, actResult[2]).getText().trim().equalsIgnoreCase(expResult[2]);
			obj.getAddToCartBtn(dr, actResult[1]).isDisplayed();
			obj.getProductNameTxt(dr, actResult[3]).getText().trim().equalsIgnoreCase(expResult[3]);
			obj.getProductPriceTxt(dr, actResult[4]).getText().trim().equalsIgnoreCase(expResult[4]);
			obj.getAddToCartBtn(dr, actResult[3]).isDisplayed();
			
			System.out.println("TestCase :  PASS");
			return true;
			
		} catch (TimeoutException te) {
			te.printStackTrace();
			System.out.println("TestCase: FAIL <Timeout Exception> " + te.getMessage());
			return false;
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			System.out.println("TestCase: FAIL <NoSuchElement Exception> " + nse.getMessage());
			return false;
		} catch (ConnectionClosedException cce) {
			cce.printStackTrace();
			System.out.println("TestCase: FAIL <ConnectionClosed Exception> " + cce.getMessage());
			return false;
		} catch (Exception ie) {
			ie.printStackTrace();
			System.out.println("TestCase: FAIL <Exception> " + ie.getMessage());
			return false;
		}	
	}
	
	
	/**
	 * @author sunil_s
	 * @description Method to verify cart batch count
	 * @param TC
	 * @return
	 */
	public boolean CartBatchCount_AddOrRemoveItems(String TC,WebDriver dr, BaseObjRepo obj, String pin,String actRes, String expRes){
		
		String[] actResult = actRes.split("\\|");
		String[] expResult = expRes.split("\\|");
		
		try {
		
			obj.getAddToCartBtn(dr, actResult[0]).click();
			obj.getCartBatchCount(dr).getText().trim().equalsIgnoreCase(expResult[1]);
			obj.getAddToCartBtn(dr, actResult[2]).click();
			obj.getCartBatchCount(dr).getText().trim().equalsIgnoreCase(expResult[3]);
			obj.getRemoveBtn(dr, actResult[0]).click();
			obj.getCartBatchCount(dr).getText().trim().equalsIgnoreCase(expResult[4]);
			obj.getRemoveBtn(dr, actResult[2]).click(); waitforElementToLoad(1);
			try{
				obj.getCartBatchCount(dr).isDisplayed();
			}catch (Exception e) {
				System.out.println("----> Batch count is not displayed");
			}
			System.out.println("TestCase :  PASS");
			return true;
			
		} catch (TimeoutException te) {
			te.printStackTrace();
			System.out.println("TestCase: FAIL <Timeout Exception> " + te.getMessage());
			return false;
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			System.out.println("TestCase: FAIL <NoSuchElement Exception> " + nse.getMessage());
			return false;
		} catch (ConnectionClosedException cce) {
			cce.printStackTrace();
			System.out.println("TestCase: FAIL <ConnectionClosed Exception> " + cce.getMessage());
			return false;
		} catch (Exception ie) {
			ie.printStackTrace();
			System.out.println("TestCase: FAIL <Exception> " + ie.getMessage());
			return false;
		}	
	}

	
	/**
	 * @author sunil_s
	 * @description Method to verify your cart screen for adding & remove items
	 * @param TC
	 * @return
	 */
	public boolean YourCartScreen_AddOrRemoveItems(String TC,WebDriver dr, BaseObjRepo obj, String pin,String actRes, String expRes){
		
		String[] actResult = actRes.split("\\|");
		String[] expResult = expRes.split("\\|");
		
		try {
		
			obj.getAddToCartBtn(dr, actResult[0]).click(); waitforElementToLoad(1);
			obj.getAddToCartBtn(dr, actResult[1]).click(); waitforElementToLoad(1);
			obj.getCartBatchCount(dr).getText().trim().equalsIgnoreCase(expResult[2]);
			
			obj.getCartBatchCount(dr).click();waitforElementToLoad(1);
			
			obj.getYourCartTxt(dr, actResult[5]).getText().trim().equalsIgnoreCase(expResult[5]);
			obj.getQTYTxt(dr, actResult[6]).getText().trim().equalsIgnoreCase(expResult[6]);
			obj.getDescTxt(dr, actResult[7]).getText().trim().equalsIgnoreCase(expResult[7]);
			
			obj.getItemDescTxt(dr, actResult[0]).getText().trim().equalsIgnoreCase(expResult[0]);
			obj.getAmtTxt(dr, actResult[1]).getText().trim().equalsIgnoreCase(expResult[1]);
			obj.getRemoveBtn(dr).click(); waitforElementToLoad(1);
			obj.getCartBatchCount(dr).getText().trim().equalsIgnoreCase(expResult[8]);
			
			
			obj.getItemDescTxt(dr, actResult[2]).getText().trim().equalsIgnoreCase(expResult[2]);
			obj.getAmtTxt(dr, actResult[3]).getText().trim().equalsIgnoreCase(expResult[3]);
			obj.getRemoveBtn(dr).click(); waitforElementToLoad(1);
			
			obj.getContinueShoppingBtn(dr).click(); waitforElementToLoad(2);
			obj.getProductsTxt(dr, actResult[9]).getText().trim().equalsIgnoreCase(expResult[9]);
			
		
			System.out.println("TestCase :  PASS");
			return true;
			
		} catch (TimeoutException te) {
			te.printStackTrace();
			System.out.println("TestCase: FAIL <Timeout Exception> " + te.getMessage());
			return false;
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			System.out.println("TestCase: FAIL <NoSuchElement Exception> " + nse.getMessage());
			return false;
		} catch (ConnectionClosedException cce) {
			cce.printStackTrace();
			System.out.println("TestCase: FAIL <ConnectionClosed Exception> " + cce.getMessage());
			return false;
		} catch (Exception ie) {
			ie.printStackTrace();
			System.out.println("TestCase: FAIL <Exception> " + ie.getMessage());
			return false;
		}		
	}
	
	
	/**
	 * @author sunil_s
	 * @description Method to verify checkout overview for removing items
	 * @param TC
	 * @return
	 */
	public boolean CheckoutOverviewScreen_RemovingItems(String TC,WebDriver dr, BaseObjRepo obj, String pin,String fName, String lName, String zip,String actRes, String expRes){
		
		String[] actResult = actRes.split("\\|");
		String[] expResult = expRes.split("\\|");
		WebElement delete,itemTxt;
		int itemTxtLocationX, itemNum;
		
		try {
		
			obj.getAddToCartBtn(dr, actResult[0]).click(); waitforElementToLoad(1);
			obj.getAddToCartBtn(dr, actResult[2]).click(); waitforElementToLoad(1);
			obj.getCartBatchCount(dr).getText().trim().equalsIgnoreCase(expResult[2]);
			
			obj.getCartBatchCount(dr).click();waitforElementToLoad(1);
			
			obj.getYourCartTxt(dr, actResult[5]).getText().trim().equalsIgnoreCase(expResult[5]);
			obj.getQTYTxt(dr, actResult[6]).getText().trim().equalsIgnoreCase(expResult[6]);
			obj.getDescTxt(dr, actResult[7]).getText().trim().equalsIgnoreCase(expResult[7]);
			
			WebElement checkoutBtn = scrollToCheckoutBtn(dr, obj, 0.70, 0.10, 3);
			checkoutBtn.click(); waitforElementToLoad(2);
			
			obj.getCheckoutInfoTxt(dr).isDisplayed();
			obj.getFirstNameTxtFld(dr).sendKeys(fName);
			obj.getLastNameTxtFld(dr).sendKeys(lName);
			obj.getZipCodeTxtFld(dr).sendKeys(zip);
			((AndroidDriver<?>)dr).hideKeyboard(); waitforElementToLoad(1);
			
			obj.getContinueBtn(dr).click();waitforElementToLoad(2);
			
			obj.getCheckoutOverviewTxt(dr).isDisplayed();
			commonUtils.scrollToEle(dr, 0.90, 0.10);
			obj.getItemTotalTxt(dr).getText().trim().equalsIgnoreCase(actResult[8]);
			obj.getTaxTxt(dr).getText().trim().equalsIgnoreCase(actResult[9]);
			obj.getTotalTxt(dr).getText().trim().equalsIgnoreCase(actResult[10]);
			
			((AndroidDriver<?>)dr).scrollTo(actResult[0]);	
			// Deleting Item 1
			itemTxt = obj.getItemDescTxt(dr, actResult[0]);
			itemTxt.isDisplayed();
			itemTxtLocationX = itemTxt.getLocation().getX();
			itemNum = obj.getItemNum(dr).getLocation().getX();
			horizontalSwipe(dr, itemTxtLocationX, itemNum);
			 
			delete = obj.getDeleteBtn(dr);
			delete.isDisplayed();
			delete.click();
			
			//Deleting Item 2
			itemTxt = obj.getItemDescTxt(dr, actResult[2]);
			itemTxt.isDisplayed();
			itemTxtLocationX = itemTxt.getLocation().getX();
			itemNum = obj.getItemNum(dr).getLocation().getX();
			horizontalSwipe(dr, itemTxtLocationX, itemNum);
	
			delete = obj.getDeleteBtn(dr);
			delete.isDisplayed();
			delete.click();
			
			WebElement itemTotal = obj.getItemTotalTxt(dr);
			WebElement tax = obj.getTaxTxt(dr);
			WebElement total = obj.getTotalTxt(dr);
			
			if (itemTotal.getText().trim().equalsIgnoreCase(expResult[8])
					&& tax.getText().trim().equalsIgnoreCase(expResult[9])
					&& total.getText().trim().equalsIgnoreCase(expResult[10])) {
				System.out.println("TestCase :  PASS");
			} else {
				System.out.println("TestCase: FAIL: Expected : " + expResult[8] + " | " + expResult[9] + " | "
						+ expResult[10] + " Actual : " + itemTotal.getText() + " | " + tax.getText() + " | "
						+ total.getText());
				obj.getCheckoutInfoCancelBtn(dr).click();
				return false;
			}

			return true;
			
		} catch (TimeoutException te) {
			te.printStackTrace();
			System.out.println("TestCase: FAIL <Timeout Exception> " + te.getMessage());
			obj.getCheckoutInfoCancelBtn(dr).click();
			return false;
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			System.out.println("TestCase: FAIL <NoSuchElement Exception> " + nse.getMessage());
			obj.getCheckoutInfoCancelBtn(dr).click();
			return false;
		} catch (ConnectionClosedException cce) {
			cce.printStackTrace();
			System.out.println("TestCase: FAIL <ConnectionClosed Exception> " + cce.getMessage());
			obj.getCheckoutInfoCancelBtn(dr).click();
			return false;
		} catch (Exception ie) {
			ie.printStackTrace();
			System.out.println("TestCase: FAIL <Exception> " + ie.getMessage());
			obj.getCheckoutInfoCancelBtn(dr).click();
			return false;
		}		
	}
	
	/**
	 * @author sunil_s
	 * @description Method to verify checkout overview for adding items and checkout
	 * @param TC
	 * @return
	 */
	public boolean CheckoutOverviewScreen_AddingItemsAndCheckOut(String TC,WebDriver dr, BaseObjRepo obj, String pin,String fName, String lName, String zip,String actRes, String expRes){
		
		String[] actResult = actRes.split("\\|");
		String[] expResult = expRes.split("\\|");
		
		try {
		
			obj.getAddToCartBtn(dr, actResult[0]).click(); waitforElementToLoad(1);
			obj.getAddToCartBtn(dr, actResult[2]).click(); waitforElementToLoad(1);
			obj.getCartBatchCount(dr).getText().trim().equalsIgnoreCase(expResult[2]);
			
			obj.getCartBatchCount(dr).click();waitforElementToLoad(1);
			
			obj.getYourCartTxt(dr, actResult[5]).getText().trim().equalsIgnoreCase(expResult[5]);
			obj.getQTYTxt(dr, actResult[6]).getText().trim().equalsIgnoreCase(expResult[6]);
			obj.getDescTxt(dr, actResult[7]).getText().trim().equalsIgnoreCase(expResult[7]);
			
			WebElement checkoutBtn = scrollToCheckoutBtn(dr, obj, 0.70, 0.10, 3);
			checkoutBtn.click(); waitforElementToLoad(2);
			
			obj.getCheckoutInfoTxt(dr).isDisplayed();
			obj.getFirstNameTxtFld(dr).sendKeys(fName);
			obj.getLastNameTxtFld(dr).sendKeys(lName);
			obj.getZipCodeTxtFld(dr).sendKeys(zip);
			((AndroidDriver<?>)dr).hideKeyboard(); waitforElementToLoad(1);
			
			obj.getContinueBtn(dr).click();waitforElementToLoad(2);
			
			obj.getCheckoutOverviewTxt(dr).isDisplayed();
			obj.getItemDescTxt(dr, actResult[0]).getText().trim().equalsIgnoreCase(expResult[0]);
			obj.getAmtTxt(dr, actResult[1]).getText().trim().equalsIgnoreCase(expResult[1]);
			obj.getItemDescTxt(dr, actResult[2]).getText().trim().equalsIgnoreCase(expResult[2]);
			((AndroidDriver<?>)dr).scrollTo("FINISH");
			
			WebElement itemTotal = obj.getItemTotalTxt(dr);
			WebElement tax = obj.getTaxTxt(dr);
			WebElement total = obj.getTotalTxt(dr);
			
			if (itemTotal.getText().trim().equalsIgnoreCase(expResult[8])
					&& tax.getText().trim().equalsIgnoreCase(expResult[9])
					&& total.getText().trim().equalsIgnoreCase(expResult[10])) {
				System.out.println("TestCase :  PASS");
			} else {
				System.out.println("TestCase: FAIL: Expected : " + expResult[8] + " | " + expResult[9] + " | "
						+ expResult[10] + " Actual : " + itemTotal.getText() + " | " + tax.getText() + " | "
						+ total.getText());
				obj.getCheckoutInfoCancelBtn(dr).click();
				return false;
			}
			
			obj.getFinishBtn(dr).click();waitforElementToLoad(2);
			obj.getCheckoutCompleteTxt(dr).isDisplayed();
			obj.getThankYouForOrderTxt(dr).isDisplayed();
			obj.getBackHomeBtn(dr).click();
			return true;
			
		} catch (TimeoutException te) {
			te.printStackTrace();
			System.out.println("TestCase: FAIL <Timeout Exception> " + te.getMessage());
			obj.getCheckoutInfoCancelBtn(dr).click();
			return false;
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			System.out.println("TestCase: FAIL <NoSuchElement Exception> " + nse.getMessage());
			obj.getCheckoutInfoCancelBtn(dr).click();
			return false;
		} catch (ConnectionClosedException cce) {
			cce.printStackTrace();
			System.out.println("TestCase: FAIL <ConnectionClosed Exception> " + cce.getMessage());
			obj.getCheckoutInfoCancelBtn(dr).click();
			return false;
		} catch (Exception ie) {
			ie.printStackTrace();
			System.out.println("TestCase: FAIL <Exception> " + ie.getMessage());
			obj.getCheckoutInfoCancelBtn(dr).click();
			return false;
		}		
	}
	
	
	/**
	 * @author sunil_s
	 * @description Method to perform Horizontal Swipe
	 * @param dr
	 * @param startx
	 * @param endx
	 */
	public void horizontalSwipe(WebDriver dr, int startx, int endx) {
		Dimension dSize = dr.manage().window().getSize();
		int starty = dSize.height / 2;
		waitforElementToLoad(3);
		((AndroidDriver<?>) dr).swipe(startx, starty, endx, starty, 1000);
	}
	
	/**
	 * @author sunil_s
	 * @description Method to perform scrolling to a particular element 
	 * @param dr
	 * @param ele
	 * @param x
	 * @param y
	 */
	public WebElement scrollToCheckoutBtn(WebDriver dr, BaseObjRepo obj, double x, double y, int maxScroll){
		
		WebElement ele = null;
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		while(maxScroll!=0){
			try{
				ele= obj.getCheckoutBtn(dr);
				if("ANDROID".equalsIgnoreCase(platFormName)){
					ele.isDisplayed();
					break;
				}else{
					ele.getAttribute("visible").equalsIgnoreCase("true");
				}
			}catch (Exception e) {
				commonUtils.scrollToEle(dr, x, y);
			}
			maxScroll--;
		}
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return ele;
	}
	
	

}
