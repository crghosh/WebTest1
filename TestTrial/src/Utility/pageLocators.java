package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pageLocators {

	
	@FindBy (xpath= "//*[@type='text']")
	WebElement txt_input;
	
	public void setInput(String value) {
		txt_input.click();
		if(txt_input.isEnabled())
			txt_input.sendKeys(value);
	}
	
	@FindBy (xpath = "//button[text()='Start']")
	WebElement btn_start;
	
	public void clickStart() {
		btn_start.click();
	}
	
	@FindBy (xpath = "//p[@class='ClassicTimer-time']/span")
	WebElement txt_result;
	
	public String getResult() {
		System.out.println(txt_result.getText());
		return txt_result.getText();
		
	}
	
	@FindBy (xpath = "//button[contains(@class,'collapse')]")
	WebElement btn_collapse;
	public void clickCollapse() {
		btn_collapse.click();
	}
}
