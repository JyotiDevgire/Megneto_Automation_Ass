package stepdefinitions;

import com.github.javafaker.Faker;

import Pages.SignUpPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class SignupSteps {

    WebDriver driver;
    SignUpPage signUpPage;
    Faker faker = new Faker(); // Faker object for generating random data

    @Given("the user navigates to the sign-up page")
    public void the_user_navigates_to_the_sign_up_page() {
        System.out.println("Navigating to the sign-up page...");
        
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        signUpPage = new SignUpPage(driver);
    }

    @When("the user enters valid random credentials")
    public void the_user_enters_valid_random_credentials() {
        System.out.println("Entering valid random credentials...");
        
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = "Password123"; // Static password for simplicity

        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.enterConfirmPassword(password);

        System.out.println("Generated Credentials:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    @When("click on the create an account button")
    public void submits_the_sign_up_form() {
        System.out.println("creating the account...");
        signUpPage.clickCreateAnAccountButton();
    }

    @Then("the account should be created successfully")
    public void the_account_should_be_created_successfully() {
        System.out.println("Verifying account creation...");
        Assert.assertTrue(signUpPage.isAccountCreated(), "Account creation failed!");
        System.out.println("Account created successfully!");
        
        driver.quit(); // Close the browser after the test
    }
}
