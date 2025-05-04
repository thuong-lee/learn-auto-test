package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    protected WebDriver driver;

    //Khởi tạo driver
    public void setUp(){
        driver = new ChromeDriver();
    }

    //Đóng driver
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
