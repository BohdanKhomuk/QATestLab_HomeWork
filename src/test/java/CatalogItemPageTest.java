import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CatalogItemPageTest {

    public static EventFiringWebDriver eventDriver;
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static CatalogItemPage catalogItemPage;
    private static final Logger LOG = LogManager.getLogger( EventHandler.class);


    String name = "Test";


    @Before
    public void firstClass() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        String browser = new File( CatalogItemPageTest.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        eventDriver = new EventFiringWebDriver(new ChromeDriver(  ));

        EventHandler handler = new EventHandler();
        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        eventDriver.register( handler );
        eventDriver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        loginPage = new LoginPage( eventDriver );
        mainPage = new MainPage( eventDriver );
        catalogItemPage = new CatalogItemPage( eventDriver );

        loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
        mainPage.clickCatalogCategory();
    }

    @Test
    public void emptyName(){
        LOG.info( (char) 27 + "[34mTest with empty name" + (char)27 + "[0m" );
        catalogItemPage.addNewCategory( "" );
        String error = catalogItemPage.getErrorText();
        Assert.assertEquals( "×\n" +
                "Ошибок: 2\n" +
                "The field name is required at least in Русский (Russian).\n" +
                "The field link_rewrite is required at least in Русский (Russian).", error );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void correctRegistrationAndSearch(){
        LOG.info( (char) 27 + "[34mTest correct registration" + (char)27 + "[0m" );
        catalogItemPage.addNewCategory( name );
        String text = catalogItemPage.getText();
        Assert.assertEquals( "×\n" +
                "Создано", text );
        LOG.info( (char) 27 + "[32mNew category created" + (char)27 + "[0m" );
        catalogItemPage.searchCategoryName( name );
        String searchName = catalogItemPage.getSearchName();
        Assert.assertEquals( name, searchName );
        LOG.info( (char) 27 + "[32mNew category found. Test passed" + (char)27 + "[0m" );
    }

    @After
    public void tearDown(){
        eventDriver.quit();
    }

}
