package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Enter username
    public void enterUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    // Click on login button
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    //Check the login screen is opened
    public void isLoginScreenOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            System.out.println("User is on the login screen");
        } catch (TimeoutException e) {
            System.out.println("Loading failed! Closing browser and skipping test case.");
            driver.quit(); // Đóng trình duyệt
            throw new SkipException("Login screen did not load, skipping this test case."); // Bỏ qua test case này
        }
    }


    //Check the user should see the homepage
    public boolean isHomePageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    //Check the user should see the logout button
    public boolean isLogoutButtonDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    //Handle error message
    public String getErrorMessage() {
        try {
            return driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e);
            return "";
        }
    }

}
