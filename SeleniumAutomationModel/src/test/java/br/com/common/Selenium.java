package br.com.common;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Massayohi Campos Criado em Janeiro/2020
 * @version 1.0.0
 * @since Release 1.0
 */


public class Selenium {
	
	private static WebDriver driver = null;

	/**
	 * Verifica qual o browser escolhido no arquivo de propriedades e inicializa o driver apropriado.
	 * 
	 * @return Retorna instância do WebDriver.
	 */
	
	public static WebDriver getDriver() {
		try {
		String browser = Property.BROWSER_NAME;
		if (driver == null) {
			
			if (Browser.CHROME.equals(browser)) {
				File file = new File(Property.CHROME_DRIVE_PATH);
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				ChromeOptions chromeOptions = new ChromeOptions();
					
			    chromeOptions.addExtensions(new
				File("C:\\dev\\tools\\plugins_chrome\\Chrome.crx")); DesiredCapabilities
				desiredCapabilities = new DesiredCapabilities();
				desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				driver = new ChromeDriver(desiredCapabilities);
				driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	           								
			} else if (Browser.IE.equals(browser)) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				File file = new File(Property.IE32_DRIVE_PATH);
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver(capabilities);
				driver.manage().window().maximize();
				
			} else if (Browser.FIREFOX.equals(browser)) {
				File file = new File(Property.FIREFOX_DRIVE_PATH);
				System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
				FirefoxProfile profile = new FirefoxProfile();
				profile.addExtension(new File("C:\\dev\\tools\\plugins_firefox\\doccloudextension-1.0.0.0-an+fx.xpi"));
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_XPI_PROPERTY , "true");
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette",true);
				driver= new FirefoxDriver(capabilities);
				
			} else if (Browser.EDGE.equals(browser)) {
				File file = new File(Property.EDGE_DRIVE_PATH);
				System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
				driver = new EdgeDriver();
				driver.manage().window().maximize();
										
			} else if (Browser.OPERA.equals(browser)) {
				File file = new File(Property.OPERA_DRIVE_PATH);
				System.setProperty("webdriver.opera.driver", file.getAbsolutePath());
				driver = new OperaDriver();
				driver.manage().window().maximize();	

				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return driver;
	}

}
