package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import org.testng.Assert;

import com.qmetry.qaf.automation.step.QAFTestStep;

public class StepsLibrary {
	/**
	 * @param searchTerm
	 *            : search term to be searched
	 */
	static String currentBalance = "";
	static String amountTobeCredited = "";
	
	@QAFTestStep(description = "Current balance {0}")
	public static void currentBalance(String balance) {
		currentBalance = balance;
		System.out.println("Current balance is " + balance);
	}
	
	@QAFTestStep(description = "Credit amount {0}")
	public static void creditAmount(String amount) {
		System.out.println("Amount to be credited is " + amount);
		amountTobeCredited = amount;
		currentBalance = String.valueOf(Integer.parseInt(currentBalance) + Integer.parseInt(amountTobeCredited));
	}
	
	@QAFTestStep(description = "Verify balance is {0}")
	public static void verifyBalance(String updatedAmount) {
		Assert.assertEquals(currentBalance, updatedAmount);
	}
}
