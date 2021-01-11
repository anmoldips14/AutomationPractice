package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CmnPageObjects {
    private static final Logger logger= LogManager.getLogger(CmnPageObjects.class);
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement sign_in_button;




    public CmnPageObjects(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void validatePageTitleMatch(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertEquals("Title Validation",true, b);
        logger.info("Page title matched: " + expectedTitle );
    }

public void ClickOnSignInButton()
{
    WebDriverWait wait=new WebDriverWait(driver,30);
     wait.until(ExpectedConditions.elementToBeClickable(sign_in_button));
     sign_in_button.click();
     logger.info("Clicked on sign in link");
}



}
