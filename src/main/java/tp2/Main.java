package tp2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		

		WebDriver driver = null;
		/*WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
		driver = new ChromeDriver(options); */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
 
		
		
		
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		driver.get("https://www.tunisianet.com.tn/");
		
		System.out.println("clic on user icon and connexion link");
		Thread.sleep(2000);
		WebElement userButton = driver.findElement(By.className("user-info"));
		userButton.click();
		WebElement connexionButton = userButton.findElement(By.xpath(".//parent::div/ul/li/a"));
		connexionButton.click();
		
		
		Thread.sleep(2000);
		System.out.println("clic on no-account button");		
		driver.findElement(By.cssSelector(".no-account > a")).click();
		
		
		Thread.sleep(2000);
		WebElement form = driver.findElement(By.id("customer-form"));
		System.out.println("choose gender");
		form.findElement(By.xpath("//input[@name='id_gender'][@value='1']")).click();
		System.out.println("choose firstName");
		form.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Scenario");
		System.out.println("choose lastname");
		form.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Scenario");
		System.out.println("choose email");
		form.findElement(By.cssSelector("input[name='email']")).sendKeys("Scenario2@gmail.com");
		System.out.println("choose password");
		form.findElement(By.cssSelector("input[name='password']")).sendKeys("Scenario2");
		System.out.println("choose birthday");
		form.findElement(By.cssSelector("input[name='birthday']")).sendKeys("22/05/1995");
		System.out.println("clic into submit button");
		form.findElement(By.cssSelector(".btn.btn-primary.form-control-submit.float-xs-right")).click();		
		
		Thread.sleep(2000);
		System.out.println("search for PC portable MacBook M1 13.3");
		driver.findElement(By.id("search_query_top")).sendKeys("PC portable MacBook M1 13.3");
		driver.findElement(By.id("sp-btn-search")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'PC Portable Apple MacBook Pro M1 (2020) 13.3\"')]")).click();

		Thread.sleep(2000);
		System.out.println("add to cart");
		driver.findElement(By.cssSelector(".add > button")).click();
		
		
		Thread.sleep(9000);		

		
		driver.quit();
	}

}
