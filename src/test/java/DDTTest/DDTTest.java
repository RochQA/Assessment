package DDTTest;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import com.qa.test.Constants;

@RunWith(Parameterized.class)
public class DDTTest {
	
	@Parameters
	public static Collection<Object[]> data() throws IOException {
		FileInputStream file = new FileInputStream(Constants.FILELOCATION);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows()-1][6];
		
		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			ob[rowNum-1][0] = sheet.getRow(rowNum).getCell(0).getStringCellValue();
			ob[rowNum-1][1] = sheet.getRow(rowNum).getCell(1).getStringCellValue();
			ob[rowNum-1][2] = sheet.getRow(rowNum).getCell(2).getStringCellValue();
			ob[rowNum-1][3] = sheet.getRow(rowNum).getCell(3).getStringCellValue();
			ob[rowNum-1][4] = sheet.getRow(rowNum).getCell(4).getStringCellValue();
			ob[rowNum-1][5] = rowNum;
		}
		workbook.close();
		return Arrays.asList(ob);
		
		}
	
	private String username;
	private String fullname;
	private String password;
	private String confirmPass;
	private String email;
	private int rowNum;
	private WebDriver driver;
	
	public DDTTest(String username, String fullname, String password, String confirmPass, String email, int rowNum) {
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.confirmPass = confirmPass;
		this.email = email;
		this.rowNum = rowNum;
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.get(Constants.url);
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void createUsers() throws IOException {	
	AddUser addUser = PageFactory.initElements(driver, AddUser.class);
	addUser.login();
	addUser.navigate();
	addUser.addAUser(username,fullname, password, confirmPass, email);
	driver.get(Constants.url);
	FileInputStream file = new FileInputStream(Constants.FILELOCATION);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	XSSFRow row = sheet.getRow(rowNum);
	XSSFCell cell;
	cell = row.getCell(5);
	if (cell == null) {
		cell = row.createCell(5);
	}
	
	if(addUser.check(fullname)) {
		cell.setCellValue("True");
	}else {
		cell.setCellValue("False");
	}
	FileOutputStream fileOut = new FileOutputStream(Constants.FILELOCATION);

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		
		workbook.close();
		file.close();
	}
}
