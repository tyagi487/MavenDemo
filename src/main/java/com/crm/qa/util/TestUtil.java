package com.crm.qa.util;

import com.crm.qa.Base.TestBase;

public class TestUtil extends TestBase{
	
	public static int Page_Load_Timeout=20;
	public static int Implict_Wait=25;
	
	
	public  void switchtoFrame() {
		driver.switchTo().frame("mainpanel");
	}

}
