package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends TestBase {

    @FindBy(css="img[alt='Partners']")
    WebElement partnermenu;

    @FindBy(xpath="//span[text()='My Crew']")
    public WebElement mycrew;

    @FindBy(css="img[alt='Workstreams']")
    public WebElement workstream;

    @FindBy(xpath="//a[text()='Calls ']")
    public WebElement calls;

    @FindBy(css="img[alt='Schedule a Call']")
    WebElement schedulecall;

    @FindBy(xpath="//a[text()='Requests ']")
    public WebElement requests;

    @FindBy(css="img[alt='Requests Accepted']")
    public WebElement accepted;





    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public PartnersPage partnersMenu() throws InterruptedException {
        Thread.sleep(2000);
        partnermenu.click();

        return new PartnersPage();
    }

    public CallSchedulePage navigateSchedule()
    {
        calls.click();
        schedulecall.click();
        return new CallSchedulePage();
    }

    public void navigateWorkStreams(){
        workstream.click();
    }
//    public PartnersPage crewlist(){
//        mycrew.click();
//
//        return new PartnersPage();
//    }
	
}



