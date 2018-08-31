import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogItemPage {

    public WebDriver driver;



    public CatalogItemPage(WebDriver driver){
        this.driver = driver;
    }

    private By buttonAddCategory = By.xpath( "//*[@id = 'page-header-desc-category-new_category']/i" );
    private By name = By.id( "name_1" );
    private By buttonSave = By.id( "category_form_submit_btn" );
    private By errorText = By.xpath( " //*[@id = 'content']/div[3]/div" );
    private By correctRegistrationText = By.xpath( "//*[@id = 'content']/div[3]/div" );
    private By categoryFilter_name = By.name("categoryFilter_name");
    private By submitFilter = By.id("submitFilterButtoncategory");
    private By pointer = By.xpath( "//*[@class = 'pointer'][1]" );

    public CatalogItemPage clickOnButtonAddCategory(){
        driver.findElement( buttonAddCategory).click();
        return new CatalogItemPage( driver ) ;
    }

    public CatalogItemPage categoryName(String username){
        driver.findElement( name).sendKeys( username );
        return this;
    }

    public CatalogItemPage clickButtonSave(){
        driver.findElement( buttonSave ).click();
        return new CatalogItemPage( driver );
    }

    public CatalogItemPage addNewCategory(String username){
        this.clickOnButtonAddCategory();
        this.categoryName( username );
        this.clickButtonSave();
        return new CatalogItemPage( driver );
    }

    public CatalogItemPage catalogFilterName(String username){
        driver.findElement( categoryFilter_name).sendKeys( username );
        return this;
    }

    public CatalogItemPage clickButtonSearch(){
        driver.findElement( submitFilter ).click();
        return new CatalogItemPage( driver );
    }

    public String getErrorText(){
        return driver.findElement( errorText).getText();
    }

    public String getText(){
        return driver.findElement( correctRegistrationText ).getText();
    }

    public String getSearchName() {
        return driver.findElement( pointer ).getText();
    }

    public CatalogItemPage searchCategoryName(String username){
        this.catalogFilterName(username);
        this.clickButtonSearch();
        return new CatalogItemPage( driver );
    }
}
