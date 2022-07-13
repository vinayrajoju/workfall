package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import com.workfall.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CallSchedulePage extends TestBase {
    TestUtil util;

    @FindBy(css=".ui-dropdown")
    WebElement dropdown;

    @FindBy(css=".ui-dropdown-filter")
    WebElement searchfilter;

    @FindBy(css=".dropText")
    WebElement selectpartner;

    @FindBy(css = ".ui-datepicker-month")
    WebElement month;

    @FindBy(css = ".ui-datepicker-year")
    WebElement year;

    @FindBy(css = ".pi-chevron-right")
    WebElement chevronright;

//    private final String getdate = "getslotdate";
//    @FindBy(xpath = "//a[text()='"+getdate+"']")
//    WebElement date;

    @FindBy(css = ".ui-hour-picker>span:nth-child(3)")
    WebElement hour;

    @FindBy(css = ".ui-hour-picker .pi-chevron-up")
    WebElement hrchevronup;

    @FindBy(css = ".ui-ampm-picker>span")
    WebElement merideim;

    @FindBy(css=".ui-ampm-picker>a>.pi-chevron-up")
    WebElement merideimchevronup;

    @FindBy(css=".btn-save")
    WebElement sendRequest;

    public CallSchedulePage() {
        PageFactory.initElements(driver, this);
    }


    public void setSelectpartner(String partnerName){
        dropdown.click();
        searchfilter.sendKeys(partnerName);
        selectpartner.click();
    }

    public void SendRequest(){
        sendRequest.click();
    }

    public void setslot(Integer slotDiff,String slotNo) throws InterruptedException //,String getdate,String slotmonth,String slotyear

    {
        // Month&Year
        util = new TestUtil();
        util.getDateandTime(String.valueOf(slotDiff));
        System.out.println(util.hour);
        driver.findElement(By.cssSelector("p-calendar[name='"+slotNo+"']>span>button")).click();
        System.out.println(util.meridiem);
        Thread.sleep(5000);
        String monthValue =month.getText();
        String yearValue = year.getText();
        while (!(monthValue.equals(util.month) || yearValue.equals(util.year)))
        {
           chevronright.click();
            monthValue = month.getText();
            yearValue = year.getText();
        }
        // Date
       driver.findElement(By.xpath("//a[text()='"+util.day+"']")).click();
        System.out.println(util.day);
        // Hour
        Integer slotHour = Integer.valueOf(hour.getText());
        //Integer hr = Integer.valueOf(slothr);
        while(slotHour.equals(Integer.valueOf(util.hour)))
        {
            hrchevronup.click();
            slotHour = Integer.valueOf(hour.getText());
        }
        // Minutes
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-minute-picker>a>.pi-chevron-up")));
//		String slot1min = driver.findElement(By.cssSelector(".ui-minute-picker>.ng-tns-c92-0:nth-child(3)")).getText();
//		String min = prop.getProperty("slot1minutes");
//		while(!(slot1min.equals(min)))
//		{
//			driver.findElement(By.cssSelector(".ui-minute-picker>a>.pi-chevron-up")).click();
//			slot1min = driver.findElement(By.cssSelector(".ui-minute-picker>.ng-tns-c92-0:nth-child(3)")).getText();
//		}
        // AMPM
        String ampm = merideim.getText();
        //String meridiem = slotmeridiem ;
        while(!(ampm.equals(util.meridiem)))
        {
            merideimchevronup.click();
            ampm = merideim.getText();
        }
        util.waitTime();
    }
}
