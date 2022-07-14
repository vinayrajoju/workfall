package com.workfall;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.workfall.base.TestBase;
import com.workfall.data.GetData;
import com.workfall.pages.clientpages.CardsPage;
import com.workfall.pages.clientpages.ClientLoginPage;
import com.workfall.pages.clientpages.SettingsPage;
import com.workfall.utils.ExtentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClientTest5 extends TestBase {
    private static Logger log = LogManager.getLogger(ClientTest5.class.getName());
    ClientLoginPage clientLoginPage;
    SettingsPage settingsPage;
    CardsPage cardsPage;
    GetData data;
    ExtentTest test;
    ExtentReports reports;

    public ClientTest5(){
        super();
    }
    @BeforeMethod
    public void setup() throws IOException
    {
        Initialize();
        reports= ExtentManager.getReports();
        test = reports.createTest("TestCase5","Adding Card Details");
        clientLoginPage = new ClientLoginPage();
        settingsPage = new SettingsPage();
        cardsPage = new CardsPage();
        data = new GetData();
    }

    @Test(priority = 4)
    public void addingCard() throws InterruptedException, IOException {
        clientLoginPage.clientLogin(prop.getProperty("clientId"), prop.getProperty("clientPwd") );
        settingsPage.navigateSettings();
        settingsPage.navigateSavedCards();
        cardsPage.addCard(data.getCardHolderName(),data.getCardNumber(),data.getCardExpDate(),data.getCardCVV());//prop.getProperty("CardHoldername"), prop.getProperty("Cardnumber"), prop.getProperty("CardExpdate"),prop.getProperty("Card_CVV/CVC")
        cardsPage.deleteCard();
    }
    @AfterMethod
    public void teardown()
    {
        close();
    }
}
