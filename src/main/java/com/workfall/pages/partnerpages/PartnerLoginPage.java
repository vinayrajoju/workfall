package com.workfall.pages.partnerpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.workfall.base.TestBase.driver;
import static com.workfall.base.TestBase.prop;

public class PartnerLoginPage {
    private static Logger log = LogManager.getLogger(PartnerLoginPage.class.getName());

    public PartnerLoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="input[name='email']")
    WebElement email;

    @FindBy(css="input[type='password']")
    WebElement password;

    @FindBy(css="iframe[title='chat widget']")
    WebElement frame;

    @FindBy(css = "use[fill-rule='evenodd']")
    WebElement hubspot;

    @FindBy(css = "i[class='fa fa-times']")
    WebElement footer;

    @FindBy(css = ".orange-button")
    WebElement loginbutton;



    public HomePage partnerLogin(String id, String pwd){
        JavascriptExecutor scroll = (JavascriptExecutor)driver;
        driver.get(prop.getProperty("partnerURL"));
        email.sendKeys(id);
        password.sendKeys(pwd);
        scroll.executeScript("window.scrollBy(0,200)","");
        loginbutton.click();
        driver.switchTo().frame(frame);
        hubspot.click();
        driver.switchTo().parentFrame();
        //footer.click();

        return new HomePage();

    }

}

