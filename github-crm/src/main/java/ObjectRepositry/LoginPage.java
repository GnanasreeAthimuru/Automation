package ObjectRepositry;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.PropertyFileUtility;

public class LoginPage {
	 
	//Create Constructor
		WebDriver driver;
		
	public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	PropertyFileUtility putil=new PropertyFileUtility();
	
		
		@FindBy(name = "user_name")
		private WebElement usernameTF;
		
		

		public WebElement getUsernameTF() {
			return usernameTF;
		}

		
		public WebElement getPasswordTF() {
			return passwordTF;
		}

		
		public WebElement getLoginBtn() {
			return loginBtn;
		}


		@FindBy(name = "user_password")
		private WebElement passwordTF;
		
		@FindBy(id = "submitButton")
		private WebElement loginBtn;
		public void Login() throws IOException {
		String UNAME=	putil.readDataFromProperties("Username");
		String PWD=	putil.readDataFromProperties("Password");
		usernameTF.sendKeys(UNAME);
		passwordTF.sendKeys(PWD);
		loginBtn.click();
		}
	}


