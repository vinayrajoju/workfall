package workfall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import pageobjects.Login_PageObject;
import workfall.TestBase.App;

public class Login extends App {
	static WebDriver driver;
	private Logger log = LogManager.getLogger(Login.class.getName());
	public void login() throws InterruptedException
	{
		driver.get(prop.getProperty("URL"));
		Login_PageObject login = new Login_PageObject(driver);
		login.getEmail().sendKeys(prop.getProperty("email"));
		log.debug("email entered");
		login.getPassword().sendKeys(prop.getProperty("password"));
		log.debug("password entered");
		//login.gethubspot().click();
		//login.getFooter().click();
		login.getloginbutton().click();
		log.debug("client logged in successfully..");
		Thread.sleep(4000);	
}
		public void partnerLogin(WebDriver driver) throws InterruptedException {
			//driver.findElement(By.cssSelector(".modal-dialog>div>div:nth-child(2)>div>button[class*='mt-4']")).click();
			System.out.println(prop.getProperty("partneremail"));
			driver.findElement(By.cssSelector("input[name='email']")).sendKeys(prop.getProperty("partneremail"));
			log.debug("email entered");
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys(prop.getProperty("partnerpassword"));
			log.debug("password entered");
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='chat widget']")));
			driver.findElement(By.cssSelector("use[fill-rule='evenodd']")).click();
			driver.switchTo().parentFrame();
			//driver.findElement(By.cssSelector("i[class='fa fa-times']")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector(".orange-button")).click();
			log.debug("partner logged in successfully..");
		}
}

