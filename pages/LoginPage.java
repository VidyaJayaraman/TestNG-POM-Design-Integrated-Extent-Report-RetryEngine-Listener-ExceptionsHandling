package com.testleaf.pages;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.testleaf.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(ChromeDriver driver, ExtentTest node) {

		this.driver = driver;
		this.node = node;
		// PageFactory.initElements(driver,this);

	}

	// Page Factory (Alternate way to find web elements)
	// @FindBy(how = How.ID , using ="username")
	// WebElement eleUsername;
	// eleUsername.sendKeys(username);

	public LoginPage enterUsername(String username) throws IOException {
		try {
			driver.findElement(By.id("username")).sendKeys(username);
			reportStep("Username is entered successfully", "pass");
		} catch (NoSuchElementException e) {
			reportStep("Username element is not found", "fail");
		}
//		LoginPage lp = new LoginPage();
		return this;

	}

	// Page Factory
	// @FindBy(how = How.ID , using ="password")
	// WebElement elePassword;
	// elePassword.sendKeys(password);

	public LoginPage enterPassword(String password) throws IOException {

		try {
			driver.findElement(By.id("password")).sendKeys(password);
			reportStep("Password is entered successfully", "pass");
		} catch (NoSuchElementException e) {
			reportStep("Password element is not found", "fail");
		}

		return this;
	}

	public HomePage clickLogin() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Login Successful", "pass");
		} catch (Exception e) {
			reportStep("Unable to Login", "fail");
		}

		return new HomePage(driver, node);
	}

}
