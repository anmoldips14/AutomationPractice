package stepdefs;

import core.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageobjects.CmnPageObjects;
import pageobjects.RegistrationFormPageObjects;
import pageobjects.SignInPageObjects;

public class StepDefs {
    private static final Logger logger = LogManager.getLogger(StepDefs.class);

    WebDriver driver;
    String base_url = "http://Automationpractice.com";
    int implicit_wait_timeout_in_sec = 20;
    Scenario scn;

    CmnPageObjects cmnpageobjects;
    SignInPageObjects signinpageobjects;
    RegistrationFormPageObjects registrationformpageobjects;

    @Before
    public void setUp(Scenario scn) throws Exception {
        this.scn = scn;
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        logger.info("Browser invoked.");

        cmnpageobjects=new CmnPageObjects(driver);
        signinpageobjects=new SignInPageObjects(driver);
        registrationformpageobjects=new RegistrationFormPageObjects(driver);
    }

    @After(order=2)
    public void takeScreenShot(Scenario s)
    {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }

    @After(order=1)
    public void cleanUp(){
        WebDriverFactory.quitDriver();
        scn.log("Browser Closed");
    }

    @Given("User navigates to the home application")
    public void user_navigates_to_the_home_application() {
        WebDriverFactory.navigateToTheUrl(base_url);
        scn.log("Browser navigated to URL: " + base_url);
        String expected = "My Store";
        cmnpageobjects.validatePageTitleMatch(expected);
    }

    @Given("User click on sign in button")
    public void user_click_on_sign_in_button() {
       cmnpageobjects.ClickOnSignInButton();
       scn.log("Clicked on sign in button");
    }

    @When("User enter email address {string}")
    public void user_enter_email_address(String email) {
    signinpageobjects.EnterEmailAdress(email);
    scn.log("Entered email adrees");

    }

    @When("User click on create an account")
    public void user_click_on_create_an_account() {
        signinpageobjects.ClickOnSubmitBtn();
        scn.log("Clicked on submit button");

    }

    @Then("User navigates to registration form")
    public void user_navigates_to_registration_form() {
    registrationformpageobjects.ValidateResgistrationPageIsDisplayed();
    scn.log("Navigated to registration form");
    }

    //*************personal info***************
    @When("User select the title {string}")
    public void user_select_the_title(String title) {
        registrationformpageobjects.SelectGenderTitle(title);

    }

    @When("User enter first name {string}")
    public void user_enter_first_name(String Fname) {
        registrationformpageobjects.EnterFirstName(Fname);

    }
    @When("User enter last name {string}")
    public void user_enter_last_name(String Lname) {
        registrationformpageobjects.EnterLastName(Lname);

    }
    @When("User enter password {string}")
    public void user_enter_password(String Password) {
        registrationformpageobjects.EnterPassword(Password);

    }
    @When("User selects date of birth from dropdown as day {string}, month {string} and year {string}")
    public void user_selects_date_of_birth_from_dropdown_as_day_month_and_year(String day, String month, String year)
    {
        registrationformpageobjects.SelectDateOfBirthFromDrpDwn();
    }


}
