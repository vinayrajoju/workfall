package com.workfall;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.workfall.base.TestBase;
import com.workfall.data.GetData;
import com.workfall.pages.ConfirmationPopupPage;
import com.workfall.pages.Workstreampage;
import com.workfall.pages.partnerpages.HomePage;
import com.workfall.pages.partnerpages.PartnerLoginPage;
import com.workfall.pages.partnerpages.SuccessPopupPage;
import com.workfall.utils.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PartnerTest1 extends TestBase {

    private static Logger log = LogManager.getLogger(PartnerTest1.class.getName());

    PartnerLoginPage partnerLoginPage;
    HomePage homePage;
    Workstreampage workstreamPage;
    ConfirmationPopupPage confirmPage;
    SuccessPopupPage successPopupPage;
    GetData data;
    ExtentTest test;


    TestUtil testUtil = new TestUtil();

    public PartnerTest1()
    {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException
    {

        Initialize();
        partnerLoginPage = new PartnerLoginPage();
        homePage = new HomePage();
        workstreamPage = new Workstreampage();
        confirmPage = new ConfirmationPopupPage();
        successPopupPage = new SuccessPopupPage();
        data = new GetData();

    }
    @Test
    public void acceptRequest() throws InterruptedException, IOException {

       test = extent.createTest("TestCase2","Accepting the ClientRequest");
       homePage = partnerLoginPage.partnerLogin(prop.getProperty("partnerId"), prop.getProperty("partnerPwd"));
       test.log(Status.INFO,"Partner logged in successfully");               //log.info("Partner logged in successfully");
       homePage.requests.click();
       test.log(Status.INFO,"Searching for client");                         //log.debug("Searching for client");
       workstreamPage.acceptRequest(data.getClientFullName());
       successPopupPage.closePopup();
       test.log(Status.PASS,"Accepted the request");                         //log.info(confirmPage.success.getText());

    }

    @AfterMethod
    public void teardown(){
        close();
    }
}
