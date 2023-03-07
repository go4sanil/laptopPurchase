package com.laptoppurchase.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.laptoppurchase.browsers.Browsers;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;

    public void launchBrowser() {

    	switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); // open Browser in maximized mode
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			//options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			driver = new ChromeDriver(options);
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
        }
    	

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    

        driver.manage().window().maximize();
 
        // Launch a page
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

    }

    public void quitBrowser() {

        driver.quit();
    }

}
