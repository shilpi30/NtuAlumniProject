package page.classes;

import org.testng.annotations.Test;
import page.classes.LoginPage;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class TestNG {
	
	private WebDriver driver;
	private String baseURL = "http://ntualumniportal.excelindia.com/NTULogin";
	private String social= "linkedin";
	LoginPage loginPage;

 
	
  @BeforeSuite
  public void beforeClass(ITestContext ctx) {

	System.setProperty("webdriver.chrome.driver","C:\\Users\\shilpi.agarwal\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	   driver.get(baseURL);
	   ctx.setAttribute("driver", driver);
	   loginPage = new LoginPage(driver);
	  
  }
  
  /* @BeforeMethod 
  public void beforeMethod(ITestContext ctx){
	  ctx.setAttribute("driver", driver);
  } */
  
  public void clickLinkedin(WebDriver driver) throws InterruptedException {
	  
	  loginPage.linkedinLogin(driver).click();
	  loginPage.linkedinEnterEmail("ntualumniuser1@gmail.com");
      loginPage.linkedinEnterPassword("Excel@123");
	  loginPage.linkedinClickAllowAccessButton();
	  Thread.sleep(10000);
	 }
  
  public void clickFacebook() throws InterruptedException{
	  
	  LoginPage.facebookLogin(driver).click();
	  loginPage.facebookEnterEmail("ntualumniuser1@gmail.com");
	  loginPage.facebookEnterPassword("Excel@123");
	  loginPage.facebookClickLoginButton();
	  Thread.sleep(10000);
  }
  
  @Test
  public void clickSocial() throws InterruptedException {
	  
	  if(social.equals("linkedin")) {
		  
		  this.clickLinkedin(driver);
		  Thread.sleep(2000);
	  }
	  
	  else {
		  
		  this.clickFacebook();
	  }
	    
  }

  @AfterSuite
  public void afterClass() {
	 // driver.quit();
  }

}
