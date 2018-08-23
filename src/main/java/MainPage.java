import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By textFromMainPage = By.xpath( "//a[@id = 'header_shopname']" );
    private By personIcon = By.xpath( "//li[@id = 'employee_infos']" );
    private By exitButton = By.xpath( "//a[@id = 'header_logout']" );
    private By dashboardItem = By.xpath( "//li[@id ='tab-AdminDashboard']//span" );
    private By ordersItem = By.xpath( "//li[@id = 'subtab-AdminParentOrders']//span" );
    private By catalogItem = By.xpath( "//li[@id ='subtab-AdminCatalog']//span" );
    private By clientsItem = By.xpath( "//li[@id ='subtab-AdminParentCustomer']//span" );
    private By supportServiceItem = By.xpath( "//li[@id ='subtab-AdminParentCustomerThreads']//span" );
    private By statisticsItem = By.xpath( "//li[@id ='subtab-AdminStats']//span" );
    private By modulesItem = By.xpath( "//li[@id ='subtab-AdminParentModulesSf']//span" );
    private By designItem = By.xpath( "//li[@id ='subtab-AdminParentThemes']//span" );
    private By deliveryItem = By.xpath( "//li[@id ='subtab-AdminParentShipping']//span" );
    private By paymentMethodsItem = By.xpath( "//li[@id ='subtab-AdminParentPayment']//span" );
    private By internationalItem = By.xpath( "//li[@id ='subtab-AdminInternational']//span" );
    private By shopParametersItem = By.xpath( "//li[@id ='subtab-ShopParameters']//span" );
    private By configurationItem = By.xpath( "//li[@id ='subtab-AdminAdvancedParameters']//span" );
    private By itemText= By.xpath( "//h2[@class = 'page-title']" );
    private By elseItemText = By.xpath( "//h2[@class = 'title']" );


    public String getMainText(){
        return driver.findElement( textFromMainPage).getText();
    }

    public MainPage clickPersonIcon(){
        driver.findElement( personIcon).click();
        return new MainPage( driver ) ;
    }

    public MainPage clickExitButton(){
        driver.findElement( exitButton).click();
        return new MainPage( driver );
    }

    public MainPage clickDashboardItem (){
        driver.findElement( dashboardItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickOrdersItem (){
        driver.findElement( ordersItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickCatalogItem (){
        driver.findElement( catalogItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickClientsItem (){
        driver.findElement( clientsItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickSupportServiceItem (){
        driver.findElement( supportServiceItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickStatisticsItem (){
        driver.findElement( statisticsItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickModulesItem (){
        driver.findElement( modulesItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickDesignItem (){
        driver.findElement( designItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickDeliveryItem (){
        driver.findElement( deliveryItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickPaymentMethodsItem (){
        driver.findElement( paymentMethodsItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickInternationalItem (){
        driver.findElement( internationalItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickShopParametersItem (){
        driver.findElement( shopParametersItem ).click();
        return new MainPage( driver );
    }

    public MainPage clickConfigurationItem (){
        driver.findElement( configurationItem ).click();
        return new MainPage( driver );
    }

    public String sectionHeaderItem (){
        return driver.findElement( itemText ).getText();
    }

    public String sectionElseHeaderItem(){
        return driver.findElement( elseItemText ).getText();
    }

    public LoginPage exitInLoginPage(){
        this.clickPersonIcon();
        this.clickExitButton();
        return new LoginPage(driver);
    }

}