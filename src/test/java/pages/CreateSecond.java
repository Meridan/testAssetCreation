package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 27.09.2017.
 */
public class CreateSecond {
    private BaseUtil base;

    public CreateSecond(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindAll({@FindBy(how = How.XPATH, using = "//*[@id='myTab']/li/a")})
    private List<WebElement> navigationElements;

    public List<String> getNavigationElementLabels() {
        return navigationElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @FindBy(how = How.XPATH, using = "//input[@name='accountNum']")
    private WebElement accountNum;

    public void accountNumInput(String str) {
        accountNum.click();
        accountNum.sendKeys(str);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='balanceInitial']")
    private WebElement initBal;

    public void inputInitBal(String str) {
        initBal.sendKeys(str);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='balanceInitialCur']")
    private WebElement initUSDBal;

    public void inputInitUSDBal(String str) {
        initUSDBal.click();
        initUSDBal.clear();
        initUSDBal.sendKeys(str);
        accountNum.click();
    }

    @FindBy(how = How.XPATH, using = "//input[@name='balanceRur']")
    private WebElement currentBal;

    public String autoFill() {
        currentBal.click();
        return currentBal.getAttribute("value");
    }

    @FindBy(how = How.XPATH, using = "//input[@name='balanceCur']")
    private WebElement currentBalUSD;

    public String autoFillUSD() {
        currentBalUSD.click();
        return currentBalUSD.getAttribute("value");
    }

    @FindBy(how = How.XPATH, using = "//select[@name='currency']")
    private WebElement selectedCurrency;

    public String autoFillCurrency() {
        Select cursel = new Select(selectedCurrency);
        return cursel.getFirstSelectedOption().getText();
        }

    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private WebElement assetName;

    public void inputAssetName(String str) {
        assetName.sendKeys(str);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='realtyObjectName']")
    private WebElement realtyObjectName;

    public void inputObjectName(String str) {
        realtyObjectName.sendKeys(str);
    }


    @FindBy(how=How.XPATH, using ="//a[contains(text(), 'Приём')]")
    private WebElement receiveButton;

    public void receiveStep() {
        receiveButton.click();
    }
    @FindBy(how = How.XPATH, using = "//input[@name='startDate']")
    private WebElement startDate;

    public void inputStartDate(String str){
        startDate.clear();
        startDate.click();
        startDate.sendKeys(str);
    }
    @FindBy(how = How.XPATH, using = "//input[@name='endDate']")
    private WebElement endDate;

    public void inputEndDate(String str){
        endDate.clear();
        endDate.click();
        endDate.sendKeys(str);
    }
    @FindBy(how=How.XPATH, using ="//div[@id='assetFormGroup']//button[contains(text(), 'Сохранить')]")
    private WebElement saveButton;
    public void saveAsset(){
        saveButton.click();
    }

}

