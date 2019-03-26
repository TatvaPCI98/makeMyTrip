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
	String pnr;

	public void EnterPNR(WebDriver driver) 
	{
		pageObj = PageFactory.initElements(driver, TrainPNRPageObj.class);
		try 
		{
			
			pnr= String.valueOf(randInt());
			waifForElementPresent(pageObj.lnkTrain, 10);
			// UI gets changed every time that's why call direct URL
			// driver.get("https://www.makemytrip.com/railways/PNR/");
			pageObj.lnkTrain.click();
			waifForElementPresent(pageObj.btnPNRCheckStatus, 10);
			pageObj.btnPNRCheckStatus.click();
			waifForElementPresent(pageObj.txtPNR, 10);
			pageObj.txtPNR.clear();
			pageObj.txtPNR.sendKeys(pnr+"0");
			waifForElementPresent(pageObj.btnChkStatus, 10);
			pageObj.btnChkStatus.click();
			waifForElementPresent(pageObj.lblvrfyPNR, 20);
			pageObj.lblvrfyPNR.getText();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Verify Train PNR
	public boolean verifyPNR() {

		/*pageObj.lblvrfyPNR.getText();
		pageObj.lblpnrNumber.getText();
		pageObj.lblPNRStatus.getText();
*/
		if (pageObj.lblpnrNumber.getText().contains(pnr) && pageObj.lblPNRStatus.getText().equals("This PNR is either not generated or flushed"))
			return true;
		else
			return false;
	}

}
