package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import com.workfall.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class ClientWorkStreamsPage extends TestBase {
    TestUtil util;


    public ClientWorkStreamsPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".workstream-activity>.header-w>div>button[class='btn btn-view-workstream']")
    List<WebElement> viewWorkStream;

    @FindBy(css=".workstream-activity>.header-w>div>div>h2")
    List<WebElement> partnerList;

    @FindBy(css="div>div[class='date']>h5:nth-child(2)")
    List<WebElement> week;

    @FindBy(css="input[type='number']")
    WebElement hours;

    @FindBy(css="textarea[placeholder='Type your notes here...']")
    WebElement notes;

    @FindBy(css=".btn-approve")
    WebElement approveButton;

    @FindBy(css=" #approveHoursWarning button[class='btn btn-orange']")
    WebElement confirmButton;

    @FindBy(css="#rejectHoursWarning button[class='btn btn-orange']")
    WebElement reject_confirm;

    @FindBy(css=".btn-reject")
    WebElement rejectButton;
    @FindBy(css="#viewWorksheet button[class='btn btn-close']")
    WebElement close;
    public void selectWorkStream(String partnername) throws InterruptedException {
        List<WebElement> partners = partnerList;
        for (int j =0 ;j<partners.size();j++)
        {
            String partner = partners.get(j).getText();
            if(partner.contains(partnername))
            {
                viewWorkStream.get(j).click();
                break;
            }
        }
    }

    public void selectDay() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(week));
        List<WebElement> days = week;
        for (int k =0 ;k<days.size();k++)
        {
            String day = days.get(k).getText();
            util = new TestUtil();
            if(day.equals(util.currentWeek))
            {
                week.get(k).click();
                break;
            }
        }
    }
//    public void selectDay1(String Day){
//        List<WebElement> days = week;
//        for (WebElement day : days) {
//            if(days.equals(Day)){
//                day.click();
//            }
//        }
//    }

    public void workStreamReview(String Approve_hours,String approve_notes,String Reject_hours,String wsnotes) throws InterruptedException {
        if((Integer.valueOf(Approve_hours)) == 0) {
            if (Integer.valueOf(Reject_hours ) > 0 ) {
                hours.sendKeys(Reject_hours);
                notes.sendKeys(wsnotes);
                rejectButton.click();
                reject_confirm.click();
                Thread.sleep(1500);
                close.click();
            }
            else
            {
                close.click();
            }
        }
        else
        {
            hours.sendKeys(Approve_hours);
            if (approve_notes != null) {
                notes.sendKeys(approve_notes);
                approveButton.click();
                confirmButton.click();
            }
            else
            {
                approveButton.click();
                confirmButton.click();

            }
            Thread.sleep(3000);
            if (Integer.valueOf(Reject_hours) > 0)
            {
                hours.sendKeys(Reject_hours);
                notes.sendKeys(wsnotes);
                rejectButton.click();
                reject_confirm.click();
                Thread.sleep(1500);
                close.click();
            }
            else
            {
                close.click();
            }

        }
    }

}
