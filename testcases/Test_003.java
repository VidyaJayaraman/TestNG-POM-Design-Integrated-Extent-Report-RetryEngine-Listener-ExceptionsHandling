
package com.testleaf.testcases;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.testleaf.base.ProjectSpecificMethods;
import com.testleaf.pages.LoginPage;

public class Test_003 extends ProjectSpecificMethods {
	

	@BeforeTest
	public void setFilename() {
		filename = "EditLeadCmpy";
		
  	//  Extent report Details
		testCaseName = "EditLead";
		testDescription ="Edit lead company details";
		testAuthor = "Vidya";
		testCategory = "Smoke";
	}

	@Test(dataProvider = "fetchData")
	public void editLead(String username, String password,String firstname, String lastname,String editCompanyName) throws InterruptedException, IOException

	{
        LoginPage lp = new LoginPage(driver, node);
		lp.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLeads()
		.findByName(firstname,lastname)
		.clickLeadName(firstname)
		.editLead(editCompanyName);
		

	}


}
