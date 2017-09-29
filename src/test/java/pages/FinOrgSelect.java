package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

/**
 * Created by user on 27.09.2017.
 */
public class FinOrgSelect {
    private BaseUtil base;

    public FinOrgSelect(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    @FindBy(how = How.XPATH, using ="//*[contains(text(), 'ддддддддд')]")
    private WebElement FinOrg;

    @FindAll({@FindBy(how = How.XPATH, using = "//*[@aria-describedby='organizationgrid_shortName']")})
    private List<WebElement> orgNames;

    @FindBy(how = How.XPATH, using="//*[contains(text(), 'Выбрать')]")
    private WebElement FinOrgButton;

    public void selectFinOrg(String str){
        for (WebElement orgName: orgNames) {
            if (orgName.getText().equals(str)){
                orgName.click();
                FinOrgButton.click();
                break;
            }
        }

    }
}
