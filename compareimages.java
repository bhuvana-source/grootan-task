package testseleproj;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.sun.jna.platform.win32.COM.ITypeComp;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class compareimages

{	
	WebDriver driver;
	  @Test (priority=0)
	  public void screenshot() throws InterruptedException, IOException 
	  {
		  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhuvaneswari\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.grootan.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id='main-nav']/div[1]/ul/li[2]/a[5]")).click();
			WebElement CEO = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/div/div[1]/div[1]/img"));
			Screenshot CEOimage = new AShot().takeScreenshot(driver, CEO);
			ImageIO.write(CEOimage.getImage(),"png",new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder\\CEOfounder.jpg"));
			
			WebElement HRmanager = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/div/div[1]/div[2]/img"));
			Screenshot HRmanagerimage = new AShot().takeScreenshot(driver, HRmanager);
			ImageIO.write(HRmanagerimage.getImage(),"png",new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder\\Hrmanag.jpg"));
					    
	  }
	@Test (priority=1)
	public void comparingimages() throws IOException
	{
		BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder\\CEOfounder.jpg"));
		BufferedImage ActualImage = ImageIO.read(new File("C:\\Users\\Bhuvaneswari\\Desktop\\Folder\\HRmanag.jpg"));
		ImageDiffer imagediff = new ImageDiffer(); 
        ImageDiff ci = imagediff.makeDiff(expectedImage,ActualImage);
        if(ci.hasDiff()==true)
        		{
        	System.out.print("Images are NOT same\n");
        		}
        else
        {
        	System.out.print("Images are same\n");
        }
	}
	
	}
