package stepDefinition;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.ru.*;
import pages.CreateFirst;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static stepDefinition.BeforeAfter.*;


public class TestScenario extends BaseUtil {

    private BaseUtil base;

    public TestScenario(BaseUtil base) {
        this.base = base;
    }

    @Дано("^открыть сайт$")
    public void открыть_сайт() throws Throwable {
        base.driver.navigate().to("http://95.128.177.26:8081/sua");
    }

    @Дано("^войти на сайт с валидными данными$")
    public void войти_на_сайт_с_валидными_данными() throws Throwable {
        pageL.loginAndPassInput();
        pageL.loginButtonClick();
    }

    @Дано("^выбрать финансовую организацию \"([^\"]*)\"$")
    public void выбрать_финансовую_организацию(String str1) throws Throwable {
        pageF.selectFinOrg(str1);
    }

    @Дано("^выбрать в меню Сбор и ведение данных пункт меню Список активов$")
    public void выбрать_пункт_меню_настроек_Сбор_и_ведение_данных() throws Throwable {
        pageA.getAssetsPage();
    }
    @Дано("^проверить наличие формы списка активов$")
    public void проверить_наличие_формы_списка_активов() throws Throwable {
        pageA.isAssetsPresent();
    }

    @Когда("^нажать на кнопку Создать$")
    public void нажать_на_кнопку_Создать() throws Throwable {
        pageA.createAsset();
    }

    @Когда("^проверить появление заблокированного списка Наименований ФО с именем организации и списка типов активов$")
    public void проверить_появление_заблокированного_списка_Наименований_ФО_с_именем_организации_и_списка_типов_активов() throws Throwable {
        pageC1.checkDisabled();
        //assertEquals(pageC1.getOrgName(),);

    }
    @Когда("^выбрать функциональный тип активов \"([^\"]*)\" и нажать кнопку Далее$$")
    public void выбрать_функциональный_тип_активов_и_нажать_кнопку_Далее(String arg1) throws Throwable {
        pageC1.assetTypeSelection(arg1);
        pageC1.goNext();
    }

    @Когда("^проверить отображение закладок формы Создание актива$")
     public void проверить_отображение_закладок(DataTable table) throws Throwable {
        List<String> navigationItems = table.asList(String.class);
        for (String str1: navigationItems) {
            assertTrue( pageC2.getNavigationElementLabels().contains(str1) );
        }
    }

    @Когда("^ввести валидные данные: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void ввести_валидные_данные(String str1, String str2, String str3, String str4) throws Throwable {
        pageC2.accountNumInput(str1);
        pageC2.inputInitBal(str2);
        pageC2.inputInitUSDBal(str3);
        pageC2.inputAssetName(str4);
    }
    @Когда("^проверить автозаполнение текущей стоимости значениями \"([^\"]*)\", \"([^\"]*)\"$")
    public void проверить_автозаполнение_текущей_стоимости_значениями(String str1, String str2) throws Throwable {
        assertEquals(pageC2.autoFill(),str1);
        assertEquals(pageC2.autoFillUSD(),str2);
    }
    @Когда("^проверить автозаполнение \"([^\"]*)\"$")
    public void проверить_автозаполнение(String str1) throws Throwable {
        assertEquals(pageC2.autoFillCurrency(),str1);
    }

    @Когда("^ввести данные об основных средствах \"([^\"]*)\"$")
    public void ввести_валидные_данные(String str1) throws Throwable {
        pageC2.inputObjectName(str1);
    }

    @Когда("^нажать на вкладку Приём$")
    public void нажать_на_вкладку_Приём() throws Throwable {
        pageC2.receiveStep();
    }
    @Когда("^ввести даты: \"([^\"]*)\" и \"([^\"]*)\"$")
    public void ввести_даты_и(String str1, String str2) throws Throwable {
        pageC2.inputStartDate(str1);
        pageC2.inputEndDate(str2);
    }

    @Когда("^нажать кнопку Сохранить$")
    public void нажать_кнопку_Сохранить() throws Throwable {
        pageC2.saveAsset();
    }

    @Тогда("^проверить появление нового актива с введенным \"([^\"]*)\"$")
    public void проверить_появление_нового_актива_с_введенным(String str1) throws Throwable {
            assertTrue( pageA.getAccountNumbers().contains(str1) );
        }
    }

