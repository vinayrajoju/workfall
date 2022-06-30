package workfall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import workfall.TestBase.App;
import workfall.Utils.ConfigLoader;


public class Client extends Login {

	private Logger log = LogManager.getLogger(Client.class.getName());
	public JavascriptExecutor jsw =  (JavascriptExecutor) driver;
	private ConfigLoader config;

	@BeforeMethod
	public void Setup() throws IOException, InterruptedException
	{
		driver = Initialize();
	}
	//SearchpartnerfromMycrew
	@Test(priority = 1)
	public void bookRequest() throws InterruptedException, IOException {
		//driver.manage().timeouts().getImplicitWaitTimeout()
		driver.get(prop.getProperty("URL"));
		login();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[alt='Partners']")).click();	
		driver.findElement(By.xpath("//span[text()='My Crew']")).click();
		Thread.sleep(1500);
		log.debug("Searching for partner from crew list ...");
		List<WebElement> crew = driver.findElements(By.cssSelector("h2[style='cursor: pointer;']"));
		JavascriptExecutor jsw =  (JavascriptExecutor) driver;
        jsw.executeScript("window.scrollBy(0,220)", "");
		for(int i=0;i<crew.size();i++)
		{
			String partners = crew.get(i).getText();
			System.out.println(partners);
			if(partners.contains(prop.getProperty("partner")))
			{
				Thread.sleep(3000);
				log.debug("Partner found");
				driver.findElements(By.xpath("//div[@class='all-crew-list']/div/div[2]/button[@class='btn btn-newOffer']")).get(i).click();
				//System.out.println(partners);
				break;
			}		
		}
		Thread.sleep(3000);
		log.debug("Adding Request details ...");
		driver.findElement(By.cssSelector("input[formcontrolname$='hours']")).sendKeys(prop.getProperty("hours"));
		driver.findElement(By.cssSelector("input[placeholder='Pick a Date']")).click();
		driver.findElement(By.cssSelector("td>span[class*='myDpMarkCurrDay']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("textarea[formcontrolname='description']")).sendKeys(prop.getProperty("description"));
		driver.findElement(By.xpath("//div[@class='modal-content']/div[2]/form/div[3]")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("div[class='modal-content']>div>div:nth-child(2)>button:nth-child(1)")).click();
		log.info(getDate());
		driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.MINUTES);
		Thread.sleep(3000);
		WebDriverWait wait= new WebDriverWait(driver, 90 );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#congratsModal>.modal-dialog>.modal-content>.modal-body>p[class='short-info']")));
		String a = driver.findElement(By.cssSelector("div[id='congratsModal']>div>div>div:nth-child(1)>h4")).getText();
		String b = driver.findElement(By.cssSelector("#congratsModal>.modal-dialog>.modal-content>.modal-body>p[class='short-info']")).getText();
		driver.findElement(By.cssSelector("div[id='congratsModal']>div>div>div:nth-child(2)>div>button[type='button']")).click();
		log.info(a+" "+b);
		driver.navigate().refresh();
		driver.findElement(By.cssSelector(".header-profile-icon")).click();
		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".logout>img[alt='logout icon']")).click();
//		driver.manage().deleteAllCookies();
	}

	@Test(priority = 5)
	public void addingCard() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		driver.get(prop.getProperty("URL"));
		login();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.findElement(By.cssSelector(".header-profile-icon")).click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("div[class='profile-info']>div>ul>li>a[routerlink='/clients/settings/about']")).click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(".payment")).click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("a[routerlink='/clients/settings/saved-cards']")).click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(".btn-add")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name on card']")).sendKeys(prop.getProperty("cardname"));
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Secure card number input frame']")));
		driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys(prop.getProperty("cardnumber"));
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Secure expiration date input frame']")));
		driver.findElement(By.cssSelector("input[placeholder='MM / YY']")).sendKeys(prop.getProperty("ExpDate"));
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Secure CVC input frame']")));
		driver.findElement(By.cssSelector("input[placeholder='CVC']")).sendKeys(prop.getProperty("CVV"));
		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector(".addCard")).click();
		driver.findElement(By.cssSelector("#cardAddedpopup1 .btn-send")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cardAddedpopup2 .modal-content")));
		System.out.println(driver.findElement(By.cssSelector("#cardAddedpopup2 .payCmplt>h3")).getText());
		driver.findElement(By.cssSelector("#cardAddedpopup2 .btn")).click();

		
	}
	@Test(priority = 2)
	public void partnerAccept() throws InterruptedException, IOException
	{	
		WebDriverWait wait=new WebDriverWait(driver,150);

//		driver.navigate().refresh();
		driver.get(prop.getProperty("partnerurl"));
		partnerLogin(driver);
		Thread.sleep(3000);
		log.debug("Navigating to Workstreams");
		driver.findElement(By.cssSelector("a[routerlink='/user/my-dashboard/requests']")).click();
		Thread.sleep(4000);
		log.debug("Searching for the client");
		List<WebElement> requests =driver.findElements(By.cssSelector(".all-request-list>.request>div:nth-child(2)>div:nth-child(2)>div>div>h3"));
		for (int j =0 ;j<requests.size();j++)
		{
			String request = requests.get(j).getText();
			if(request.contains(prop.getProperty("clientfullname")))
			{
				System.out.println("clientfullname"+request);
				log.debug("Client found");
				driver.findElements(By.cssSelector(".all-request-list>.request>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>button:nth-child(1)")).get(j).click();
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkmark")));
		driver.findElement(By.cssSelector(".checkmark")).click();
		driver.findElement(By.cssSelector("div[id='acceptClientModal']>div>div>div:nth-child(2)>form>button[type='submit']")).click();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
//		WebDriverWait def=new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[id='accpetClientSuccessModal']>div>div>div:nth-child(2)>h5")));
		String e=driver.findElement(By.cssSelector("div[id='accpetClientSuccessModal']>div>div>div:nth-child(1)>h4")).getText();
		String f=driver.findElement(By.cssSelector("div[id='accpetClientSuccessModal']>div>div>div:nth-child(2)>h5")).getText();
		System.out.println(e+" "+f);
		log.info(e+" "+f);
		driver.findElement(By.cssSelector("div[id='accpetClientSuccessModal']>div>div>div:nth-child(2)>button[type='button']")).click();
	}

	
	@Test(priority=3)
	public void wiretransferPayment() throws InterruptedException
	{
		driver.get(prop.getProperty("URL"));
		login();
		driver.findElement(By.xpath("//a[text()='Requests ']")).click();
		Thread.sleep(2000);
		log.debug("Navigating to requested page");
		driver.findElement(By.cssSelector("img[alt='Requests Accepted']")).click();
		Thread.sleep(3000);
		log.debug("Searching for partner who accpeted the request");
		List<WebElement> Partnerslist = driver.findElements(By.cssSelector("div[class='expert']>h3"));
		for(int l=0;l<Partnerslist.size();l++)
		{
			String Partners= Partnerslist.get(l).getText();
			if(Partners.equalsIgnoreCase(prop.getProperty("partner_fullname")))
			{
				log.debug("Partner found");
				driver.findElements(By.cssSelector(".btn-paynow")).get(l).click();
				break;
			}
		}
		Thread.sleep(3000);
		log.info("Navigating to Payment screen");
		driver.findElement(By.cssSelector(".details>div:nth-child(3)>.btn-next")).click();
		Thread.sleep(2000);
		log.info("Selecting WireTransfer Payment");
		driver.findElement(By.cssSelector(".payWireBtn")).click();
		driver.findElement(By.cssSelector(".btn-next")).click();
		Thread.sleep(2000);
		String refId=driver.findElement(By.cssSelector(".ref")).getText();
		log.info(refId);
		System.out.println(refId);
		driver.findElement(By.cssSelector(".downloadPay>h5")).click();
		log.debug("Invoice downloaded");
		JavascriptExecutor jsw =  (JavascriptExecutor) driver;
		jsw.executeScript("window.scrollBy(0,220)", "");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector(".btn-next")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn-cancel-request")).click();
		//Thread.sleep(3000);
		WebDriverWait abc =new WebDriverWait(driver,1500);
		abc.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.viewPortHeight div.content-wrapper-client:nth-child(2) div.activity-dashboard div.container div.row div.activity-dashboard-wrapper div.activity-dashboard-content div.requests div.modal.fade.payment-info-modal.show:nth-child(5) div.modal-dialog div.modal-content div.modal-footer > button.btn.btn-orange")));
		log.info(driver.findElement(By.cssSelector("div[class='modal-content']>div:nth-child(2)>p")).getText());
		driver.findElement(By.cssSelector("div.viewPortHeight div.content-wrapper-client:nth-child(2) div.activity-dashboard div.container div.row div.activity-dashboard-wrapper div.activity-dashboard-content div.requests div.modal.fade.payment-info-modal.show:nth-child(5) div.modal-dialog div.modal-content div.modal-footer > button.btn.btn-orange")).click();
	}
	//RequestCall
	@Test(priority = 4)
	public void requestCall() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
		driver.get(prop.getProperty("URL"));
		login();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Calls ']")).click();
		Thread.sleep(2000);
		log.debug("Navigating to Calls page");
		driver.findElement(By.cssSelector("img[alt='Schedule a Call']")).click();
		//driver.findElement(By.cssSelector("img[alt='Schedule a Call']")).click();
		driver.findElement(By.cssSelector(".ui-dropdown")).click();
		Thread.sleep(2000);
		log.debug("Selecting Partner");
		driver.findElement(By.cssSelector(".ui-dropdown-filter")).sendKeys(prop.getProperty("partner"));
		driver.findElement(By.cssSelector(".dropText")).click();
		//slot1
		log.debug("Selecting slot 1");
		driver.findElement(By.cssSelector("input[name='slot1']")).click();
		WebDriverWait wait1 =new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ui-datepicker-month"))));
		String monthValue = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		String yearValue = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		System.out.println(monthValue+yearValue);
		while (!(Objects.equals(monthValue, "June") || !Objects.equals(yearValue, "2022")))
		{
			driver.findElement(By.cssSelector(".pi-chevron-right")).click();
			monthValue = driver.findElement(By.cssSelector("ui-datepicker-title")).getText();
			yearValue = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+prop.getProperty("slot1date")+"']")).click();
		Thread.sleep(2000);
		Integer slot1hr = Integer.valueOf(driver.findElement(By.cssSelector(".ui-hour-picker>span:nth-child(3)")).getText());
		Integer hr = Integer.valueOf(prop.getProperty("slot1hour"));
		while(!(slot1hr.equals(hr)))
		{
			driver.findElement(By.cssSelector(".ui-hour-picker .pi-chevron-up")).click();
			slot1hr = Integer.valueOf(driver.findElement(By.cssSelector(".ui-hour-picker>span:nth-child(3)")).getText());
		}

//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-minute-picker>a>.pi-chevron-up")));
//		String slot1min = driver.findElement(By.cssSelector(".ui-minute-picker>.ng-tns-c92-0:nth-child(3)")).getText();
//		String min = prop.getProperty("slot1minutes");
//		while(!(slot1min.equals(min)))
//		{
//			driver.findElement(By.cssSelector(".ui-minute-picker>a>.pi-chevron-up")).click();
//			slot1min = driver.findElement(By.cssSelector(".ui-minute-picker>.ng-tns-c92-0:nth-child(3)")).getText();
//		}
		Thread.sleep(3000);
		String ampm = driver.findElement(By.cssSelector(".ui-ampm-picker>span")).getText();
		String merideim = prop.getProperty("meridiem");
		while(!(ampm.equals(merideim)))
		{
			driver.findElement(By.cssSelector(".ui-ampm-picker>a>.pi-chevron-up")).click();
			ampm = driver.findElement(By.cssSelector(".ui-ampm-picker>span")).getText();
		}

		//slot2
		log.debug("Selecting slot 2");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("p-calendar[name='slot2']>span>button")).click();
		String month1Value = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		String year1Value = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		System.out.println(month1Value+year1Value);
		while (!(Objects.equals(month1Value, "July") || !Objects.equals(year1Value, "2022")))
		{
			driver.findElement(By.cssSelector(".pi-chevron-right")).click();
			month1Value = driver.findElement(By.cssSelector("ui-datepicker-title")).getText();
			year1Value = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+prop.getProperty("slot2date")+"']")).click();
		Thread.sleep(2000);
		Integer slot2hr = Integer.valueOf(driver.findElement(By.cssSelector(".ui-hour-picker>span:nth-child(3)")).getText());
		Integer hr1 = Integer.valueOf(prop.getProperty("slot2hour"));
		while(!(slot2hr.equals(hr1)))
		{
			driver.findElement(By.cssSelector(".ui-hour-picker .pi-chevron-up")).click();
			slot2hr = Integer.valueOf(driver.findElement(By.cssSelector(".ui-hour-picker>span:nth-child(3)")).getText());
		}

