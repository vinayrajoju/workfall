package com.workfall.pages.partnerpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.workfall.base.TestBase.driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[routerlink='/user/my-dashboard/requests']")
    public WebElement requests;

    @FindBy(css = "a[routerlink='/user/my-dashboard/workstreams']")
    public WebElement workstreams;

    @FindBy(css = "a[routerlink='/user/my-dashboard/clients']")
    WebElement clients;

}
//driver.findElement(By.cssSelector("a[routerlink='/user/my-dashboard/requests']")).click();
//        Thread.sleep(4000);
//        List<WebElement> requests =driver.findElements(By.cssSelector(".all-request-list>.request>div:nth-child(2)>div:nth-child(2)>div>div>h3"));
//        for (int j =0 ;j<requests.size();j++)
//        {
//        String request = requests.get(j).getText();
//        if(request.equals(prop.getProperty("client")))
//        {
//        System.out.println("client"+request);
//
//        driver.findElements(By.cssSelector(".all-request-list>.request>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>button:nth-child(1)")).get(j).click();
//        break;
//        }
//        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkmark")));
//        driver.findElement(By.cssSelector(".checkmark")).click();
//        driver.findElement(By.cssSelector("div[id='acceptClientModal']>div>div>div:nth-child(2)>form>button[type='submit']")).click();
//        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
//        WebDriverWait def=new WebDriverWait(driver,150);
//        def.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[id='accpetClientSuccessModal']>div>div>div:nth-child(2)>h5")));
//        String e=driver.findElement(By.cssSelector("div[id='accpetClientSuccessModal']>div>div>div:nth-child(1)>h4")).getText();
//        String f=driver.findElement(By.cssSelector("div[id='accpetClientSuccessModal']>div>div>div:nth-child(2)>h5")).getText();
//        System.out.println(e+" "+f);
//        driver.findElement(By.cssSelector("div[id='accpetClientSuccessModal']>div>div>div:nth-child(2)>button[type='button']")).click();
//        }
