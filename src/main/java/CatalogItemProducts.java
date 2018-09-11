import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CatalogItemProducts {

    public WebDriver driver;
    TimePause timePause = new TimePause();
    WritingToFile writingToFile = new WritingToFile();
    ReadingFromFile readingFromFile = new ReadingFromFile();

    String field;

    {
        try {
            field = readingFromFile.read( "UsingName.txt" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String quantity;

    {
        try {
            quantity = readingFromFile.read( "NumberQuantity.txt" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String price;

    {
        try {
            price = readingFromFile.read( "NumberPrice.txt" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CatalogItemProducts(WebDriver driver){
        this.driver = driver;
    }

    private By buttonAddProducts = By.id( "page-header-desc-configuration-add" );
    private By nameProduct = By.id( "form_step1_name_1" );
    private By quantityProduct = By.id( "form_step1_qty_0_shortcut" );
    private By priceProduct = By.id( "form_step1_price_shortcut" );
    private By checkbox = By.xpath("//form[@id='form']/div[4]/div/div");
    private By growlClose = By.className( "growl-close" );
    private By saveButton = By.xpath( "//button[@type = 'submit']/span" );
    private By getToMenu = By.linkText( "prestashop-automation" );
    private By allProduct = By.xpath( "//section/a/i[@class = 'material-icons']" );
    private By relNext = By.xpath( "//a[@rel = 'next']//i[@class ='material-icons']" );
    String nameProducts = String.format( "//a[text() = '%s']", field );
    private By searchNameProduct = By.xpath( nameProducts );
    private By usingNameProduct = By.tagName( "h1" );
    private By productQuantity = By.xpath( "//div[@class =  'product-quantities']/span" );
    private By productPrice = By.xpath( "//*[@itemprop = 'price']" );


    public CatalogItemProducts clickButtonAllProducts(){
        timePause.userDelay( 4000 );
        driver.findElement( allProduct ).click();
        return new CatalogItemProducts( driver );
    }

    public CatalogItemProducts clickButtonAddProducts(){
        driver.findElement( buttonAddProducts).click();
        return new CatalogItemProducts( driver ) ;
    }

    public CatalogItemProducts clickOnCheckbox(){
        driver.findElement( checkbox).click();
        return new CatalogItemProducts( driver ) ;
    }

    public CatalogItemProducts clickOnGrowlClose(){
        driver.findElement( growlClose).click();
        return new CatalogItemProducts( driver ) ;
    }

    public CatalogItemProducts clickSaveButton(){
        timePause.userDelay( 2000 );
        driver.findElement( saveButton).click();
        return new CatalogItemProducts( driver ) ;
    }

    public CatalogItemProducts clickOnProduct(){
        driver.findElement( searchNameProduct ).click();
        return new CatalogItemProducts( driver ) ;
    }

    public CatalogItemProducts typeNameProduct(String name){
        driver.findElement( nameProduct).sendKeys( name );
        return this;
    }

    public CatalogItemProducts typeQuantityProduct(String number){
        driver.findElement( quantityProduct).clear();
        driver.findElement( quantityProduct).sendKeys( number );
        return this;
    }

    public CatalogItemProducts typePriseProduct(String number){
        driver.findElement( priceProduct).clear();
        driver.findElement( priceProduct).sendKeys( number );
        return this;
    }

    public CatalogItemProducts addNewProducts(String nameProduct, String numberQuantity, String numberPrice){
        this.clickButtonAddProducts();
        this.typeNameProduct( nameProduct );
        writingToFile.Filewriting( "UsingName.txt", nameProduct );
        this.typeQuantityProduct( numberQuantity );
        writingToFile.Filewriting( "NumberQuantity.txt", numberQuantity );
        this.typePriseProduct( numberPrice );
        writingToFile.Filewriting( "NumberPrice.txt", numberPrice );
        this.clickOnCheckbox();
        this.clickOnGrowlClose();
        this.clickSaveButton();
        this.clickOnGrowlClose();
        return new CatalogItemProducts( driver );
    }

    public CatalogItemProducts returnHome(){
        String PortfNewKD = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        driver.findElement( getToMenu).click();
        for(String windowsHandls : driver.getWindowHandles()) {
            if(!windowsHandls.equals(PortfNewKD)){
                driver.switchTo().window(windowsHandls);
                driver.manage().window().maximize();
            }
        }
        return new CatalogItemProducts( driver ) ;
    }

    public List<String> returnListElement(){
        driver.findElement( relNext ).click();
        timePause.userDelay( 3000 );
        java.util.List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'product-description']//a[@href]"));
        (new WebDriverWait(driver, 300))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
        List<String> texts = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        return texts;
    }

    public List<String> getNameProducts(){
        timePause.userDelay( 3000 );
        java.util.List<WebElement> elements = driver.findElements(usingNameProduct);
        (new WebDriverWait(driver, 300))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
        List<String> namePro = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        return namePro;
    }

    public List<String> getQuantityProduct(){
        timePause.userDelay( 3000 );
        java.util.List<WebElement> elements = driver.findElements(productQuantity);
        (new WebDriverWait(driver, 300))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
        List<String> quantityPro = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        return quantityPro;
    }

    public List<String> getPriseProduct(){
        timePause.userDelay( 3000 );
        java.util.List<WebElement> elements = driver.findElements(productPrice);
        (new WebDriverWait(driver, 300))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
        List<String> pricePro = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        return pricePro;
    }

}
