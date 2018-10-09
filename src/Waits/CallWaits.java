package Waits;

public class CallWaits extends AllWaitsExplanation {

	AllWaitsExplanation wait = new AllWaitsExplanation();

	public void CallWaits() {
		// https://seleniumjava.com/2016/04/05/the-beginners-guide-to-explicit-waits/

		wait.ImplicitWaits(10);

		wait.ExplicitWaitsElementToBeClickable("Call from your page locator", 10);

		wait.ExplicitWaitsAlertIsPresent(10, "accept");

		wait.ExplicitWaitsVisibilityOfElementLocatedBy("Call from your page locator", 10);

		wait.ExplicitWaitsVisibilityOfAllElementsLocatedBy(10, "Call from your page locator");

		wait.ExplicitWaitsTitleIs("Title Name", 10);

		wait.FluentWaits(10, 5, "Call from your page locator");
	}

}
