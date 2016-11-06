package WebDriverTest.WebDirverTest;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
	final static Logger logger = Logger.getLogger(NewTest1.class);

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kuba\\Desktop\\chromedriver.exe");
		//WindowsUtils.tryToKillByName("chrome.exe");
		
		WebDriver driver = new ChromeDriver();
		try {
			logger.debug("zaczynamy test");
			driver.get("http://www.twojapogoda.pl");
			logger.debug("jesteśmy nagłównej stronie");
			List <WebElement> lista = driver.findElements(By.xpath("//div"));
			List<WebElement> zbior = driver.findElements(By.tagName("div"));
			int liczba2 = zbior.size();
			int liczba = lista.size();
			System.out.println("liczba div na stronie "+liczba);
			System.out.println("liczba div według tagName " + liczba2);
			logger.debug("Koniec testu");
			
			
			
				
			driver.manage().window().maximize();
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String title = driver.getTitle();
			System.out.println(title);
			String napis = "Prognoza pogody na jutro";
			WebElement element = driver.findElement(By.xpath("//div[@id='box-map-default']/h2"));
			Assert.assertEquals(napis.toUpperCase(), element.getText().toUpperCase());
			
			

		}

		catch (Exception e) {
			System.out.println("PROBLEM  " + e);
			driver.quit();
			
		}

		finally{
			driver.close();
		}
	}

}
