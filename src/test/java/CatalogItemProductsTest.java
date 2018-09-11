import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatalogItemProductsTest {


    TimePause timePause = new TimePause();
    protected EventFiringWebDriver eventDriver;
    private static LoginPage loginPage;
    private static MainPage mainPage;
    ReadingFromFile readingFromFile = new ReadingFromFile();
    private static CatalogItemProducts catalogItemProducts;
    private static final Logger LOG = LogManager.getLogger( EventHandler.class);
    RandomGeneration randomGeneration = new RandomGeneration();


    String name = "My_test_category";

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
        catalogItemProducts = new CatalogItemProducts( eventDriver );

        loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
        mainPage.clickCatalogProducts();

        return eventDriver;
    }

    @Test
    public void createProduct() throws FileNotFoundException {
        LOG.info( (char) 27 + "[34mTest start" + (char)27 + "[0m" );
        catalogItemProducts.addNewProducts( randomGeneration.ProductName(), RandomGeneration.intRandomNumber( 100 ), RandomGeneration.doubleRandomNumber( 100 ) );
        LOG.info( (char) 27 + "[32mSearch product" + (char)27 + "[0m" );
        catalogItemProducts.returnHome();
        catalogItemProducts.clickButtonAllProducts();
        timePause.userDelay( 3000 );
        assertThat("None of elements contains sub-string", catalogItemProducts.returnListElement() , hasItem(containsString (readingFromFile.read( "UsingName.txt"))));
        LOG.info( (char) 27 + "[32mProduct found" + (char)27 + "[0m" );
        catalogItemProducts.clickOnProduct();
        assertThat("None of elements contains sub-string", catalogItemProducts.getNameProducts() , hasItem(containsString (catalogItemProducts.field.toUpperCase())));
        assertThat("None of elements contains sub-string", catalogItemProducts.getQuantityProduct(), hasItem(containsString (catalogItemProducts.quantity)));
        assertThat("None of elements contains sub-string", catalogItemProducts.getPriseProduct() , hasItem(containsString (catalogItemProducts.price)));
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }


    @AfterMethod
    public void tearDown(){
        eventDriver.quit();
    }
}
