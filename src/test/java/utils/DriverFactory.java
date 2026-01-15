package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        // Check for environment variables (for Docker overrides) or fallback to config
        if (System.getenv("BROWSER") != null) {
            browser = System.getenv("BROWSER").toLowerCase();
        }
        
        boolean headless = ConfigReader.getBoolean("headless");
        String executor = ConfigReader.getProperty("executor");
        // Check for environment override
        if (System.getenv("EXECUTOR") != null) {
            executor = System.getenv("EXECUTOR");
        }

        WebDriver driver;

        if ("grid".equalsIgnoreCase(executor)) {
             try {
                String gridUrl = ConfigReader.getProperty("grid_url");
                if (System.getenv("GRID_URL") != null) {
                    gridUrl = System.getenv("GRID_URL");
                }
                
                if (browser.equals("chrome")) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                } else if (browser.equals("firefox")) {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                     driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                } else {
                    throw new RuntimeException("Grid Browser not supported: " + browser);
                }
             } catch (MalformedURLException e) {
                 throw new RuntimeException("Invalid Grid URL: " + e.getMessage());
             }
        } else {
            // Local Execution
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless) {
                        chromeOptions.addArguments("--headless=new");
                    }
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) {
                        firefoxOptions.addArguments("--headless");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
}
