package workfall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import workfall.TestBase.App;
import workfall.Utils.ConfigLoader;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AfterPayment extends Login{

    private Logger log = LogManager.getLogger(App.class.getName());
    public JavascriptExecutor jsw =  (JavascriptExecutor) driver;
    private ConfigLoader config;

    @BeforeMethod
    public void Setup() throws IOException, InterruptedException
    {
        driver = Initialize();
    }

    @Test(priority=1)
    public void workStream_submission() throws InterruptedException
    {
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.get(prop.getProperty("partnerurl"));
        partnerLogin(driver);
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[routerlink='/user/my-dashboard/workstreams']")).click();
        Thread.sleep(3000);
        List<WebElement> projects =driver.findElements(By.cssSelector(".workstream-activity>.ws-header>div>div>h2"));
        for (int n =0 ;n<projects.size();n++)
        {
            String project = projects.get(n).getText();
            if(project.contains(prop.getProperty("client")))
            {
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                //System.out.println(project);
                driver.findElements(By.cssSelector(".workstream-activity>.ws-header>div>button[class='btn btn-view-workstream']")).get(n).click();
                //System.out.println("Success");
                break;
            }
        }
//		if((driver.findElement(By.cssSelector(".btn.btn.btn-addlogs")).getText() == "+ Add time logs"))
//		{
//
//		}
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn-addlogs")).click();
        Thread.sleep(3000);
        List<WebElement>days = driver.findElements(By.cssSelector("li[style='pointer-events: auto;']"));
        for(int o=0;o<days.size();o++)
        {
            String day=days.get(o).getText();
            if(day.equals(prop.getProperty("mm_dd")))
            {
                driver.findElements(By.cssSelector("li[style='pointer-events: auto;']")).get(o).click();
                break;
            }
        }
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(prop.getProperty("submitting_workstream_hrs"));
        driver.findElement(By.cssSelector("textarea[placeholder='Type your notes here...']")).sendKeys(prop.getProperty("work_description"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#confirmSubmitLogPopup button[class='btn btn-orange']")).click();
        WebDriverWait abc =new WebDriverWait(driver,180);
        abc.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#successTimelogSubmit .modal-content")));
        String msg= driver.findElement(By.cssSelector("#successTimelogSubmit .modal-title")).getText();
        String msg1= driver.findElement(By.cssSelector("#successTimelogSubmit .modal-body")).getText();
        System.out.println(msg+" "+msg1);
        driver.findElement(By.cssSelector("#successTimelogSubmit button[class='btn btn-grey']")).click();
//		abc.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
//		driver.findElement(By.cssSelector("")).click();
    }

    @Test(priority=2)
    public void acceptingWorkstream() throws InterruptedException
    {
        driver.get(prop.getProperty("URL"));
        login();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Workstreams']/following-sibling::a")).click();
        Thread.sleep(3000);
        List<WebElement> workstreams =driver.findElements(By.cssSelector(".workstream-activity>.header-w>div>div>h2"));
        for (int m =0 ;m<workstreams.size();m++)
        {
            String workstream = workstreams.get(m).getText();
            if(workstream.contains(prop.getProperty("partner")))
            {
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                System.out.println(workstream);
                driver.findElements(By.cssSelector(".workstream-activity>.header-w>div>button[class='btn btn-view-workstream']")).get(m).click();
                System.out.println("Success");
                break;
            }
        }
        Thread.sleep(3000);
        List<WebElement> days = driver.findElements(By.cssSelector("div>div[class='date']>h5:nth-child(2)"));
        for(int p=0;p<7;p++)
        {
            String day= days.get(p).getText();
            if(day.equals(prop.getProperty("day")))
            {
                Thread.sleep(3000);
                driver.findElements(By.cssSelector("div>div[class='date']>h5:nth-child(2)")).get(p).click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(prop.getProperty("accepting_workstream_hrs"));
        if((prop.getProperty("Accepting_description"))==null)
        {
            driver.findElement(By.cssSelector(".btn-approve")).click();
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#approveHoursWarning button[class='btn btn-orange']")).click();
            Thread.sleep(3000);
            if ((prop.getProperty("rejecting_workstream_hrs")) != null)
            {
                driver.findElement(By.cssSelector("input[type='number']")).sendKeys(prop.getProperty("rejecting_workstream_hrs"));
                driver.findElement(By.cssSelector("textarea[placeholder='Type your notes here...']")).sendKeys(prop.getProperty("Rejection_description"));
                driver.findElement(By.cssSelector(".btn-reject")).click();
                Thread.sleep(3000);
                driver.findElement(By.cssSelector("#rejectHoursWarning button[class='btn btn-orange']")).click();
                Thread.sleep(3000);
                driver.findElement(By.cssSelector("#viewWorksheet button[class='btn btn-close']")).click();
            }
            else
            {
                Thread.sleep(3000);
                driver.findElement(By.cssSelector("#viewWorksheet button[class='btn btn-close']")).click();
            }
        }
        else
        {
            driver.findElement(By.cssSelector("textarea[placeholder='Type your notes here...']")).sendKeys(prop.getProperty("Accepting_description"));
            driver.findElement(By.cssSelector(".btn-approve")).click();
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#approveHoursWarning button[class='btn btn-orange']")).click();
            Thread.sleep(3000);

            if ((prop.getProperty("rejecting_workstream_hrs")) != null) {
                driver.findElement(By.cssSelector("input[type='number']")).sendKeys(prop.getProperty("rejecting_workstream_hrs"));
                driver.findElement(By.cssSelector("textarea[placeholder='Type your notes here...']")).sendKeys(prop.getProperty("Rejection_description"));
                driver.findElement(By.cssSelector(".btn-reject")).click();
                Thread.sleep(3000);
                driver.findElement(By.cssSelector("#rejectHoursWarning button[class='btn btn-orange']")).click();
                Thread.sleep(3000);
                driver.findElement(By.cssSelector("#viewWorksheet button[class='btn btn-close']")).click();
            }
            else
            {
                Thread.sleep(3000);
                driver.findElement(By.cssSelector("#viewWorksheet button[class='btn btn-close']")).click();
            }
        }
    }
    @AfterMethod
    public void exit() throws InterruptedException
    {
        driver.close();
    }
}
