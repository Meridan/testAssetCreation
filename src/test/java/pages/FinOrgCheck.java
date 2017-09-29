package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 27.09.2017.
 */
public class FinOrgCheck {
    private BaseUtil base;

    public FinOrgCheck(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindAll({@FindBy(how = How.XPATH, using = "//*[@aria-describedby='organizationFullGrid_shortName' or @ aria-describedby='organizationFullGrid_fullName']")})
    private List<WebElement> orgs;
    public List<String> getOrgs() {
        return orgs
         .stream()
          .map(WebElement::getText)
          .collect(Collectors.toList());
    }
    public String getFullOrgName (String str){
        Iterator<String> orgsIterator = getOrgs().iterator();
        String str1 = null;
        while (orgsIterator.hasNext()){
            if (orgsIterator.equals(str)){
                str1 = orgsIterator.next();
                break;
            }

        }
        return str1;

    }


}
