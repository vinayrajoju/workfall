package workfall.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class App 
{
	public static WebDriver driver;
	public static Properties prop;

	private Logger log = LogManager.getLogger(App.class.getName());
   
    	public WebDriver Initialize() throws IOException {
    		
    		prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/workfall/Config/data.properties");
    		prop.load(fs);
    		String browserName = prop.getProperty("browser");
    		if(browserName.equalsIgnoreCase("edge"))
    		{
    		System.setProperty("webdriver.edge.driver","/home/thrymr/Desktop/Hegde Automation/edgedriver_linux64 (1)/msedgedriver");
    		driver = new EdgeDriver();
    		}
    		else if(browserName.equalsIgnoreCase("chrome"))
    		{
				WebDriverManager.chromedriver().setup();
    		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
    		//System.setProperty("webdriver.chrome.driver","F:\\Lotus\\chromedriver.exe");
    		driver = new ChromeDriver();
			log.debug("chrome browser is initializing");
    		}
    		else if(browserName.equalsIgnoreCase("firefox"))
    		{
				WebDriverManager.firefoxdriver().setup();
    		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\MAHESH\\OneDrive\\Desktop\\Automation\\geckodriver.exe");
    		driver = new FirefoxDriver();
    		}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		return driver;
			
}	

    		public WebDriver initializeIncognito() throws IOException {
    			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
    			ChromeOptions options=new ChromeOptions();
    			options.addArguments("--incognito");
    			DesiredCapabilities cap = new DesiredCapabilities();
    			cap.setCapability(ChromeOptions.CAPABILITY, cap );
    			options.merge(cap);
    			driver = new ChromeDriver(options);
    			driver.get(prop.getProperty("partnerurl"));
    			return driver;
    		}

	public String getDate(){
		LocalTime time = LocalTime.now();
		String hh_mm_ss_ms = String.valueOf(time);
		String[] hh_mm_ss = hh_mm_ss_ms.split(":");
		String hh = hh_mm_ss[0];
		String mm = hh_mm_ss[1];
		String hh_mm = hh+":"+mm;
		System.out.println(hh+":"+mm);

		return hh_mm;
	}
    	
}