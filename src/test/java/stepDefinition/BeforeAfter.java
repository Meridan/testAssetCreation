package stepDefinition;

import base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import pages.*;


public class BeforeAfter extends BaseUtil {
    public static LoginPage pageL;
    public static FinOrgSelect pageF;
    public static AssetsPage pageA;
    //public static FinOrgCheck pageF1;
    public static CreateFirst pageC1;
    public static CreateSecond pageC2;



    private BaseUtil base;

    public BeforeAfter(BaseUtil base) {

        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.setProperty("webdriver.ie.driver", "C:\\Users\\user.inv5423-pc\\Desktop\\driver\\IEDriverServer.exe");
        base.driver = new InternetExplorerDriver();
        base.driver.manage().window().maximize();
        pageL = new LoginPage(base.driver);
        pageF = new FinOrgSelect(base.driver);
        pageA = new AssetsPage(base.driver);
        //pageF1 = new FinOrgCheck(base.driver);
        pageC1 = new CreateFirst(base.driver);
        pageC2 = new CreateSecond(base.driver);

    }

    @After
    public void TearDownTest() {
        base.driver.quit();
        Reporter.log("Browser closed", true);
    }

}
