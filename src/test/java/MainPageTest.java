import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import test.tmp.verify.Verify;
import test.tmp.verify.VerifyTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/*Добрый день!
* На счет автотеста не было никакой конкретики, на сколько этапав надо разделить, тому сделал для каждого пункта свой тест.
* Если этот подход будет не правильным, то оповестите пожалуйста и я все переделаю, там это уже не так и сложно сделать.
* С уважением Хомук Богдан
* емаил: bohdankhomuk@gmail.com*
* Хорошего Вам дня!
* */

public class MainPageTest {

    public static EventFiringWebDriver eventDriver;
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static final Logger LOG = LogManager.getLogger( EventHandler.class);



    @Before
    public void firstClass() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        String browser = new File(MainPageTest.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        eventDriver = new EventFiringWebDriver(new ChromeDriver(  ));

        EventHandler handler = new EventHandler();
        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        eventDriver.register( handler );
        eventDriver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        loginPage = new LoginPage( eventDriver );
        mainPage = new MainPage( eventDriver );

        loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
    }

    @Test
    public void testForDashboardItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Dashboard'" + (char)27 + "[0m" );
        mainPage.clickDashboardItem();
        eventDriver.navigate().refresh();
        String correctTextInItemDashboard = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemDashboard + (char)27 + "[0m" );
        Assert.assertEquals( "Пульт", correctTextInItemDashboard );

        LOG.info( (char) 27 + "[34mTest for item 'Orders'" + (char)27 + "[0m" );
        mainPage.clickOrdersItem();
        eventDriver.navigate().refresh();
        String correctTextInItemOrders = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemOrders + (char)27 + "[0m" );
        Assert.assertEquals( "Заказы", correctTextInItemOrders );

        LOG.info( (char) 27 + "[34mTest for item 'Catalog'" + (char)27 + "[0m" );
        mainPage.clickCatalogItem();
        eventDriver.navigate().refresh();
        String correctTextInItemCatalog = mainPage.sectionElseHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemCatalog + (char)27 + "[0m" );
        Assert.assertEquals( "товары", correctTextInItemCatalog);

        LOG.info( (char) 27 + "[34mTest for item 'Client'" + (char)27 + "[0m" );
        mainPage.clickClientsItem();
        eventDriver.navigate().refresh();
        String correctTextInItemClient = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemClient + (char)27 + "[0m" );
        Assert.assertEquals( "Управление клиентами", correctTextInItemClient );

        LOG.info( (char) 27 + "[34mTest for item 'Support service'" + (char)27 + "[0m" );
        mainPage.clickSupportServiceItem();
        eventDriver.navigate().refresh();
        String correctTextInItemSupportS = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemSupportS + (char)27 + "[0m" );
        Assert.assertEquals( "Customer Service", correctTextInItemSupportS );

        LOG.info( (char) 27 + "[34mTest for item 'Statistic'" + (char)27 + "[0m" );
        mainPage.clickStatisticsItem();
        eventDriver.navigate().refresh();
        String correctTextInItemStatic = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemStatic + (char)27 + "[0m" );
        Assert.assertEquals( "Статистика", correctTextInItemStatic );

        LOG.info( (char) 27 + "[34mTest for item 'Modules'" + (char)27 + "[0m" );
        mainPage.clickModulesItem();
        eventDriver.navigate().refresh();
        String correctTextInItemModules = mainPage.sectionElseHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemModules + (char)27 + "[0m" );
        Assert.assertEquals( "Выбор модуля", correctTextInItemModules );

        LOG.info( (char) 27 + "[34mTest for item 'Design'" + (char)27 + "[0m" );
        mainPage.clickDesignItem();
        eventDriver.navigate().refresh();
        String correctTextInItemDesign = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemDesign + (char)27 + "[0m" );
        Assert.assertEquals( "Шаблоны > Шаблон", correctTextInItemDesign );

        LOG.info( (char) 27 + "[34mTest for item 'Delivery'" + (char)27 + "[0m" );
        mainPage.clickDeliveryItem();
        eventDriver.navigate().refresh();
        String correctTextInItemDelivery = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemDelivery + (char)27 + "[0m" );
        Assert.assertEquals( "Перевозчики", correctTextInItemDelivery );

        LOG.info( (char) 27 + "[34mTest for item 'Payment methods'" + (char)27 + "[0m" );
        mainPage.clickPaymentMethodsItem();
        eventDriver.navigate().refresh();
        String correctTextInItemPaymentM = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemPaymentM + (char)27 + "[0m" );
        Assert.assertEquals( "Payment Methods", correctTextInItemPaymentM );

        LOG.info( (char) 27 + "[34mTest for item 'International'" + (char)27 + "[0m" );
        mainPage.clickInternationalItem();
        eventDriver.navigate().refresh();
        String correctTextInItemInternational = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemInternational + (char)27 + "[0m" );
        Assert.assertEquals( "Локализация", correctTextInItemInternational );

        LOG.info( (char) 27 + "[34mTest for item 'Shop parameters'" + (char)27 + "[0m" );
        mainPage.clickShopParametersItem();
        eventDriver.navigate().refresh();
        String correctTextInItemShopP = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemShopP + (char)27 + "[0m" );
        Assert.assertEquals( "General", correctTextInItemShopP );

        LOG.info( (char) 27 + "[34mTest for item 'Configuration'" + (char)27 + "[0m" );
        mainPage.clickConfigurationItem();
        eventDriver.navigate().refresh();
        String correctTextInItemConfiguration = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItemConfiguration + (char)27 + "[0m" );
        Assert.assertEquals( "Information", correctTextInItemConfiguration );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @After
    public void tearDown(){
        eventDriver.quit();
    }

}
