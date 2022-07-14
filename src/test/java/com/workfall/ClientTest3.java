package com.workfall;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.workfall.base.TestBase;
import com.workfall.data.GetData;
import com.workfall.pages.ConfirmationPopupPage;
import com.workfall.pages.clientpages.CallSchedulePage;
import com.workfall.pages.clientpages.ClientLoginPage;
import com.workfall.pages.clientpages.DashboardPage;
import com.workfall.pages.clientpages.SuccessMessagePage;
import com.workfall.utils.ExtentManager;
import com.workfall.utils.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClientTest3 extends TestBase {
    private static Logger log = LogManager.getLogger(ClientTest3.class.getName());
    ClientLoginPage clientLoginPage;
    DashboardPage dashboardPage;
    CallSchedulePage callSchedulePage;
    ConfirmationPopupPage popupPage;
    SuccessMessagePage successPage;
    TestUtil util;
    GetData data;
    ExtentTest test;
    ExtentReports reports;

    public ClientTest3()
    {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException {

        Initialize();
        reports= ExtentManager.getReports();
        test = reports.createTest("TestCase4","Scheduling a Call with partner");
        clientLoginPage = new ClientLoginPage();
        dashboardPage = new DashboardPage();
        callSchedulePage = new CallSchedulePage();
        popupPage = new ConfirmationPopupPage();
        successPage = new SuccessMessagePage();
        data = new GetData();
        util = new TestUtil();
    }
    @Test(priority = 3)
    public void scheduleCall() throws InterruptedException, IOException {
        clientLoginPage.clientLogin(prop.getProperty("clientId"), prop.getProperty("clientPwd"));
        dashboardPage.navigateSchedule();
        callSchedulePage.setSelectpartner(data.getPartnerName());
        test.log(Status.INFO,"Selecting Slot1");            //log.debug("Selecting Slot1");
        callSchedulePage.setslot(12,"slot1");        //,prop.getProperty("slot1date"), prop.getProperty("slot1month"), prop.getProperty("slot1year")
        test.log(Status.INFO, "Selecting Slot2");           //log.debug("Selecting Slot2");
        callSchedulePage.setslot(24,"slot2");        //,prop.getProperty("slot2date"), prop.getProperty("slot2month"), prop.getProperty("slot2year")
        test.log(Status.INFO, "Selecting Slot3");           //log.debug("Selecting Slot3");
        callSchedulePage.setslot(42,"slot3");        //,prop.getProperty("slot3date"), prop.getProperty("slot3month"), prop.getProperty("slot3year")
        test.log(Status.INFO, "Calls got scheduled and Requested to partner");      //log.info("Calls got scheduled and Requested to partner");
        callSchedulePage.SendRequest();
        popupPage.imSure.click();
        successPage.getClose();
    }

   @AfterMethod
    public void teardown(){
        close();
    }
}
