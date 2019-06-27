package RAM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DD1 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venky\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		
		
		WebDriver driver=new ChromeDriver();
		
	     
	      driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	      
	      driver.manage().window().maximize();
	      
	      String path ="C:\\Users\\Venky\\Documents\\RAM.xlsx";
	      xlutils.setExcelfile(path, "sheet1");
	      
	   
	     int rowcount =xlutils.getRowcount(path,"sheet1");
	     for (int i=1;i<=rowcount;i++) {
	    	 
	    	 int principal= Integer.parseInt(xlutils.getcelldata(path, "sheet1", i, 0 ));
	    	 int rateofintrest=Integer.parseInt(xlutils.getcelldata(path, "sheet1",i, 1));
	    	 int period =Integer.parseInt(xlutils.getcelldata(path, "sheet1",i, 2));
	    	 String frequency =xlutils.getcelldata(path, "sheet1", i,3);
	    	 double exp_value =Double.parseDouble(xlutils.getcelldata(path, "sheet1", i,4));
	    	 
	    	 driver.findElement(By.id("principal")).sendKeys(String.valueOf(principal));
	    	 driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofintrest));
	    	 driver.findElement(By.id("tenure")).sendKeys(String.valueOf(period));
	    	 
	    	
			Select perioddrp = new Select(driver.findElement(By.id("tenurePeriod")));
			perioddrp.selectByVisibleText("year(s)");
			
			Select frequencydrp = new Select(driver.findElement(By.id("frequency")));
			frequencydrp.selectByVisibleText("simple interest");
			
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
		String act_value=driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
		
		if ( exp_value==Double.parseDouble(act_value)) {
			
			System.out.println("testpassed");
		}
	    	 
		else {
	    	 
			System.out.println("test failed");
	    	 
	     }
	     
	     }
	     
	}

}

