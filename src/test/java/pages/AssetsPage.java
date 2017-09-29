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
import java.util.stream.Collectors;

/**
 * Created by user on 27.09.2017.
 */
public class AssetsPage {
    private BaseUtil base;

    public AssetsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how=How.XPATH, using ="//*[contains(text(), 'Сбор и ведение данных')]")
    private WebElement MenuButton;
    @FindBy(how=How.XPATH, using ="//*[contains(text(), 'Список активов')]")
    private WebElement SelectAssetsButton;
    @FindBy(how=How.ID, using = "assetgrid")
    private WebElement AssetsGrid;
    @FindBy(how=How.XPATH, using ="//li[@id='tuningMenu']//a[@class='dropdown-toggle']")
    private WebElement SettingsButton;
    @FindBy(how=How.XPATH, using ="//*[contains(text(), 'Список активов')]")
    private WebElement ShowFinOrgButton;
    @FindBy(how=How.XPATH, using ="//*[contains(text(), 'Создать')]")
    private WebElement CreateAssetButton;

    public void getAssetsPage(){
        MenuButton.click();
        SelectAssetsButton.click();
    }
    public void isAssetsPresent(){
        try {
            AssetsGrid.isDisplayed();
        } catch (Exception e) {
            System.out.println("Таблица активов не найдена");
        }
    }
    public void showFinOrg(){
        SettingsButton.click();
        ShowFinOrgButton.click();
    }
    public void createAsset(){
        CreateAssetButton.click();
    }

    @FindAll({@FindBy(how = How.XPATH, using = "//tr/td[@aria-describedby='assetgrid_accountNum']")})
    private List<WebElement> accountNumbers;
    public List<String> getAccountNumbers() {
        return accountNumbers
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
