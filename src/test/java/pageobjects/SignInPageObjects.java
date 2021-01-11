package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPageObjects {
    private static final Logger logger= LogManager.getLogger(CmnPageObjects.class);
    private WebDriver driver;


    @FindBy(xpath = "//input[@id='email_create']")
    WebElement email_txt_box;

    @FindBy(id="SubmitCreate")
    WebElement submit_btn;


    public SignInPageObjects(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void EnterEmailAdress(String emailid)
    {
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(email_txt_box));
        email_txt_box.sendKeys(emailid);
        logger.info("Email id entered");
    }

    public void ClickOnSubmitBtn()
    {
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(submit_btn));
        submit_btn.click();
        logger.info("clicked on submit button");
    }
}
