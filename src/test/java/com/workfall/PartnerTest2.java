package com.workfall;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.workfall.base.TestBase;
import com.workfall.data.GetData;
import com.workfall.pages.ConfirmationPopupPage;
import com.workfall.pages.TimeLogsPage;
import com.workfall.pages.Workstreampage;
import com.workfall.pages.partnerpages.HomePage;
import com.workfall.pages.partnerpages.PartnerLoginPage;
import com.workfall.pages.partnerpages.SuccessPopupPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PartnerTest2 extends TestBase {
    private static Logger log = LogManager.getLogger(PartnerTest2.class.getName());
    PartnerLoginPage partnerLoginPage;
    GetData data;
    HomePage homePage;
    Workstreampage workstreamPage;
    TimeLogsPage timeLogsPage;
    ConfirmationPopupPage popupPage;
    ExtentTest test;
    SuccessPopupPage successPopupPage;

    public PartnerTest2()
    {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException
    {
        Initialize();
       partnerLoginPage = new PartnerLoginPage();
       homePage = new HomePage();
       data = new GetData();
       workstreamPage = new Workstreampage();
       timeLogsPage = new TimeLogsPage();
       popupPage = new ConfirmationPopupPage();
        successPopupPage = new SuccessPopupPage();
    }
    @Test(priority = 6)
    public void workStreamSubmission() throws InterruptedException, IOException {
        test = extent.createTest("TestCase6","Submitting WorkStreams");
        partnerLoginPage.partnerLogin(prop.getProperty("partnerId"), prop.getProperty("partnerPwd"));
        homePage.workstreams.click();
        test.log(Status.INFO, "Selecting WorkStream");
        workstreamPage.selectWorkStream(data.getClientFullName());//prop.getProperty("clientname")
        timeLogsPage.addLogs();
        timeLogsPage.selectWorkStreamDay();
        test.log(Status.INFO,"Submitting WorkStream Hours");
        timeLogsPage.setSubmithour(data.getWorkStreamSubmissionHours());//prop.getProperty("workedhours")
        test.log(Status.INFO,"Adding WorkStream Notes");
        timeLogsPage.worknotes.sendKeys(data.getWorkStreamSubmissionDescription());//prop.getProperty("workstreamnotes")
        timeLogsPage.submitWork();
        popupPage.confirmLog();
        successPopupPage.closeSuccessPopup();
        timeLogsPage.closeWorkSheet();
        test.log(Status.PASS,"WorkStream Submitted successfully");
    }

    @AfterMethod
    public void teardown()
    {
        close();
    }
}
