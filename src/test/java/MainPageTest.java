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
        mainPage.clickDashboardItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Пульт", correctTextInItem );
    }

    @Test
    public void testForOrdersItem(){
        mainPage.clickOrdersItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Заказы", correctTextInItem );
    }

    @Test
    public void testForCatalogItem(){
        mainPage.clickCatalogItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionElseHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "товары", correctTextInItem );
    }

    @Test
    public void testForClientsItem(){
        mainPage.clickClientsItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Управление клиентами", correctTextInItem );
    }

    @Test
    public void testForSupportServiceItem(){
        mainPage.clickSupportServiceItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Customer Service", correctTextInItem );
    }

    @Test
    public void testForStatisticsItem(){
        mainPage.clickStatisticsItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Статистика", correctTextInItem );
    }

    @Test
    public void testForModulesItem(){
        mainPage.clickModulesItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionElseHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Выбор модуля", correctTextInItem );
    }

    @Test
    public void testForDesignItem(){
        mainPage.clickDesignItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Шаблоны > Шаблон", correctTextInItem );
    }

    @Test
    public void testForDeliveryItem(){
        mainPage.clickDeliveryItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Перевозчики", correctTextInItem );
    }

    @Test
    public void testForPaymentMethodsItem(){
        mainPage.clickPaymentMethodsItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Payment Methods", correctTextInItem );
    }

    @Test
    public void testForInternationalItem(){
        mainPage.clickInternationalItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Локализация", correctTextInItem );
    }

    @Test
    public void testForShopParametersItem(){
        mainPage.clickShopParametersItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "General", correctTextInItem );
    }

    @Test
    public void testForConfigurationItem(){
        mainPage.clickConfigurationItem();
        eventDriver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Information", correctTextInItem );
    }

    @After
    public void tearDown(){
        eventDriver.quit();
    }

}
