package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegistrationFormPageObjects {
    private static final Logger logger= LogManager.getLogger(RegistrationFormPageObjects.class);
    private WebDriver driver;

    @FindBy(xpath="//form[@id='account-creation_form']//h3[text()='Your personal information']")
    private WebElement registration_page_display;

    @FindBy(xpath="//div[@class='radio-inline']")
   private List<WebElement> gender_radio_btn_list;

    @FindBy(id="customer_firstname")
    WebElement firstname_txtbtn;

    @FindBy(id="customer_lastname")
    WebElement lastname_txtbtn;

    @FindBy(id="passwd")
    WebElement password_txtbtn;

    @FindBy(xpath="//*[@id='days']")
    WebElement days_drpdwn;

    @FindBy(id="months")
    WebElement month_drpdwn;

    @FindBy(id="years")
    WebElement year_drpdwn;

    public RegistrationFormPageObjects(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void ValidateResgistrationPageIsDisplayed()
    {
        boolean b=registration_page_display.isDisplayed();
        {
            Assert.assertEquals("Registration Form page is displayed",true,b);
        }
        logger.info("Registration Form page is displayed");
    }


  public void SelectGenderTitle(String gender)
  {
      for(int i=0;i<gender_radio_btn_list.size();i++)
      {
          String gender1=gender_radio_btn_list.get(i).getText();
          if(gender1.equalsIgnoreCase(gender))
          {
              gender_radio_btn_list.get(i).click();
              logger.info("title is clicked");
              break;
          }

      }
  }

  public void EnterFirstName(String fname)
  {
      WebDriverWait wait=new WebDriverWait(driver,30);
      wait.until(ExpectedConditions.elementToBeClickable(firstname_txtbtn));
      firstname_txtbtn.sendKeys(fname);
      logger.info("First name entered");
  }
  public void EnterLastName(String lname)
  {
        //WebDriverWait wait=new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.elementToBeClickable(lastname_txtbtn));
        lastname_txtbtn.sendKeys(lname);
      logger.info("Last name entered");
  }

    public void EnterPassword(String password)
    {
        ////WebDriverWait wait=new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.elementToBeClickable(password_txtbtn));
       password_txtbtn.sendKeys(password);
        logger.info("password entered");
    }

public void SelectDateOfBirthFromDrpDwn()
{

    Select select1=new Select((days_drpdwn));
    select1.selectByValue("12");
    logger.info("user entered day as");
    Select select2=new Select((month_drpdwn));
    select2.selectByVisibleText("December");
    logger.info("user entered month as");
    Select select3=new Select((year_drpdwn));
    select3.selectByValue("1991");
    logger.info("user entered year as");
}

}
