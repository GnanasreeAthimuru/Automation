package ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 public WebElement getHeaderText() {
		return headerText;
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	 private WebElement headerText;
	@FindBy(id = "dtlview_Industry")
	private WebElement industryHeader;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeHeader;

	public WebElement getIndustryHeader() {
		return industryHeader;
	}

	public WebElement getTypeHeader() {
		return typeHeader;
	}
	


}
