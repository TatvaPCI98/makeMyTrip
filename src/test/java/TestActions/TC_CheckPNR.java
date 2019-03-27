package TestActions;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Utility;
import functions.TrainPNR;

public class TC_CheckPNR extends Utility {

	private TrainPNR actions = new TrainPNR();
	String searchKeyword;

	//Precondition to setup browser and URL
	@Override
	public void preConditions() {
		super.preConditions();
	}


	@Test(description = "This test will Enter PNR and Verify")
	public void CheckPNR() {
		actions.EnterPNR(driver);
		Assert.assertTrue(actions.verifyPNR());
	}

	//Post condition will run after test execution
	@Override
	public void postConditions() {
		super.postConditions();
	}

}
