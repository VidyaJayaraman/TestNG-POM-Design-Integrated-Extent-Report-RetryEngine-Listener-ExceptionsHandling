package com.testleaf.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import com.testleaf.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {

	public ViewLeadPage(ChromeDriver driver, ExtentTest node) {

		this.driver = driver;
		this.node = node;

	}

	public ViewLeadPage editLead(String editCompanyName) throws IOException {

		try {
			driver.findElement(By.linkText("Edit")).click();
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(editCompanyName);
			driver.findElement(By.name("submitButton")).click();
			reportStep("Edit Lead successful", "pass");
		} catch (Exception e) {
			reportStep("Unable to edit Lead details", "fail");
		}
		return this;
	}
}
