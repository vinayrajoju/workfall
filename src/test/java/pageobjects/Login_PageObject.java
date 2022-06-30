package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_PageObject {

	public WebDriver driver;
	
	By email =By.cssSelector("input[name='email-address']");
	By password = By.cssSelector("input[type='password']");
	By frame = By.cssSelector("iframe[title='chat widget']");
	By hubspot = By.cssSelector("use[fill-rule='evenodd']");
	By footer = By.cssSelector("i[class='fa fa-times']");
	By LoginButton = By.cssSelector("button[type='submit']");
	
	public Login_PageObject (WebDriver driver) {
		this.driver=driver;
		driver.manage().window().maximize();
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement gethubspot() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(frame));
		return driver.findElement(hubspot);
	}
	public WebElement getFooter()
	{
		return driver.findElement(footer);
	}
	public WebElement getloginbutton()
	{
		driver.switchTo().parentFrame();
		return driver.findElement(LoginButton);
	}
	
}
