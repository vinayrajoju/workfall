package workfall.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Incognito
{
	WebDriver driver;
	public static Properties prope;
//	public WebDriver initializeIncognito() throws IOException {
//		prope = new Properties();
//		FileInputStream fsi = new FileInputStream("/home/thrymr/Desktop/Hegde Automation/Selenium/Smoketest/clientdata.properties");
//		prope.load(fsi);
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--incognito");
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(ChromeOptions.CAPABILITY, cap );
//		options.merge(cap);
//		driver = new ChromeDriver(options);
//		driver.get(prope.getProperty("partnerurl"));
//		return driver;
//	}
	public void getDate(){
		LocalTime time = LocalTime.now();
		System.out.println(time);
	}

}
