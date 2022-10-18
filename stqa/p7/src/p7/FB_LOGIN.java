package p7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

//import org.openqa.selenium.firefox.internal.ProfilesIni; 
public class FB_LOGIN {
	static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", driverPath);

		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile fp = new FirefoxProfile();

//fp.setPreference(FirefoxProfile.PORT_PREFERENCE,"7055"); 
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fp);

//objects and variables instantiation 
		WebDriver driver = new FirefoxDriver(options);
		String appUrl = "https://www.facebook.com/";

		driver.get(appUrl);
		driver.manage().window().maximize();

		// declare and initialize the variable to store the expected title of the
		// webpage.
		String expectedTitle = "Facebook – log in or sign up";

		// fetch the title of the web page and save it into a string variable
		String actualTitle = driver.getTitle();

		// compare the expected title of the page with the actual title of the page and
		// print the result
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Verification Successful - The correct title is displayed on the web page.");
		} else {
			System.out.println("Verification Failed - An incorrect title is  displayed on the web page.");
		}
		// enter a valid username in the email textbox
		WebElement username = driver.findElement(By.id("email"));
		username.clear();
		username.sendKeys("your email id");

		// enter a valid password in the password textbox
		WebElement password = driver.findElement(By.id("pass"));
		password.clear();
		password.sendKeys("your password");
		password.sendKeys(Keys.ENTER);

		// click on the Sign in button
		WebElement LogInButton = driver.findElement(By.id("u_0_2"));
		LogInButton.click();

		System.out.println("Test script executed successfully.");
		System.exit(0);
	}
}
