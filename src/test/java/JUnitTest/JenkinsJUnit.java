package JUnitTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.qa.test.Constants;

public class JenkinsJUnit {
	
	@FindBy(xpath= Constants.userInput)
	private WebElement userInput;
	
	@FindBy(xpath= Constants.passwordInput)
	private WebElement passwordInput;
	
	@FindBy(xpath = Constants.signInButton)
	private WebElement signInButton;
	
	@FindBy(xpath = Constants.newItemLink)
	private WebElement newItemLink;
	
	@FindBy(xpath = Constants.newItemNameInput)
	private WebElement newItemNameInput;
	
	@FindBy(xpath = Constants.freestyleProject)
	private WebElement freestyleProject;
	
	@FindBy(xpath = Constants.okButton)
	private WebElement okButton;
	
	@FindBy(xpath = Constants.saveButton)
	private WebElement saveButton;
	
	@FindBy(xpath = Constants.dashboardLink)
	private WebElement dashboardLink;
	
	@FindBys({
		@FindBy(css = Constants.itemClass),
		@FindBy(css = Constants.nameClass)
	})
	
	private List<WebElement> list;
	
	
	public void login() {
		userInput.sendKeys(Constants.user);
		passwordInput.sendKeys(Constants.password);
		signInButton.click();
	}

	public Boolean createItem() throws Exception {
		Boolean created = false;
		newItemLink.click();
		newItemNameInput.sendKeys(Constants.newItemName);
		Thread.sleep(1000);
		freestyleProject.click();
		okButton.click();
		saveButton.click();
		dashboardLink.click();
		if(list.size()>0) {
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getText().equals(Constants.newItemName)) {
				created = true;
				}
			}
		}
		return created;
	}

}
