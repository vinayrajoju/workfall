package com.workfall.pages;

import com.workfall.base.TestBase;
import com.workfall.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TimeLogsPage extends TestBase {
    TestUtil util;
    @FindBy(css=".btn-addlogs")
    public WebElement addlog;

    @FindBy(css="li[style='pointer-events: auto;']")
    public List<WebElement> days;

    @FindBy(css="input[type='number']")
    public WebElement submithour;

    @FindBy(css="textarea[placeholder='Type your notes here...']")
    public WebElement worknotes;

    @FindBy(css="button[type='submit']")
    public WebElement worksubmit;

    @FindBy(css="#addWorksheet .btn-grey")
    public WebElement closeWorkSheet;


    public TimeLogsPage(){
        PageFactory.initElements(driver,this);
    }

    public void addLogs(){
        addlog.click();
    }

    public void setSubmithour(String hour){
        submithour.sendKeys(hour);
    }

    public void sendWorkNotes(String notes){
        worknotes.sendKeys(notes);
    }

    public void submitWork(){
        worksubmit.click();
    }

    public void selectWorkStreamDay(){
        wait.until(ExpectedConditions.invisibilityOfAllElements(days));
        LocalDateTime time = LocalDateTime.now();
        List<WebElement> Week = days ;
        for (int k =0 ;k<Week.size();k++)
        {
            String day = Week.get(k).getText();
           util = new TestUtil();
           //System.out.println(time.format(DateTimeFormatter.ofPattern("dd MMM")));
            if(day.contains(time.format(DateTimeFormatter.ofPattern("dd MMM"))));
            {
                days.get(k).click();
                break;
            }
        }
    }
    public void closeWorkSheet(){
        wait.until(ExpectedConditions.visibilityOf(closeWorkSheet));
        closeWorkSheet.click();
    }

}
