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
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );

        Assert.assertEquals( "Пульт", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForOrdersItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Orders'" + (char)27 + "[0m" );
        mainPage.clickOrdersItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Заказы", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForCatalogItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Catalog'" + (char)27 + "[0m" );
        mainPage.clickCatalogItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionElseHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "товары", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForClientsItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Client'" + (char)27 + "[0m" );
        mainPage.clickClientsItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Управление клиентами", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForSupportServiceItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Support service'" + (char)27 + "[0m" );
        mainPage.clickSupportServiceItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Customer Service", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForStatisticsItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Statistic'" + (char)27 + "[0m" );
        mainPage.clickStatisticsItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Статистика", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForModulesItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Modules'" + (char)27 + "[0m" );
        mainPage.clickModulesItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionElseHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Выбор модуля", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForDesignItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Design'" + (char)27 + "[0m" );
        mainPage.clickDesignItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Шаблоны > Шаблон", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForDeliveryItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Delivery'" + (char)27 + "[0m" );
        mainPage.clickDeliveryItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Перевозчики", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForPaymentMethodsItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Payment methods'" + (char)27 + "[0m" );
        mainPage.clickPaymentMethodsItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Payment Methods", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForInternationalItem(){
        LOG.info( (char) 27 + "[34mTest for item 'International'" + (char)27 + "[0m" );
        mainPage.clickInternationalItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Локализация", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForShopParametersItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Shop parameters'" + (char)27 + "[0m" );
        mainPage.clickShopParametersItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "General", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void testForConfigurationItem(){
        LOG.info( (char) 27 + "[34mTest for item 'Configuration'" + (char)27 + "[0m" );
        mainPage.clickConfigurationItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( (char) 27 + "[33mText item: " + correctTextInItem + (char)27 + "[0m" );
        Assert.assertEquals( "Information", correctTextInItem );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @After
    public void tearDown(){
        eventDriver.quit();
    }

}
