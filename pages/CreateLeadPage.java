package com.testleaf.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.testleaf.base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods {

	public CreateLeadPage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	public CreateLeadPage enterCompanyname(String companyname) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
			reportStep("CompanyName entered", "pass");
		} catch (Exception e) {
			reportStep("Companyname not entered", "fail");
		}

		return this;
	}

	public CreateLeadPage enterFirstname(String firstname) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
			reportStep("FirstName entered", "pass");
		} catch (Exception e) {
			reportStep("FirstName not entered", "fail");
		}
		return this;
	}

	public CreateLeadPage enterLastname(String lastname) throws IOException {

		try {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
			reportStep("LastName entered", "pass");
		} catch (Exception e) {
			reportStep("LastName not entered", "fail");
		}

		return this;
	}

	public CreateLeadPage clickCreateLead() throws InterruptedException, IOException {
		Thread.sleep(4000);
		try {
			driver.findElement(By.name("submitButton")).click();
			String titlePage = driver.getTitle();
			Assert.assertTrue(titlePage.contains("Lead"));
			reportStep("Lead Created", "pass");
		} catch (Exception e) {
			reportStep("Lead not Created", "pass");
		}
		return this;
	}

	public CreateLeadPage verifyLead() throws IOException {
		try {
			String verifyLeadName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
			Assert.assertEquals(verifyLeadName, "Vidya");
			reportStep("Lead Verified", "pass");
		} catch (Exception e) {
			reportStep("Lead Verification Failed", "fail");
		}
		return this;
	}

}
