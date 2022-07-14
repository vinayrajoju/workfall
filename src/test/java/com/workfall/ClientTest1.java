package com.workfall;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.workfall.base.TestBase;
import com.workfall.data.GetData;
import com.workfall.pages.ConfirmationPopupPage;
import com.workfall.pages.CongratsPopupPage;
import com.workfall.pages.clientpages.ClientLoginPage;
import com.workfall.pages.clientpages.ConfirmBookingRequestPage;
import com.workfall.pages.clientpages.DashboardPage;
import com.workfall.pages.clientpages.PartnersPage;
import com.workfall.utils.ExtentManager;
import com.workfall.utils.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClientTest1 extends TestBase {
    //private static Logger log = LogManager.getLogger(ClientTest1.class.getName());

    ConfirmBookingRequestPage requestPage;
    ClientLoginPage clientLoginPage;
    DashboardPage dashboardPage ;
    PartnersPage partnersPage;
    ConfirmationPopupPage confirmPage;
    CongratsPopupPage congratsPopupPage;

    TestUtil testUtil = new TestUtil();
    GetData data;
    ExtentTest test;
    ExtentReports reports;



    public ClientTest1()
    {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException
    {
        Initialize();
        reports= ExtentManager.getReports();
        test = reports.createTest("TestCase1","BookRequest with partner "+data.getPartnerName()+" for "+data.getBookingHours()+"Hrs");
        clientLoginPage = new ClientLoginPage();
        dashboardPage = new DashboardPage();
        partnersPage = new PartnersPage();
        requestPage = new ConfirmBookingRequestPage();
        confirmPage = new ConfirmationPopupPage();
        congratsPopupPage = new CongratsPopupPage();
        data = new GetData();
    }

    @Test(priority = 1)
    public void bookRequest() throws InterruptedException, IOException {
        dashboardPage = clientLoginPage.clientLogin(prop.getProperty("clientId"), prop.getProperty("clientPwd"));
        test.log(Status.INFO,"Logged in Successfully");                                     //log.debug("Logged in successfully");
        partnersPage = dashboardPage.partnersMenu();
        dashboardPage.mycrew.click();
        test.log(Status.INFO, "Searching for Partner");
        partnersPage.selectPartner(data.getPartnerName());
        requestPage.confirmBooking(data.getBookingHours(),data.getWorkStreamDescription());
        confirmPage.yes();
        congratsPopupPage.ok();
        test.log(Status.PASS,"Requested partner for "+data.getBookingHours()+"hrs");        //log.debug("Requested partner for "+data.getBookingHours()+"hrs");
    }

    @AfterMethod
    public void teardown(){
        close();
        reports.flush();
    }



}
