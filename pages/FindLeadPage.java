package com.testleaf.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.ExtentTest;
import com.testleaf.base.ProjectSpecificMethods;

public class FindLeadPage extends ProjectSpecificMethods {

	public FindLeadPage(ChromeDriver driver, ExtentTest node) {

		this.driver = driver;
		this.node = node;

	}

	public FindLeadPage findByName(String firstname, String lastname) throws InterruptedException, IOException {

		try {
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("//span[text()='Name and ID']")).click();
			reportStep(" Click Find Leads ", "pass");
		} catch (Exception e) {
			reportStep(" Find Leads link not clicked ", "fail");
		}
		try {
			driver.findElement(By.xpath("//span[contains(text(),'ID')]/following::input[@name='firstName']"))
					.sendKeys(firstname);
			driver.findElement(By.xpath("//span[contains(text(),'ID')]/following::input[@name='lastName']"))
					.sendKeys(lastname);
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep(" Find Lead by Name ", "pass");
		} catch (Exception e) {
			reportStep(" Find Lead by Name ", "fail");
		}
		return this;

	}

	public ViewLeadPage clickLeadName(String firstname) throws InterruptedException, IOException

	{
		try {
			WebElement eleLead = driver.findElement(By.xpath("//a[text()='" + firstname + "']"));
			wait.until(ExpectedConditions.elementToBeClickable(eleLead));
			eleLead.click();
			reportStep(" Lead Name clicked", "pass");
		} catch (Exception e) {
			reportStep(" Lead name found not clicked  ", "fail");
		}

		return new ViewLeadPage(driver, node);

	}

}
