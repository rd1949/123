package gcdpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test {
	static String driverPath = "C:\\Users\\Downloads\\geckodriver-v0.32.0-win64\\geckodriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", driverPath);
//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//capabilities.setCapability("marionette",true);
//ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile fp = new FirefoxProfile();
//fp.setPreference(FirefoxProfile.PORT_PREFERENCE,"7055");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fp);
		WebDriver driver = new FirefoxDriver(options);// (capabilities);
//WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/eclipse-workspace/gcd/gcdhtml.html");
		driver.manage().window().maximize();
		driver.findElement(By.name("n1")).sendKeys("36");
		driver.findElement(By.name("n2")).sendKeys("6");
		driver.findElement(By.name("btn")).click();
		String result = driver.findElement(By.name("result")).getAttribute("value");
		System.out.println("GCD=" + result);
	}
}