package testseleproj;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class NewTest

{
	
	WebDriver driver;
	  @Test (priority=0)
	  public void home() throws InterruptedException 
	  {
		  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhuvaneswari\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.grootan.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		    Thread.sleep(2000);
		    
		    File screenshotone = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        
		        try {
		            FileUtils.copyFile(screenshotone, new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder 1\\home.png"));
		        } catch (IOException io) 
		        {
		            System.out.println(io.getMessage());
		        }
				
	  }
	  
	  @Test (priority=1)
	  public void services() throws InterruptedException
	  {
		  
		  driver.findElement(By.xpath("//*[@id='main-nav']/div[1]/ul/li[2]/a[2]")).click();
		  Thread.sleep(2000);
		  File screenshottwo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      
	      try {
	          FileUtils.copyFile(screenshottwo, new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder 1\\services.png"));
	      } catch (IOException io) 
	      {
	          System.out.println(io.getMessage());
	  }
		 //Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS,500).withName("actual").equals(image)
	  }
	  
 	  @Test (priority=2)
	  public void opensource() throws InterruptedException
	  {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id='main-nav']/div[1]/ul/li[2]/a[3]")).click();
		  Thread.sleep(2000);
		  
	File screenshotthree = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      
	      try {
	          FileUtils.copyFile(screenshotthree, new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder 1\\opensource.png"));
	      } catch (IOException io) 
	      {
	          System.out.println(io.getMessage());
	  }
	  }

	  
	  
	  @Test(priority=3)
	  public void blog() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id='main-nav']/div[1]/ul/li[2]/a[4]")).click();
		  Thread.sleep(1000);
		  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	  	    driver.switchTo().window(tabs2.get(0));
	  	  // driver.close();
	  	    driver.switchTo().window(tabs2.get(1));
	  	    Thread.sleep(6000);
	  	   try
	  	    {
	  	     driver.navigate();
	  	   Thread.sleep(2000);
	  	   	  	   
	  	    }
	  	    catch (Exception e)
	  	    {
	  	    	System.out.println(e);
	  	    }
	  	    driver.switchTo().window(tabs2.get(0));
	  	    Thread.sleep(2000);

	  	    
	File screenshotfour = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      
	      try {
	          FileUtils.copyFile(screenshotfour, new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder 1\\blog.png"));
	      } catch (IOException io) 
	      {
	          System.out.println(io.getMessage());
	  }
	  } 
	  @Test (priority=4)
	  public void team() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id='main-nav']/div[1]/ul/li[2]/a[5]")).click();
		  Thread.sleep(5000);
		  
		  
		  File screenshotfive = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      
	      try {
	          FileUtils.copyFile(screenshotfive, new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder 1\\team.png"));
	      } catch (IOException io) 
	      {
	          System.out.println(io.getMessage());
	  }
	  }

	  @Test (priority=5)
	  public void careers() throws InterruptedException
	  {
	  driver.findElement(By.xpath("//*[@id='main-nav']/div[1]/ul/li[2]/a[6]")).click();
	  Thread.sleep(2000);
	  
	  File screenshotsix = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  
	  try {
	      FileUtils.copyFile(screenshotsix, new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder 1\\careers.png"));
	  } catch (IOException io) 
	  {
	      System.out.println(io.getMessage());
	}
		  
	  }
	  
  
	  @Test(priority=6) 
	  public void contactus() throws InterruptedException
	  {
	  driver.findElement(By.xpath("//*[@id='main-nav']/div[1]/ul/li[2]/a[7]")).click();
	  Thread.sleep(2000);
	  
	  File screenshotseven = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  
	  try {
	      FileUtils.copyFile(screenshotseven, new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder 1\\contactus.png"));
	  } catch (IOException io) 
	  {
	      System.out.println(io.getMessage());
	}
		  
	  }

	}



	
	
	
	