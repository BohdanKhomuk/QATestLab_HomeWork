import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

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

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        String browser = new File( LoginPage.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        driver = new ChromeDriver(  );
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        MainPage mainPage = loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
    }

    @Test
    public void testForDashboardItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickDashboardItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Пульт", correctTextInItem );
    }

    @Test
    public void testForOrdersItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickOrdersItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Заказы", correctTextInItem );
    }

    @Test
    public void testForCatalogItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickCatalogItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionElseHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "товары", correctTextInItem );
    }

    @Test
    public void testForClientsItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickClientsItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Управление клиентами", correctTextInItem );
    }

    @Test
    public void testForSupportServiceItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickSupportServiceItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Customer Service", correctTextInItem );
    }

    @Test
    public void testForStatisticsItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickStatisticsItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Статистика", correctTextInItem );
    }

    @Test
    public void testForModulesItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickModulesItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionElseHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Выбор модуля", correctTextInItem );
    }

    @Test
    public void testForDesignItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickDesignItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Шаблоны > Шаблон", correctTextInItem );
    }

    @Test
    public void testForDeliveryItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickDeliveryItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Перевозчики", correctTextInItem );
    }

    @Test
    public void testForPaymentMethodsItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickPaymentMethodsItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Payment Methods", correctTextInItem );
    }

    @Test
    public void testForInternationalItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickInternationalItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Локализация", correctTextInItem );
    }

    @Test
    public void testForShopParametersItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickShopParametersItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "General", correctTextInItem );
    }

    @Test
    public void testForConfigurationItem(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        MainPage newMainPage = mainPage.clickConfigurationItem();
        driver.navigate().refresh();
        String correctTextInItem = mainPage.sectionHeaderItem();
        System.out.println( correctTextInItem );
        Assert.assertEquals( "Information", correctTextInItem );
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
