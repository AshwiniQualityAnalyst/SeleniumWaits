package Waits;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class AllWaitsExplanation 
{
	private WebDriver driver = null;

	public void ImplicitWaits(int Time)
	{
		driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);
	}

	public void ExplicitWaitsElementToBeClickable(String locator, int timeOutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement LinkText = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
		LinkText.click(); //Whatever Operation
	}

	public void ExplicitWaitsAlertIsPresent(int timeOutInSeconds, String AlertOperation)
	{
		//Perform any operation after that Alert appears---Perform Click then call below script
		// .Click();---Just example
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertGetText = driver.switchTo().alert().getText();  // Optional
		System.out.println("Alert Get Text: "+AlertGetText); // Optional

		if(AlertOperation == "accept")
		{
			driver.switchTo().alert().accept();
		}
		else if(AlertOperation == "dismiss")
		{
			driver.switchTo().alert().dismiss();
		}

	}

	public void ExplicitWaitsVisibilityOfElementLocatedBy(String locator, int timeOutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement LinkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		LinkText.click(); //Whatever Operation
	}

	public void ExplicitWaitsVisibilityOfAllElementsLocatedBy(int timeOutInSeconds, String GetAllTagNames)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		List<WebElement> AllTagnames = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(GetAllTagNames)));

		//get the number of TagNames found  // Example
		int Tagname = AllTagnames.size(); // Example
		System.out.println(AllTagnames);
	}

	public void ExplicitWaitsTitleIs(String expectedHomeTitle, int timeOutInSeconds)
	{
		//check if the home title is correct String ---Examle
		//expectedHomeTitle = "Vancouver Public Library |"; 
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		Boolean isTitleCorrect = wait.until(ExpectedConditions.titleIs(expectedHomeTitle));

		//Check assertion---Example
		// assertTrue(isTitleCorrect == true); ----Example

	}

	public void FluentWaits(int timeOutInSeconds, int pollingInSeconds, String xpath)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(pollingInSeconds, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) 
			{
				WebElement LinkText = driver.findElement(By.xpath(xpath));
				return LinkText;
			}
		});
		element.click();  //Whatever Operation
	} 
}
