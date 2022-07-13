package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientLoginPage extends TestBase {
    private static Logger log = LogManager.getLogger(ClientLoginPage.class.getName());


    public ClientLoginPage() {
        PageFactory.initElements(TestBase.driver, this);
    }
    @FindBy(css="input[name='email-address']")
    WebElement emailid;
    @FindBy(css="input[type='password']")
    WebElement password;
    @FindBy(css="iframe[title='chat widget']")
    WebElement iframe;
    @FindBy(css="use[fill-rule='evenodd']")
    WebElement hubspot;
    @FindBy(css="i[class='fa fa-times']")
    WebElement footer;
    @FindBy(xpath="//button[contains(text(),'Sign In')] ")
    WebElement LoginButton;

//    public ClientLoginPage(){
//        PageFactory.initElements(driver, this);
//    }


    public DashboardPage clientLogin(String id, String pwd) throws InterruptedException {
        JavascriptExecutor scroll = (JavascriptExecutor)driver;
        driver.get(prop.getProperty("clientURL"));
        emailid.sendKeys(id);
        password.sendKeys(pwd);
        scroll.executeScript("window.scrollBy(0,200)","");
        LoginButton.click();
        driver.switchTo().frame(iframe);
        //hubspot.click();
        driver.switchTo().parentFrame();
//        footer.click();
        Thread.sleep(3000);

        return new DashboardPage();
    }



}
