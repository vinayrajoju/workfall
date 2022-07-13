package com.workfall;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.workfall.base.TestBase;
import com.workfall.data.GetData;
import com.workfall.pages.ConfirmationPopupPage;
import com.workfall.pages.clientpages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClientTest2 extends TestBase {

    private static Logger log = LogManager.getLogger(ClientTest2.class.getName());
    ClientLoginPage clientLoginPage;
    DashboardPage dashboardPage;

    PaymentPage paymentPage;
    PaymentprocessPage paymentprocessPage;
    ConfirmationPopupPage confirmationPopupPage;
    SuccessMessagePage successMessagePage;
    GetData data;
    ExtentTest test;


    public ClientTest2()
    {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException {

        Initialize();
        clientLoginPage = new ClientLoginPage();
        dashboardPage = new DashboardPage();
        paymentPage = new PaymentPage();
        paymentprocessPage = new PaymentprocessPage();
        data = new GetData();
        confirmationPopupPage = new ConfirmationPopupPage();
        successMessagePage = new SuccessMessagePage();
    }

    @Test(priority = 2)
    public void payment() throws InterruptedException, IOException {
        test = extent.createTest("TestCase3","WireTranfer payment for Contract");
        clientLoginPage.clientLogin(prop.getProperty("clientId"), prop.getProperty("clientPwd") );
        test.log(Status.INFO,"Client logged in Successfully");
        dashboardPage.requests.click();
        dashboardPage.accepted.click();
        test.log(Status.INFO,"Searching for partner");
        paymentPage.selectPartner(data.getPartnerName());
        paymentprocessPage.wireTransferPayment();
        confirmationPopupPage.acceptpay.click();
        successMessagePage.closePopup();
        test.log(Status.PASS,"WireTransfer Payment completed");
    }

    @AfterMethod
    public void teardown(){
        close();
    }
}
