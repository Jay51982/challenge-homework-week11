package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    // driver declaration
    public static WebDriver driver;

    //method to launch browser
    public void openBrowser(String baseUrl) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        // Declared driver intialisation
        driver = new ChromeDriver();
        // Launch the URL
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        //We give implicit time to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }
}
