package RAM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TABLE_IDENTY {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venky\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
	
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	
	int valu= driver.findElements(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr")).size();
	
	System.out.println(valu);
	
        int coloum= driver.findElements(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[1]/th")).size();
	
	System.out.println(coloum);
	
	System.out.println("BookName"+"  "+"Author"+"   "+"Subjet"+"  "+"Price");
	
	 for(int i=2;i<=valu;i++) {
		 
		 for(int c=1;c<=coloum;c++) {
			 
			 
			 String value=driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+i+"]/td["+c+"]")).getText();
			 System.out.println(value +"   ");
		 }
		
			System.out.println();
	 }
	
		
	}
	
	}
	

  

