package Demo.UIAutomation.Tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Demo.UIAutomation.Utils.BasePage;
import Demo.UIAutomation.Utils.BaseTest;
import PageObjects.BlazeDemoLandingPage;
import PageObjects.ConfirmationPage;
import PageObjects.PurchasePage;

/**
 * @author Sukumar
 *
 */

public class BlazeDemoTests {

	SoftAssert softAssert = new SoftAssert();
	public BlazeDemoLandingPage blazeDemoLandingPage;
	public PurchasePage purchasePage;
	public ConfirmationPage confirmationPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		BaseTest.setDriver();
		blazeDemoLandingPage = new BlazeDemoLandingPage(BaseTest.getDriver());
		purchasePage = new PurchasePage(BaseTest.getDriver());
		confirmationPage = new ConfirmationPage(BaseTest.getDriver());
		System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : "
				+ BaseTest.getDriver());
	}

	@Test
	public void verifyBookingConfirmation(Method m) throws InterruptedException {
		softAssert.assertEquals(blazeDemoLandingPage.getText(BaseTest.getProperties().getProperty("landingPageHeader")),
				BaseTest.getProperties().getProperty("landingPageHeaderText"));
		blazeDemoLandingPage.selectValueFromDrpDown(BaseTest.getProperties().getProperty("chooseDepartureCityDrpDown"),
				BaseTest.getProperties().getProperty("departureCity"));
		blazeDemoLandingPage.selectValueFromDrpDown(
				BaseTest.getProperties().getProperty("chooseDestinationCityDrpDown"),
				BaseTest.getProperties().getProperty("destinationCity"));
		blazeDemoLandingPage.clickBtn(BaseTest.getProperties().getProperty("findFlightsBtn"));
		softAssert.assertTrue(blazeDemoLandingPage.isDisplayed(BaseTest.getProperties().getProperty("reservePageText")
				.replace("{0}", BaseTest.getProperties().getProperty("departureCity"))
				.replace("{1}", BaseTest.getProperties().getProperty("destinationCity"))));
		blazeDemoLandingPage.clickBtn(BaseTest.getProperties().getProperty("chooseThisFlightBtn"));
		softAssert.assertTrue(
				blazeDemoLandingPage.isDisplayed(BaseTest.getProperties().getProperty("purchasePageHeaderText")));
		purchasePage.enterText(BaseTest.getProperties().getProperty("nameInput"),
				BaseTest.getProperties().getProperty("name"));
		purchasePage.enterText(BaseTest.getProperties().getProperty("addressInput"),
				BaseTest.getProperties().getProperty("address"));
		purchasePage.enterText(BaseTest.getProperties().getProperty("cityInput"),
				BaseTest.getProperties().getProperty("address"));
		purchasePage.enterText(BaseTest.getProperties().getProperty("stateInput"),
				BaseTest.getProperties().getProperty("state"));
		purchasePage.enterText(BaseTest.getProperties().getProperty("zipcodeInput"),
				BaseTest.getProperties().getProperty("zipCode"));
		blazeDemoLandingPage.selectValueFromDrpDown(BaseTest.getProperties().getProperty("cardTypeDrpDown"),
				BaseTest.getProperties().getProperty("cardType"));
		purchasePage.enterText(BaseTest.getProperties().getProperty("creditCardNumber"),
				BaseTest.getProperties().getProperty("cardNum"));
		purchasePage.enterText(BaseTest.getProperties().getProperty("creditCardMonth"),
				BaseTest.getProperties().getProperty("cardMonth"));
		purchasePage.enterText(BaseTest.getProperties().getProperty("creditCardYear"),
				BaseTest.getProperties().getProperty("cardYear"));
		purchasePage.enterText(BaseTest.getProperties().getProperty("nameOnCreditCard"),
				BaseTest.getProperties().getProperty("name"));
		blazeDemoLandingPage.clickBtn(BaseTest.getProperties().getProperty("purchaseFlightsBtn"));
		softAssert.assertTrue(
				blazeDemoLandingPage.isDisplayed(BaseTest.getProperties().getProperty("confirmationHeaderText")),
				"Element text is null");
		softAssert.assertTrue(
				confirmationPage.verifyTableDataNotNull(BaseTest.getProperties().getProperty("confirmationTableData")),
				"Element text is null");
		softAssert.assertAll();
	}

	@AfterClass
	public void tearDown() {
		System.out.println("Browser closed by Thread " + Thread.currentThread().getId()
				+ " and Closing driver reference is :" + BaseTest.getDriver());
		BaseTest.closeBrowser();
	}
}
