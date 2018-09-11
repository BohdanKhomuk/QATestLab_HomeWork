import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogItemCategories {

    public WebDriver driver;



    public CatalogItemCategories(WebDriver driver){
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

    public CatalogItemCategories clickOnButtonAddCategory(){
        driver.findElement( buttonAddCategory).click();
        return new CatalogItemCategories( driver ) ;
    }

    public CatalogItemCategories categoryName(String username){
        driver.findElement( name).sendKeys( username );
        return this;
    }

    public CatalogItemCategories clickButtonSave(){
        driver.findElement( buttonSave ).click();
        return new CatalogItemCategories( driver );
    }

    public CatalogItemCategories addNewCategory(String username){
        this.clickOnButtonAddCategory();
        this.categoryName( username );
        this.clickButtonSave();
        return new CatalogItemCategories( driver );
    }

    public CatalogItemCategories catalogFilterName(String username){
        driver.findElement( categoryFilter_name).sendKeys( username );
        return this;
    }

    public CatalogItemCategories clickButtonSearch(){
        driver.findElement( submitFilter ).click();
        return new CatalogItemCategories( driver );
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

    public CatalogItemCategories searchCategoryName(String username){
        this.catalogFilterName(username);
        this.clickButtonSearch();
        return new CatalogItemCategories( driver );
    }
}
