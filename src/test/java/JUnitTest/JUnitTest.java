package JUnitTest;

import static org.junit.Assert.*;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.test.Constants;

public class JUnitTest {
	
	ChromeDriver driver;
	Action action; 
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
		driver.get(Constants.url);
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void createNewItem() throws Exception {
		JenkinsJUnit jenkins = PageFactory.initElements(driver, JenkinsJUnit.class);
		jenkins.login();
		assertTrue(jenkins.createItem());
		System.out.println(driver.getCurrentUrl());
	}


}