//		Integer slot2min = Integer.valueOf(driver.findElement(By.cssSelector(".ui-minute-picker>.ng-tns-c92-0:nth-child(3)")).getText());
//		Integer min1 = Integer.valueOf(prop.getProperty("slot2minutes"));
//		while(!(slot2min.equals(min1)))
//		{
//			driver.findElement(By.cssSelector(".ui-minute-picker>a>.pi-chevron-up")).click();
//			slot2min = Integer.valueOf(driver.findElement(By.cssSelector(".ui-minute-picker>.ng-tns-c92-0:nth-child(3)")).getText());
//		}
		Thread.sleep(2000);
		String ampm2 = driver.findElement(By.cssSelector(".ui-ampm-picker>span")).getText();
		String merideim1 = prop.getProperty("meridiem1");
		while(!(ampm2.equals(merideim1)))
		{
			driver.findElement(By.cssSelector(".ui-ampm-picker>a>.pi-chevron-up")).click();
			ampm2 = driver.findElement(By.cssSelector(".ui-ampm-picker>span")).getText();
		}
		//slot3
		log.debug("Selecting slot 3");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("p-calendar[name='slot3']>span>button")).click();
		String month2Value = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		String year2Value = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		System.out.println(month2Value+year2Value);
		while (!(Objects.equals(month2Value, "July") || !Objects.equals(year2Value, "2022")))
		{
			driver.findElement(By.cssSelector(".pi-chevron-right")).click();
			month2Value = driver.findElement(By.cssSelector("ui-datepicker-title")).getText();
			year2Value = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+prop.getProperty("slot3date")+"']")).click();
		Thread.sleep(2000);
		Integer slot3hr = Integer.valueOf(driver.findElement(By.cssSelector(".ui-hour-picker>span:nth-child(3)")).getText());
		Integer hr2 = Integer.valueOf(prop.getProperty("slot3hour"));
		while(!(slot3hr.equals(hr2)))
		{
			driver.findElement(By.cssSelector(".ui-hour-picker .pi-chevron-up")).click();
			slot3hr = Integer.valueOf(driver.findElement(By.cssSelector(".ui-hour-picker>span:nth-child(3)")).getText());
		}

