package CucumberTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.test.Constants;

public class Jenkins {
	
	@FindBy(xpath = Constants.peopleLink)
	WebElement peopleLink;
	
	public void username() {
		peopleLink.click();
	}

}
