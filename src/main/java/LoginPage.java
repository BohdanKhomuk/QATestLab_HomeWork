import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By singInButton = By.xpath("//button[@tabindex = '4']");
    private By heading = By.id( "shop_name" );
    private By error = By.xpath( "//div[@id = 'error']/p" );
    private By errorPass = By.xpath( "//span[@for = 'passwd']" );
    private By errorEmail = By.xpath( "//span[@for = 'email']" );

    public LoginPage typeUserEmail(String username){
        driver.findElement( emailField).sendKeys( username );
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement( passwordField).sendKeys( password );
        return this;
    }

    public LoginPage clickSingUpButton(){
        driver.findElement( singInButton).click();
        return new LoginPage( driver );
    }

    public MainPage correctRegister(String useremail, String password){
        this.typeUserEmail( useremail );
        this.typePassword( password );
        this.clickSingUpButton();
        return new MainPage( driver );
    }

    public LoginPage waringRegister(String useremail, String password){
        this.typeUserEmail( useremail );
        this.typePassword( password );
        this.clickSingUpButton();
        return new LoginPage( driver );
    }

    public String getHeadingText(){
        return  driver.findElement( heading).getText();
    }

    public String getErrorText(){
        return driver.findElement( error).getText();
    }

    public String getErrorEmail(){
        return driver.findElement( errorEmail ).getText();
    }

    public String getErrorPassword(){
        return driver.findElement( errorPass ).getText();
    }

}