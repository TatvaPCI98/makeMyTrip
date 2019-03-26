package ObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class TrainPNRPageObj 
{
	@FindBy(how = How.ID, using = "pnr")
	public WebElement txtPNR ;
	

	@FindBy(how = How.XPATH, using = ".//span[.='CHECK PNR STATUS']")
	public WebElement btnPNRCheckStatus ;
	
	@FindBy(how = How.XPATH, using = ".//span[.='Trains']")
	public WebElement lnkTrain ;
	
	@FindBy(how = How.XPATH, using = " .//a[.='CHECK STATUS']")
	public WebElement btnChkStatus ;
	
	
	@FindBy(how = How.ID, using = "pnrNumber")
	public WebElement lblpnrNumber ;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']//p[1]")
	public WebElement lblvrfyPNR ;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']//p[2]")
	public WebElement lblPNRStatus ;
	
}
