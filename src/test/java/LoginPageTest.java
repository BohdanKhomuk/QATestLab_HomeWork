import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class LoginPageTest {

    public static EventFiringWebDriver eventDriver;
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static final Logger LOG = LogManager.getLogger( EventHandler.class);



    @Before
    public void firstClass() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        String browser = new File(LoginPageTest.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        eventDriver = new EventFiringWebDriver(new ChromeDriver(  ));

        EventHandler handler = new EventHandler();
        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        eventDriver.register( handler );
        eventDriver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        loginPage = new LoginPage( eventDriver );
        mainPage = new MainPage( eventDriver );
    }

    @Test
    public void userLoginTest() {
        LOG.info( (char) 27 + "[34mTest with incorrect email" + (char)27 + "[0m" );
        loginPage.waringRegister("ерор_собачка_ерор", "test123");
        String error = loginPage.getErrorEmail();
        Assert.assertEquals( "Пожалуйста, введите корректный адрес электронной почты.", error );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void emptyPassword(){
        LOG.info( (char) 27 + "[34mTest with empty password" + (char)27 + "[0m" );
        loginPage.waringRegister("test@gmail.com", " ");
        String error = loginPage.getErrorPassword();
        Assert.assertEquals( "Это поле необходимо заполнить.", error );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void emptyEmailAndPassword(){
        LOG.info( (char) 27 + "[34mTest with empty email and password" + (char)27 + "[0m" );
        loginPage.waringRegister(" ", " ");
        String errorEmail = loginPage.getErrorEmail();
        String errorPassword = loginPage.getErrorPassword();
        Assert.assertEquals( "Это поле необходимо заполнить.", errorEmail );
        Assert.assertEquals( "Это поле необходимо заполнить.", errorPassword );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LOG.info( (char) 27 + "[34mTesting an account that does not have an account" + (char)27 + "[0m" );
        loginPage.waringRegister("test@gmail.com", "test123");
        String error = loginPage.getErrorText();
        Assert.assertEquals( "Обнаружена одна ошибка.", error );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void correctExit(){
        LOG.info( (char) 27 + "[34mCheck the correct exit from the main page" + (char)27 + "[0m" );
        loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
        LoginPage loginPage1 = mainPage.exitInLoginPage();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals( "prestashop-automation", heading );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @Test
    public void enterAccTest(){
        LOG.info( (char) 27 + "[34mTest correct enter in main page" + (char)27 + "[0m" );
        loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
        String heading = mainPage.getMainText();
        Assert.assertEquals( "prestashop-automation", heading );
        LOG.info( (char) 27 + "[32mTest passed" + (char)27 + "[0m" );
    }

    @After
    public void tearDown() {
        eventDriver.quit();
    }
}
