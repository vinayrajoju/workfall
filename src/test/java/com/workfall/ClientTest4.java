package com.workfall;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.workfall.base.TestBase;
import com.workfall.data.GetData;
import com.workfall.pages.*;
import com.workfall.pages.clientpages.*;
import com.workfall.utils.ExtentManager;
import com.workfall.utils.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClientTest4 extends TestBase {

    private static Logger log = LogManager.getLogger(ClientTest4.class.getName());

    ConfirmBookingRequestPage requestPage;
    ClientLoginPage clientLoginPage;
    DashboardPage dashboardPage ;
    PartnersPage partnersPage;
    ConfirmationPopupPage confirmPage;

    ClientWorkStreamsPage clientWorkStreamsPage;

    TestUtil testUtil = new TestUtil();
    GetData data;
    ExtentTest test;
    ExtentReports reports;


    public ClientTest4()
    {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException
    {

        Initialize();
        reports= ExtentManager.getReports();
        test = reports.createTest("TestCase7","Reviewing the WorkStream");
        clientLoginPage = new ClientLoginPage();
        dashboardPage = new DashboardPage();
        partnersPage = new PartnersPage();
        requestPage = new ConfirmBookingRequestPage();
        confirmPage = new ConfirmationPopupPage();
        clientWorkStreamsPage = new ClientWorkStreamsPage();
        data = new GetData();
    }
    @Test(priority = 7)
    public void reviewWorkStream() throws InterruptedException, IOException {
        dashboardPage = clientLoginPage.clientLogin(prop.getProperty("clientId"), prop.getProperty("clientPwd"));
        test.log(Status.INFO,"Client logged in Successfully");                //log.debug("Logged in successfully");
        dashboardPage.navigateWorkStreams();
        test.log(Status.INFO,"Searching for WorkStream");
        clientWorkStreamsPage.selectWorkStream(data.getPartnerName());
        clientWorkStreamsPage.selectDay();
        clientWorkStreamsPage.workStreamReview(data.getAcceptWorkStreamHours(),data.getAcceptanceNotes(),data.getRejectWorkStreamHours(),data.getRejectNotes());//prop.getProperty("ApproveWorkstreamhours"), prop.getProperty("ApproveNotes"), prop.getProperty("RejectWorkstreamhours"), prop.getProperty("Rejectnotes")
        test.log(Status.PASS, "WorkStream Reviewed Successfully");
    }
    @AfterMethod
    public void teardown()
    {
        close();
    }
}
