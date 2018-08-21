import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        String browser = new File( MainPage.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        driver = new ChromeDriver(  );
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    }

    @Test
    public void errorEmail(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        LoginPage newLoginPage = loginPage.waringRegister("ерор_собачка_ерор", "test123");
        String error = newLoginPage.getErrorEmail();
        Assert.assertEquals( "Пожалуйста, введите корректный адрес электронной почты.", error );
    }

    @Test
    public void emptyPassword(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        LoginPage newLoginPage = loginPage.waringRegister("test@gmail.com", " ");
        String error = newLoginPage.getErrorPassword();
        Assert.assertEquals( "Это поле необходимо заполнить.", error );
    }

    @Test
    public void emptyEmailAndPassword(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        LoginPage newLoginPage = loginPage.waringRegister(" ", " ");
        String errorEmail = newLoginPage.getErrorEmail();
        String errorPassword = newLoginPage.getErrorPassword();
        Assert.assertEquals( "Это поле необходимо заполнить.", errorEmail );
        Assert.assertEquals( "Это поле необходимо заполнить.", errorPassword );
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        LoginPage newLoginPage = loginPage.waringRegister("test@gmail.com", "test123");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals( "Обнаружена одна ошибка.", error );
    }

    @Test
    public void correctExit(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        MainPage mainPage = loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
        LoginPage loginPage1 = mainPage.exitInLoginPage();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals( "prestashop-automation", heading );
    }

    @Test
    public void enterAccTest(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        MainPage mainPage = loginPage.correctRegister( "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" );
        String heading = mainPage.getMainText();
        Assert.assertEquals( "prestashop-automation", heading );
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
