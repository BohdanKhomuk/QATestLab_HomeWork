import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    public WebDriver driver;
    TimePause timePause = new TimePause();

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By textFromMainPage = By.id( "header_shopname" );
    private By personIcon = By.id( "employee_infos" );
    private By exitButton = By.id( "header_logout" );
    private By dashboardItem = By.xpath( "//li[@id ='tab-AdminDashboard']//span" );
    private By ordersItem = By.xpath( "//li[@id = 'subtab-AdminParentOrders']//span" );
    private By catalogItem = By.xpath( "//li[@id ='subtab-AdminCatalog']//span" );
    private By categoryProducts = By.id( "subtab-AdminProducts" );
    private By categoryCatalog = By.id( "subtab-AdminCategories" );
    private By clientsItem = By.linkText( "Клиенты" );
    private By supportServiceItem = By.xpath( "//li[@id ='subtab-AdminParentCustomerThreads']//span" );
    private By statisticsItem = By.xpath( "//li[@id ='subtab-AdminStats']//span" );
    private By modulesItem = By.xpath( "//li[@id ='subtab-AdminParentModulesSf']//span" );
    private By designItem = By.linkText( "Design" );
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

    public CatalogItemProducts clickCatalogProducts(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement( catalogItem );
        actions.moveToElement(element).build().perform();
        driver.findElement( categoryProducts ).click();
        return new CatalogItemProducts( driver );
    }

    public CatalogItemCategories clickCatalogCategory(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement( catalogItem );
        actions.moveToElement(element).build().perform();
        driver.findElement( categoryCatalog ).click();
        return new CatalogItemCategories( driver );
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
        timePause.userDelay( 5000 );
        return driver.findElement( itemText ).getText();
    }

    public String sectionElseHeaderItem(){
        timePause.userDelay( 5000 );
        return driver.findElement( elseItemText ).getText();
    }

    public LoginPage exitInLoginPage(){
        this.clickPersonIcon();
        this.clickExitButton();
        return new LoginPage(driver);
    }

}