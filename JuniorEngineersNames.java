package testseleproj;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.util.List;
import java.util.concurrent.TimeUnit;

public class JuniorEngineersNames {


    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhuvaneswari\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.grootan.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Team")).click();
        for (int i = 1; i <= driver.findElements(By.xpath("//h5[text()='Junior Engineer']")).size(); i++) {

//            List<WebElement> Designation = driver.findElements(By.xpath("//h5[text()='Junior Engineer']"));
            System.out.println("Name : " + driver.findElement(By.xpath("(//h5[text()='Junior Engineer']/preceding-sibling::h3)[" + i + "]")).getText());
            String Names = driver.findElement(By.xpath("(//h5[text()='Junior Engineer']/preceding-sibling::h3)[" + i + "]")).getText();
            FileInputStream fis = new FileInputStream("./testdata/Login data.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Row row = sheet.createRow(i-1);
            Cell cell = row.createCell(0);
            cell.setCellValue(Names);
            FileOutputStream fos = new FileOutputStream("./testdata/Login data.xlsx");
            workbook.write(fos);
            fos.close();
        }

        driver.quit();
    }
}