//		Integer slot2min = Integer.valueOf(driver.findElement(By.cssSelector(".ui-minute-picker>.ng-tns-c92-0:nth-child(3)")).getText());
//		Integer min1 = Integer.valueOf(prop.getProperty("slot2minutes"));
//		while(!(slot2min.equals(min1)))
//		{
//			driver.findElement(By.cssSelector(".ui-minute-picker>a>.pi-chevron-up")).click();
//			slot2min = Integer.valueOf(driver.findElement(By.cssSelector(".ui-minute-picker>.ng-tns-c92-0:nth-child(3)")).getText());
//		}
		Thread.sleep(3000);
		String ampm3 = driver.findElement(By.cssSelector(".ui-ampm-picker>span")).getText();
		String merideim2 = prop.getProperty("meridiem2");
		while(!(ampm3.equals(merideim2)))
		{
			driver.findElement(By.cssSelector(".ui-ampm-picker>a>.pi-chevron-up")).click();
			ampm3 = driver.findElement(By.cssSelector(".ui-ampm-picker>span")).getText();
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn-save")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#areYouSure")));
		driver.findElement(By.cssSelector("#areYouSure .btn-send")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#successModal .modal-header")));
		driver.findElement(By.cssSelector("#successModal .btns")).click();

	}

	//@Test(priority=5)
	public void workStream_submission() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.get(prop.getProperty("partnerurl"));
		partnerLogin(driver);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[routerlink='/user/my-dashboard/workstreams']")).click();
		Thread.sleep(3000);
		List<WebElement> projects =driver.findElements(By.cssSelector(".workstream-activity>.ws-header>div>div>h2"));
		for (int n =0 ;n<projects.size();n++)
		{
			String project = projects.get(n).getText();
			if(project.equals(prop.getProperty("client")))
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

	//@Test(priority=6)
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
			if(workstream.contains(prop.getProperty("partner_fullname")))
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
	
	//@Test
	public void Rejecting_workstreams() throws InterruptedException 
	{
		driver.get(prop.getProperty("URL"));
		driver.navigate().refresh();
		login();
		driver.findElement(By.xpath("//img[@alt='Workstreams']/following-sibling::a")).click();
		Thread.sleep(3000);
		List<WebElement> workstreams =driver.findElements(By.cssSelector(".workstream-activity>.header-w>div>div>h2"));
		for (int m =0 ;m<workstreams.size();m++)
		{
			String workstream = workstreams.get(m).getText();
			if(workstream.contains(prop.getProperty("partner_fullname")))
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
		for(int n=0;n<7;n++)
		{
			String day= days.get(n).getText();
			if(day.equals(prop.getProperty("day")))
			{
				driver.findElements(By.cssSelector("div>div[class='date']>h5:nth-child(2)")).get(n).click();
			}
		}
		JavascriptExecutor jsw =  (JavascriptExecutor) driver;
		jsw.executeScript("window.scrollBy(0,280)", "");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='number']")).sendKeys(prop.getProperty("rejecting_workstream_hrs"));
		driver.findElement(By.cssSelector("textarea[placeholder='Type your notes here...']")).sendKeys(prop.getProperty("Rejection_description"));
		driver.findElement(By.cssSelector(".btn-reject")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#rejectHoursWarning button[class='btn btn-orange']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#viewWorksheet button[class='btn btn-close']")).click();
	}
	@AfterMethod
	public void exit() throws InterruptedException
	{	
		driver.close();
	}
}
