package com.testleaf.testcases;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.testleaf.base.ProjectSpecificMethods;
import com.testleaf.pages.LoginPage;

public class Test_001 extends ProjectSpecificMethods {

	@BeforeTest

	public void setFilename() {
		filename = "Login";

		// Extent report Details

		testCaseName = "Login";
		testDescription = "To Check Login details";
		testAuthor = "Vidya";
		testCategory = "Smoke";

	}

	@Test(dataProvider = "fetchData")
	// @Test
	public void runLogin(String username, String password) throws InterruptedException, IOException

	{
		LoginPage lp = new LoginPage(driver, node);
		lp.enterUsername(username).enterPassword(password).clickLogin();
	}

}
