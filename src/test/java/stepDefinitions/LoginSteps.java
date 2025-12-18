package stepDefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.kavindu.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;


public class LoginSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private LoginPage login;

    @Given("user launch the application")
    public void user_launch_the_application() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user logs with invalid username {string} and {string}")
    public void user_logs_with_invalid_username_and(String username, String password) throws InterruptedException {
        login = new LoginPage(page);
        login.loginPage(username , password);
        Thread.sleep(5000);
    }


    @Then("user should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        assertTrue(page.locator(".oxd-main-menu-item").first().isVisible());
        context.close();
        page.close();
    }


    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String message) {
        login = new LoginPage(page);
        String lbl_message = login.getLoginErrorMessage();
        Assert.assertEquals(message , lbl_message);
        assertTrue(page.locator("//*[text()='Invalid credentials']").isVisible());
        context.close();
        page.close();
    }


    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) throws InterruptedException {
        login = new LoginPage(page);
        login.loginPage(username , password);
        Thread.sleep(5000);
    }
    @Then("user should verify Message {string}")
    public void user_should_verify_message(String message) {
        if (message.equalsIgnoreCase("Dashboard")){
            assertTrue(page.locator(".oxd-main-menu-item").first().isVisible());
            context.close();
            page.close();
        }else{
            assertTrue(page.locator("//*[text()='Invalid credentials']").isVisible());
            context.close();
            page.close();
        }

    }

    @When("user logs in with credentials")
    public void user_logs_in_with_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
        String username = credentials.get(0).get("userName");
        String password = credentials.get(0).get("password");
        login = new LoginPage(page);
        login.loginPage(username,password);
        Thread.sleep(5000);
    }

}
