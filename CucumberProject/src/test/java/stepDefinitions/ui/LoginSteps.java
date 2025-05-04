package stepDefinitions.ui;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;


public class LoginSteps extends BaseClass {
    LoginPage loginPage; // Khởi tạo đối tượng của trang login để gọi các method của nó
    // Khởi tạo ở class để khi gắn driver vào vẫn có thể sử dụng ở các method khác

    @Given("the user is on the login screen")
    public void userOnLoginScreen() {
        setUp();//Mở browser
        driver.get("https://www.saucedemo.com/"); //Mở trang web
        loginPage = new LoginPage(driver); // Tạo đối tượng để gọi phương thức của nó
        loginPage.isLoginScreenOpened(); //Check xem trang login mở chưa
    }

    @When("the user enters the username {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        System.out.println("Entered username: " + username);
    }

    @And("the user enters the password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        System.out.println("Entered password: " + password);
    }

    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
        System.out.println("Click on the login button");
    }

    @Then("the user should see the homepage")
    public void seeHomePage() {
        Assert.assertTrue(loginPage.isHomePageOpened(), "Homepage failed to load");
        System.out.println("Homepage is displayed");
    }

    @Then("the user should see the logout button")
    public void seeLogoutButton() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed(), "The hamburger failed to load");
        System.out.println("The logout button is displayed");
    }

    @Then("the user should see an error message {string}")
    public void seeErrorMessage(String expectedMessage) {
        Assert.assertEquals(loginPage.getErrorMessage(),expectedMessage,"Error message does not match!");
        System.out.println("User sees an error message" + expectedMessage);
    }

    // Đóng trình duyệt sau mỗi scenario
    @After
    public void closeBrowser() {
        tearDown();
    }

}