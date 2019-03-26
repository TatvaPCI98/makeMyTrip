package functions;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ObjectsRepository.TrainPNRPageObj;
import Utilities.Utility;


public class TrainPNR extends Utility 
{
	private TrainPNRPageObj pageObj;
	public List<WebElement> listSearch;
	
	 
	public void EnterPNR(WebDriver driver)
	{
		pageObj = PageFactory.initElements(driver, TrainPNRPageObj.class);
		try
		{
			//driver.get("https://www.makemytrip.com/railways/PNR/");
			waifForElementPresent(pageObj.lnkTrain,10);
		pageObj.lnkTrain.click();
		pageObj.btnPNRCheckStatus.click();
		pageObj.txtPNR.clear();
		pageObj.txtPNR.sendKeys("1234567890");
		pageObj.btnChkStatus.click();
		
		pageObj.lblvrfyPNR.getText();
		
		
		//UI gets changed every time that's why call direct URL
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Verify User Login Successfully
	public boolean verifyPNR()
	{
		
		pageObj.lblvrfyPNR.getText();
		pageObj.lblpnrNumber.getText();
		pageObj.lblPNRStatus.getText();
		
		if (pageObj.lblPNRStatus.getText().equals("This PNR is either not generated or flushed"))
			return true;
		else
			return false;
	}

}
