package RAM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class table22222 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venky\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
	int row =driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr")).size();
	System.out.println(row);
		
	int coloum =driver.findElements(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th")).size();
	System.out.println(coloum);
		int count=0;
		
		for(int i=2;i<=row;i++) {
			
			String status=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+"]/td[5]")).getText();
			System.out.println(status);
			if(status.equals("Enabled")) {
				
				count++;
					
			}
			
			
		}
		System.out.println("number of persons enabled::"+count);
		
		System.out.println("number of persons disabled::" +(row-count));

	}

}
