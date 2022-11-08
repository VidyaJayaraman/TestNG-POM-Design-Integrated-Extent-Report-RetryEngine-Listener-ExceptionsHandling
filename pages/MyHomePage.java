package com.testleaf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import com.testleaf.base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {

	public MyHomePage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	public MyHomePage clickLeads() {

		driver.findElement(By.linkText("Leads")).click();

		// driver.findElement(By.linkText(prop1.getProperty("lead"))).click();
		return this;
	}

	public CreateLeadPage clickCreateLeads()

	{

		driver.findElement(By.linkText("Create Lead")).click();
		// driver.findElement(By.linkText(prop1.getProperty("create_lead"))).click();
		return new CreateLeadPage(driver, node);
	}

	public FindLeadPage clickFindLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLeadPage(driver, node);

	}
}
