package com.odel.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Paths;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.odel.base.BaseClass;


public class ExtentReportListener extends BaseClass implements ITestListener{
	
	private ExtentSparkReporter reporter;
	private ExtentReports extent;
    private ExtentTest node;

    
    public void onStart(ITestContext context) {
    	
        String reportDir = Paths.get("src", "test", "resources", "ExtentReport").toAbsolutePath().toString();
        File directory = new File(reportDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
       
        reporter = new ExtentSparkReporter(reportDir + File.separator + "report.html");
    	
    	reporter.config().setDocumentTitle("Testing Report");
    	reporter.config().setReportName("Test Automation Framework");
    	
    	
    	extent = new ExtentReports();
    	extent.attachReporter(reporter);
    	
    	try {
            InetAddress localHost = InetAddress.getLocalHost();
            extent.setSystemInfo("Computer Name", localHost.getHostName()); 
            extent.setSystemInfo("IP Address", localHost.getHostAddress());
        } catch (UnknownHostException e) {
            extent.setSystemInfo("Computer Name", "Unknown");
            extent.setSystemInfo("IP Address", "Unknown");
        }

        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Architecture", System.getProperty("os.arch")); 
    }
    
    public void onTestSuccess(ITestResult result) {
    	node = extent.createTest(result.getName());
    	node.log(Status.PASS, "Test case PASSED is:" +result.getName());
    }
    
    public void onTestFailure(ITestResult result) {
    	node = extent.createTest(result.getName());
    	node.log(Status.FAIL, "Test case FAILED is:" +result.getName());
    	node.log(Status.FAIL, "Test case FAILED cause is:" +result.getThrowable());
    	
    	if (ITestResult.FAILURE == result.getStatus()) {
            try {
				TestUtil.takeScreenshotAtEndOfTest(driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    public void onTestSkipped(ITestResult result) {
    	node = extent.createTest(result.getName());
    	node.log(Status.SKIP, "Test case SKIPPED is:" +result.getName());
    }
    
    public void onFinish(ITestContext context) {
    	extent.flush();
    	
    	String reportDir = Paths.get("src", "test", "resources", "ExtentReport").toAbsolutePath().toString();
    	
    	try {
            File reportFile = new File(reportDir);
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (reportFile.exists()) {
                    desktop.browse(reportFile.toURI());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    
}
