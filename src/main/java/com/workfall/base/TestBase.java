package com.workfall.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.workfall.utils.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

	TestUtil util = new TestUtil();
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	ExtentTest test;

	private static Logger log = LogManager.getLogger(TestBase.class.getName());


	public TestBase() {

		prop = new Properties();
		FileInputStream fs;
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/workfall/config/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//FileInputStream fs = new FileInputStream("C:\\Users\\MAHESH\\OneDrive\\Desktop\\Automation\\Smoketest\\src\\test\\java\\workfall\\data.properties");
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@BeforeSuite
	public void setUp(){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Smoke Testing"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);


	}

	@AfterSuite
	public void endReport(){
		extent.flush();
	}

	public static void Initialize() throws IOException {

	String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
	//System.setProperty("webdriver.edge.driver","/home/thrymr/Desktop/Hegde Automation/edgedriver_linux64 (1)/msedgedriver");
	driver = new EdgeDriver();
	log.debug("Opening Edge browser");
	}
	else if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver","/home/thrymr/Desktop/Automation/Workfall/Drivers/chromedriver");
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\MAHESH\\OneDrive\\Desktop\\Automation\\Workfall\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	log.debug("Opening Chrome browser");
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
	//System.setProperty("webdriver.gecko.driver", "/home/thrymr/Desktop/Hegde Automation/geckodriver");
	driver = new FirefoxDriver();
	log.debug("Opening Firefox browser");
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver,20);

	}

	public void close(){
		driver.close();
	}

	public void getScreenshotPath(String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"/Reports/"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
	}
}
