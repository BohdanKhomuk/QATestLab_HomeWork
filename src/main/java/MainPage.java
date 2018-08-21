import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By textFromMainPage = By.xpath( "//a[@id = 'header_shopname']" );
    private By personIcon = By.xpath( "//li[@id = 'employee_infos']" );
    private By exitBytton = By.xpath( "//a[@id = 'header_logout']" );

    public String getMainText(){
        return driver.findElement( textFromMainPage).getText();
    }

    public MainPage clickPersonIcon(){
        driver.findElement( personIcon).click();
        return new MainPage( driver ) ;
    }

    public MainPage clickExitButton(){
        driver.findElement( exitBytton).click();
        return new MainPage( driver );
    }

    public LoginPage exitInLoginPage(){
        this.clickPersonIcon();
        this.clickExitButton();
        return new LoginPage(driver);
    }

}
