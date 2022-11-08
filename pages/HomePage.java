package com.testleaf.pages;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import com.testleaf.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage(ChromeDriver driver, ExtentTest node) {

		this.driver = driver;
		this.node = node;

	}

	public MyHomePage clickCRMSFA() throws IOException {
		try {
			driver.findElement(By.linkText("CRM/SFA")).click();
			reportStep("click CRM/SFA ", "pass");
		} catch (NoSuchElementException e) {
			reportStep("CRM/SFA Element not found ", "fail");
		}
		return new MyHomePage(driver, node);

	}

}
