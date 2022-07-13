package com.workfall.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.workfall.base.TestBase.driver;

public class Workstreampage {

    public Workstreampage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".all-request-list>.request>div:nth-child(2)>div:nth-child(2)>div>div>h3")
    List<WebElement> clientlist;

    @FindBy(css=".all-request-list>.request>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>button:nth-child(1)")
    List<WebElement> acceptbuttons;

    @FindBy(css=".checkmark")
    WebElement checkbox;

    @FindBy(css="div[id='acceptClientModal']>div>div>div:nth-child(2)>form>button[type='submit']")
    WebElement accept;

    @FindBy(css=".workstream-activity>.ws-header>div>div>h2")
    List<WebElement> projects;

    @FindBy(css=".workstream-activity>.ws-header>div>button[class='btn btn-view-workstream']")
    List<WebElement> open;

    public void acceptRequest(String clientname) throws InterruptedException {
        List<WebElement> clients = clientlist;
        for (int o =0 ;o<clients.size();o++)
        {
            String client = clients.get(o).getText().toLowerCase();
            if(client.contains(clientname))
            {
                System.out.println(client);
                acceptbuttons.get(o).click();
                break;
            }
        }
        Thread.sleep(3000);
        checkbox.click();
        accept.click();
    }

    public void selectWorkStream(String clientname) throws InterruptedException {
        List<WebElement> projectList = projects ;
        for (int k =0 ;k<projectList.size();k++)
        {
            String project = projectList.get(k).getText().toLowerCase();
            if(project.contains(clientname))
            {
                System.out.println(project);
                open.get(k).click();
                break;
            }
        }
        Thread.sleep(3000);
    }
}
