package com.swaglabsmobileapp.scenarios;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglabsmobileapp.common.DriverSetup;
import com.swaglabsmobileapp.dataprovider.CheckoutDP;
import com.swaglabsmobileapp.objectrepo.BaseObjRepo;
import com.swaglabsmobileapp.pages.CheckoutPage;

public class CheckoutScenarioTest extends DriverSetup {
	
	String platFormName, logFilePath;

	@BeforeMethod
	public void setUp() throws Exception {
		driverSet();
		platFormName = DriverSetup.getPlatform();
		logFilePath = DriverSetup.getLogfilePath();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		try {
			if (!result.isSuccess()) {
				SimpleDateFormat formater = new SimpleDateFormat("ddMMyyyy_HHmmss");
				Calendar calendar = Calendar.getInstance();

				String classname1 = this.getClass().getName();
				int clsname2 = classname1.lastIndexOf('.') + 1;
				String className = classname1.substring(clsname2);

				String methodName = result.getName();

				String parameter = String.format("TestNG Debugger : %s() running with parameters %s.",
						result.getMethod().getConstructorOrMethod().getName(), Arrays.toString(result.getParameters()));
				System.out.println("parameter: " + parameter);
				String tcName = parameter.substring(parameter.indexOf("[") + 1, parameter.indexOf("[") + 6);

				// To capture the screenshot for the failure case(s)
				File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File((logFilePath + className + "_" + methodName + "_"
						+ tcName + "_" + formater.format(calendar.getTime()) + ".png")));

				if ("ANDROID".equalsIgnoreCase(platFormName)) {
					// To capture the logs for the failure case(s)
					System.out.println("Saving device log - start");
					List<LogEntry> logEntries = getDriver().manage().logs().get("logcat").filter(Level.ALL);

					File logFile = new File(logFilePath + className + "_" + methodName + "_" + tcName + "_"
							+ formater.format(calendar.getTime()) + ".txt");
					@SuppressWarnings("resource")
					PrintWriter log_file_writer = new PrintWriter(logFile);
					for (LogEntry logEntry : logEntries) {
						if (logEntry.getMessage().toLowerCase().contains("com.monefy.app.lite")) {
							log_file_writer.println(logEntry);
							log_file_writer.flush();
						}
					}
					System.out.println("Saving device log - finish");
				}

			}
			// getDriver().quit();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@AfterClass
	public void suiteTearDown() throws Exception {
		getDriver().quit();
	}
	
	

	/**
	 * @author sunil_s
	 * @description Test Method to verify home screen 
	 * @param TC
	 */
	@Test(description = "Test to verify home screen", dataProvider = "HomeScreen_Validations", dataProviderClass = CheckoutDP.class)
	public void verifyHomeScreen_Validations(String TC,String LoginPIN ,String ActResult, String ExpResult) {

		try {
			BaseObjRepo baseOR = getSetupor().getbaseobjrep();
			WebDriver dr = getDriver();
			printTestScriptExecutionInfo(TC);
			CheckoutPage page = new CheckoutPage();
 			Assert.assertTrue(page.HomeScreen_Validations(TC,dr, baseOR,LoginPIN,ActResult,ExpResult));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
	/**
	 * @author sunil_s
	 * @description Test Method to verify cart batch count
	 * @param TC
	 */
	@Test(description = "Test to verify cart batch count  by adding / removing items", dataProvider = "CartBatchCount_AddOrRemoveItems", dataProviderClass = CheckoutDP.class)
	public void verifyCartBatchCount_AddOrRemoveItems(String TC,String LoginPIN ,String ActResult, String ExpResult) {

		try {
			BaseObjRepo baseOR = getSetupor().getbaseobjrep();
			WebDriver dr = getDriver();
			printTestScriptExecutionInfo(TC);
			CheckoutPage page = new CheckoutPage();
 			Assert.assertTrue(page.CartBatchCount_AddOrRemoveItems(TC,dr, baseOR,LoginPIN,ActResult,ExpResult));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * @author sunil_s
	 * @description Test Method to verify your cart screen
	 * @param TC
	 */
	@Test(description = "Test to verify your cart screen to add / remove items", dataProvider = "YourCartScreen_AddOrRemoveItems", dataProviderClass = CheckoutDP.class)
	public void verifyYourCartScreen_AddOrRemoveItems(String TC,String LoginPIN ,String ActResult, String ExpResult) {

		try {
			BaseObjRepo baseOR = getSetupor().getbaseobjrep();
			WebDriver dr = getDriver();
			printTestScriptExecutionInfo(TC);
			CheckoutPage page = new CheckoutPage();
 			Assert.assertTrue(page.YourCartScreen_AddOrRemoveItems(TC,dr, baseOR,LoginPIN,ActResult,ExpResult));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
	/**
	 * @author sunil_s
	 * @description Test Method to verify your cart screen
	 * @param TC
	 */
	@Test(description = "Test to verify checkout overview to remove items", dataProvider = "CheckoutOverviewScreen_RemovingItems", dataProviderClass = CheckoutDP.class)
	public void verifyCheckoutOverviewScreen_RemovingItems(String TC,String LoginPIN ,String FName, String LName, String Zip,String ActResult, String ExpResult) {

		try {
			BaseObjRepo baseOR = getSetupor().getbaseobjrep();
			WebDriver dr = getDriver();
			printTestScriptExecutionInfo(TC);
			CheckoutPage page = new CheckoutPage();
 			Assert.assertTrue(page.CheckoutOverviewScreen_RemovingItems(TC,dr, baseOR,LoginPIN,FName, LName, Zip,ActResult,ExpResult));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * @author sunil_s
	 * @description Test Method to verify your cart screen
	 * @param TC
	 */
	@Test(description = "Test to verify checkout overview to remove items", dataProvider = "CheckoutOverviewScreen_AddingItemsAndCheckOut", dataProviderClass = CheckoutDP.class)
	public void verifyCheckoutOverviewScreen_AddingItemsAndCheckOut(String TC,String LoginPIN ,String FName, String LName, String Zip,String ActResult, String ExpResult) {

		try {
			BaseObjRepo baseOR = getSetupor().getbaseobjrep();
			WebDriver dr = getDriver();
			printTestScriptExecutionInfo(TC);
			CheckoutPage page = new CheckoutPage();
 			Assert.assertTrue(page.CheckoutOverviewScreen_AddingItemsAndCheckOut(TC,dr, baseOR,LoginPIN,FName, LName, Zip,ActResult,ExpResult));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
