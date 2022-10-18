package Login_test;

import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import org.openqa.selenium.chrome.ChromeDriver; 

public class Test { 
	 	public static void main(String[] args) 
	 	{ 
	 	 	// Path of chrome driver 
	 	 	// that will be local directory path passed 
	 	 	System.setProperty( 
	 	 	 	"webdriver.chrome.driver", 
	 	 	 	"C:\\Users\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
	 	 	WebDriver driver = new ChromeDriver(); 
 
 	 	// URL of the login website that is tested  	 	driver.get("https://auth.geeksforgeeks.org/");  	 	// Maximize window size of browser 
	 	 	driver.manage().window().maximize(); 
 
	 	 	// Enter your login email id 
	 	 	driver.findElement(By.id("luser")) 
	 	 	 	.sendKeys("temp53203@gmail.com"); 
 
 	 	// Enter your login password  	 	
	 	 	driver.findElement(By.id("password")) 
	 	 	 	.sendKeys("rdnational"); 
 
	 	 	driver.findElement(By.className("signin-button")) 
	 	 	 	.click(); 
	 	} 
} 

