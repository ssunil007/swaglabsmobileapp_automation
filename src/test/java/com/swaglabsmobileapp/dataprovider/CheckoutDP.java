package com.swaglabsmobileapp.dataprovider;

import org.testng.annotations.DataProvider;

import com.swaglabsmobileapp.common.CommonCV;
import com.swaglabsmobileapp.common.DriverSetup;

public class CheckoutDP extends CommonCV {
	
	String platFormName = DriverSetup.getPlatform();
	
	
	// Test Data to verify Home Screen Validations
	@DataProvider(name = "HomeScreen_Validations")
	public static Object[][] HomeScreen_Validations() {
		return new Object[][] {
				{ "TC_01", loginPin, "PRODUCTS|Sauce Labs Backpack|$29.99|ADD TO CART|Sauce Labs Bike Light|$9.99",
						"PRODUCTS|Sauce Labs Backpack|$29.99|ADD TO CART|Sauce Labs Bike Light|$9.99" } };
	}

	// Test Data to verify cart batch count
	@DataProvider(name = "CartBatchCount_AddOrRemoveItems")
	public static Object[][] CartBatchCount_AddOrRemoveItems() {
		return new Object[][] { { "TC_01", loginPin, "Sauce Labs Backpack|1|Sauce Labs Bike Light|2|1",
				"Sauce Labs Backpack|1|Sauce Labs Bike Light|2|1" } };
	}
	
	// Test Data to verify your cart screen for adding / removing items
	@DataProvider(name = "YourCartScreen_AddOrRemoveItems")
	public static Object[][] YourCartScreen_AddOrRemoveItems() {
		return new Object[][] { { "TC_01", loginPin,
				"Sauce Labs Backpack|$29.99|Sauce Labs Bike Light|$9.99|2|YOUR CART|QTY|DESCRIPTION|1|PRODUCTS",
				"Sauce Labs Backpack|$29.99|Sauce Labs Bike Light|$9.99|2|YOUR CART|QTY|DESCRIPTION|1|PRODUCTS" } };
	}
	
	
	// Test Data to verify your cart screen for adding / removing items
	@DataProvider(name = "CheckoutOverviewScreen_RemovingItems")
	public static Object[][] CheckoutOverviewScreen_RemovingItems() {
		return new Object[][] { { "TC_01", loginPin, firstName, lastName, zipCode,
				"Sauce Labs Backpack|$29.99|Sauce Labs Bike Light|$9.99|2|YOUR CART|QTY|DESCRIPTION|Item total: $39.98|Tax: $3.20|Total: $43.18",
				"Sauce Labs Backpack|$29.99|Sauce Labs Bike Light|$9.99|2|YOUR CART|QTY|DESCRIPTION|Item total: $0.00|Tax: $0.00|Total: $0.00" } };
	}
	
	// Test Data to verify your cart screen for adding / removing items
	@DataProvider(name = "CheckoutOverviewScreen_AddingItemsAndCheckOut")
	public static Object[][] CheckoutOverviewScreen_AddingItemsAndCheckOut() {
		return new Object[][] { { "TC_01", loginPin, firstName, lastName, zipCode,
				"Sauce Labs Backpack|$29.99|Sauce Labs Bike Light|$9.99|2|YOUR CART|QTY|DESCRIPTION|Item total: $39.98|Tax: $3.20|Total: $43.18",
				"Sauce Labs Backpack|$29.99|Sauce Labs Bike Light|$9.99|2|YOUR CART|QTY|DESCRIPTION|Item total: $39.98|Tax: $3.20|Total: $43.18" } };
	}

}
