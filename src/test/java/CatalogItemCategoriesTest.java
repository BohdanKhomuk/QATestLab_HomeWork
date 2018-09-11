import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CatalogItemCategoriesTest {

    protected EventFiringWebDriver eventDriver;
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static CatalogItemCategories catalogItemCategories;
    private static final Logger LOG = LogManager.getLogger( EventHandler.class);


    String name = "My_test_category";

    //@DataProvider(parallel = true)

    @Parameters("browsers")

    @BeforeMethod
    protected EventFiringWebDriver getEventDriver(String browsers){
        if(browsers.equals( "chrome" )){
            String browser = new File( CatalogItemCategoriesTest.class.getResource("/chromedriver.exe").getFile()).getPath();
            System.setProperty("webdriver.chrome.driver", browser);
            eventDriver = new EventFiringWebDriver(new ChromeDriver(  ));
        }
        else if(browsers.equals("IE")){
            String browser = new File( CatalogItemCategoriesTest.class.getResource( "/IEDriverServer.exe" ).getFile()).getPath();
            System.setProperty("webdriver.ie.driver", browser);
            eventDriver = new EventFiringWebDriver( new InternetExplorerDriver(  ) );
        }
        else if(browsers.equals( "FireFox" )){
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);

            capabilities.setJavascriptEnabled( true );
            String browser = new File( CatalogItemCategoriesTest.class.getResource( "/geckodriver32.exe" ).getFile() ).getPath();
            System.setProperty( "webdriver.gecko.driver", browser );

            eventDriver = new EventFiringWebDriver( new FirefoxDriver(capabilities) );
        }

        EventHandler handler = new EventHandler();
        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        eventDriver.register( handler );

        eventDriver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        loginPage = new LoginPage( eventDriver );
        mainPage = new MainPage( eventDriver );
        catalogItemCategories = new CatalogItemCategories( eventDriver );

        loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
        mainPage.clickCatalogCategory();

        return eventDriver;
    }
    @Test
    public void emptyName(){
        LOG.info( (char) 27 + "[34mTest with empty name" + (char)27 + "[0m" );
        catalogItemCategories.addNewCategory( "" );
        String error = catalogItemCategories.getErrorText();
        Assert.assertEquals( "×\n" +
                "Ошибок: 2\n" +
                "The field name is required at least in Русский (Russian).\n" +
                "The field link_rewrite is required at least in Русский (Russian).", error );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

   @Test
    public void correctRegistrationAndSearch(){
        LOG.info( (char) 27 + "[34mTest correct registration" + (char)27 + "[0m" );
        catalogItemCategories.addNewCategory( name );
        String text = catalogItemCategories.getText();
        Assert.assertEquals( "×\n" +
                "Создано", text );
        LOG.info( (char) 27 + "[32mNew category created" + (char)27 + "[0m" );
        catalogItemCategories.searchCategoryName( name );
        String searchName = catalogItemCategories.getSearchName();
        Assert.assertEquals( name, searchName );
        LOG.info( (char) 27 + "[32mNew category found. Test passed" + (char)27 + "[0m" );
    }

    @AfterMethod
    public void tearDown(){
        eventDriver.quit();
    }

}
