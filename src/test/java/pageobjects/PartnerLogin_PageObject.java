package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartnerLogin_PageObject {

    public WebDriver driver;

    By pemail =By.cssSelector("input[name='email']");
    By ppassword = By.cssSelector("input[type='password']");
    By frame1 = By.cssSelector("iframe[title='chat widget']");
    By hubspot1 = By.cssSelector("use[fill-rule='evenodd']");
    By footer1 = By.cssSelector("i[class='fa fa-times']");
    By partnerloginbutton = By.cssSelector(".orange-button");

    public PartnerLogin_PageObject (WebDriver driver) {
        this.driver=driver;
        driver.manage().window().maximize();
    }
    public WebElement getpartnerEmail()
    {

        return driver.findElement(pemail);
    }
    public WebElement getpartnerPassword()
    {
        return driver.findElement(ppassword);
    }
    public WebElement gethubspot1() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(frame1));
        return driver.findElement(hubspot1);
    }
    public WebElement getFooter1()
    {
        return driver.findElement(footer1);
    }
    public WebElement getpartnerloginbutton()
    {
        return driver.findElement(partnerloginbutton);
    }

}
