package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends TestBase {

    public SettingsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".header-profile-icon")
    WebElement profile;

    @FindBy(css = "div[class='profile-info']>div>ul>li>a[routerlink='/clients/settings/about']")
    WebElement settings;

    @FindBy(css = ".payment")
    WebElement paymentmenu;

    @FindBy(css = "a[routerlink='/clients/settings/saved-cards']")
    WebElement savedcards;

    public void navigateSettings(){
        profile.click();
        settings.click();
    }
    public void navigateSavedCards(){
        paymentmenu.click();
        savedcards.click();
    }

}
