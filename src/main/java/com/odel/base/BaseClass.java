package com.odel.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.odel.utilities.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void loadConfig() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/config.properties");
		prop.load(ip);
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws IOException {
		System.out.println();
		System.out.println("Setting up WebDriver for:" + this.getClass().getSimpleName());
		launchBrowser(browser);
		configureBrowser();
		staticWait(2);
	}

	private void launchBrowser(String browserName) {
//		String browserName = prop.getProperty("browser");
		boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless"));

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (isHeadless) {
                options.addArguments("--headless");
            }
			
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.addArguments("--headless");
            }
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
            if (isHeadless) {
                options.addArguments("--headless");
            }
			driver = new EdgeDriver(options);
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			throw new IllegalArgumentException("Browser Not Supported:" + browserName);
		}
	}

	private void configureBrowser() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		int pageLoadTimeout = Integer.parseInt(prop.getProperty("pageLoadTimeout"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

		int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

		try {
			driver.get(prop.getProperty("url"));
		} catch (Exception e) {
			System.out.println("Failed to Navigate to the URL:" + e.getMessage());
		}
	}

	public void staticWait(int seconds) {
		LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
	}

	@AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            TestUtil.takeScreenshotAtEndOfTest(driver); 
        }

        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Unable to quit the driver: " + e.getMessage());
            }
        }
    }
}
