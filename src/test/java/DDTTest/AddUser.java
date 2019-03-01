package DDTTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.qa.test.Constants;

public class AddUser {
	
	@FindBy(xpath= Constants.userInput)
	private WebElement userInput;	
	@FindBy(xpath= Constants.passwordInput)
	private WebElement passwordInput;	
	@FindBy(xpath = Constants.signInButton)
	private WebElement signInButton;
	
	@FindBy(xpath=Constants.createUsernameInput)
	WebElement userIn;
	@FindBy(xpath=Constants.createPassInput)
	WebElement passIn;
	@FindBy(xpath=Constants.createConfirmPassInput)
	WebElement confirmPassIn;
	@FindBy(xpath=Constants.createFullNameInput)
	WebElement fullNameIn;
	@FindBy(xpath=Constants.createEmailInput)
	WebElement emailIn;
	@FindBy(xpath=Constants.createUserButton)
	WebElement createUserButton;
	
	@FindBy(xpath=Constants.manageLink)
	WebElement manage;
	@FindBy(xpath=Constants.manageUsers)
	WebElement manageUsers;
	@FindBy(xpath=Constants.createUser)
	WebElement createUser;
	
	@FindBys({
		@FindBy(id= "people"),
		@FindBy(tagName= "tbody"),
		@FindBy(tagName= "tr"),
		@FindBy(tagName="td"),
		@FindBy(tagName="a")
	})
	private List<WebElement> list; 
	
	@FindBy(xpath = Constants.peopleLink)
	WebElement peopleLink;
	@FindBy(xpath = Constants.idSort)
	WebElement idSort;
	@FindBy(xpath = Constants.userName)
	WebElement userName;
	
	
	public void login() {
		userInput.sendKeys(Constants.user);
		passwordInput.sendKeys(Constants.password);
		signInButton.click();
	}
	public void navigate() {
		manage.click();
		manageUsers.click();
		createUser.click();	
	}
	
	public void addAUser(String username, String fullname, String password, String confirmPass, String email) {
		userIn.sendKeys(username);
		passIn.sendKeys(password);
		confirmPassIn.sendKeys(confirmPass);
		fullNameIn.sendKeys(fullname);
		emailIn.sendKeys(email);
		createUserButton.click();
	}
	public Boolean check(String fullname) {
		Boolean added = false;
		peopleLink.click();
		idSort.click();
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getText().equals(fullname)) {
					added = true;
				}
			}
		}
		return added;
	}

	

}
