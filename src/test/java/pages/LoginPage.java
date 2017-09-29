package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by user on 27.09.2017.
 */
public class LoginPage {
    private BaseUtil base;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    @FindBy(how = How.ID, using = "username")
    private WebElement usernameField;
    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using ="//*[contains(text(), 'Войти')]")
    private WebElement loginButton;

    public void loginAndPassInput(){
        usernameField.sendKeys("sua_all");
        passwordField.sendKeys("Q1w2e3r4");
    }
    public void loginButtonClick(){
        loginButton.click();
    }


}
