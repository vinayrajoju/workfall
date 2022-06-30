package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard_PageObject {

    public WebDriver driver;

    By partners =By.cssSelector("img[alt='Partners']");
    By call = By.xpath("//a[text()='Calls ']");
    By schedulecall = By.cssSelector("img[alt='Schedule a Call']");
    By payment = By.xpath("//a[text()='Requests ']");

    public Dashboard_PageObject (WebDriver driver) {
        this.driver=driver;
    }
    public WebElement getpartners()
    {
        return driver.findElement(partners);
    }
    public WebElement getcall()
    {
        return driver.findElement(call);
    }
    public WebElement getschedulecall()
    {
        return driver.findElement(schedulecall);
    }
    public WebElement getpayment()
    {
        return driver.findElement(payment);
    }
}
