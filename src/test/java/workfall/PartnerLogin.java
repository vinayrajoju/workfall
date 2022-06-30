package workfall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class PartnerLogin extends Login {
	static WebDriver driver;
	
	public  void partnerLogin() throws InterruptedException {
		//driver.findElement(By.cssSelector(".modal-dialog>div>div:nth-child(2)>div>button[class*='mt-4']")).click();
		System.out.println(prop.getProperty("partneremail"));
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(prop.getProperty("partneremail"));
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(prop.getProperty("partnerpassword"));
		//driver.findElement(By.cssSelector("i[class='fa fa-times']")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(".orange-button")).click();
	}
	

}
