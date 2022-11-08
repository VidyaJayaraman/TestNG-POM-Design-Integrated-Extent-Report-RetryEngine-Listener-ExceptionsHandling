package com.testleaf.testcases;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.testleaf.base.ProjectSpecificMethods;
import com.testleaf.pages.LoginPage;

public class Test_002 extends ProjectSpecificMethods {
	

	@BeforeTest
	public void setFilename() {
		filename = "CreateLead";
		
     //	Extent report Details
		testCaseName = "CreateLead";
		testDescription ="Create a Lead with name and company details";
		testAuthor = "Vidya";
		testCategory = "Smoke";
	}

	@Test(dataProvider = "fetchData")
	public void createLead(String username, String password, String companyname, String firstname, String lastname)
			throws InterruptedException, IOException

	{

		LoginPage lp = new LoginPage(driver,node);
		
		lp.enterUsername(username).enterPassword(password).clickLogin().clickCRMSFA().clickLeads().clickCreateLeads()
				.enterCompanyname(companyname).enterFirstname(firstname).enterLastname(lastname).clickCreateLead()
				.verifyLead();

	}

}
