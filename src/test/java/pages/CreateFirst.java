package pages;

import base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by user on 27.09.2017.
 */
public class CreateFirst {
    private BaseUtil base;

    public CreateFirst(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    @FindBy(how = How.XPATH, using = "//input[@name='orgName']")
    private WebElement orgName;

    public String getOrgName(){
        return orgName.getAttribute("value");
    }
    public void checkDisabled(){
        Assert.assertFalse("Поле должно быть закрыто для редактирования", orgName.isEnabled());
    }

    @FindBy(how= How.XPATH,using = "//select[@name='assetFunctionalType']" )
    private WebElement selection;

    public void assetTypeSelection(String str){
        Select assetsel = new Select(selection);
        assetsel.selectByVisibleText(str);
    }
    @FindBy(how=How.XPATH, using ="//*[contains(text(), 'Далее')]")
    private WebElement continueButton;

    public void goNext(){
        continueButton.click();
    }


}
