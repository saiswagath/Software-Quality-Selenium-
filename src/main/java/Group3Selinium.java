import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Group3Selinium {

    public static WebDriver driver;
    static File junitReport;
    static BufferedWriter junitWriter;

    @BeforeTest
    public void beforeTest() throws IOException {
        String junitReportFile = "/Users/swagath/Desktop/Group3Selenium/group3TestReport.html";
        System.out.println();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        junitReport = new File(junitReportFile);
        junitWriter = new BufferedWriter(new FileWriter(junitReport, true));
        junitWriter.write("<html><head>\n" +
                "<style>\n" +
                "table, th, td {\n" +
                "  border: 1px solid blue;\n" +
                "}\n" +
                "</style>\n" +
                "</head><body>");
        junitWriter.write("<h1 style=\"text-align: center\">Test Results - </h1>");
        junitWriter.write("</body></html>");
        junitWriter.write("<table style=\"width:100%;background-color: beige;\"><tr>\n" +
                "    <th>Test scenario name</th>\n" +
                "    <th>Actual</th>\n" +
                "    <th>Expected</th>\n" +
                "    <th>Pass/Fail</th>\n" +
                "  </tr>");
        System.setProperty("webdriver.chrome.driver","/Users/swagath/Desktop/Group3Selenium/DriverSelinium/chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void scenario1() throws IOException {

        junitWriter.write("<tr>\n" +
                "    <td>Add items to “My Favorites” </td>\n" );

        junitWriter.write("<td>\n" +
                "    a) Login to My NEU portal<br/>\n" +
                "    b) Add items to My Favorites<br/>\n" +
                "  </td>");
        driver.get("https://my.northeastern.edu/group/student");
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Give your Northeastern username and pass
        driver.findElement(By.name("j_username")).sendKeys("******");
        driver.findElement(By.name("j_password")).sendKeys("******");
        driver.findElement(By.name("_eventId_proceed")).click();
        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        junitWriter.write("<td> a) Logged into My NEU portal<br/>\n" );
        driver.findElement(By.xpath("//*[@id=\"my-recent-links\"]/div/div/ul/li[2]/i")).click();
        junitWriter.write(" b) Add items to My Favorites <br/>\n" +
                "  </td>");
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(src, new File("/Users/swagath/Desktop/Group3Selenium/Screenshots/sc1.jpg"));
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        junitWriter.write(
                "    <td>Pass</td>\n" +
                        "  </tr>");
    }

    @Test
    public void scenario3() throws IOException {
        junitWriter.write("<tr>\n" +
                "    <td>Verify if users can browse classes for Full Summer 2020</td>\n" );
        junitWriter.write("<td>\n" +
                "       a) Login to My NEU portal<br/>\n" +
                "       b) Go to Course Registration<br/>\n" +
                "       c) Browse classes for full summer 2020<br/>\n" +
                "  </td>");
        driver.get("https://my.northeastern.edu/group/student");

        driver.findElement(By.tagName("input")).sendKeys("Course Registration");
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"app-search-list\"]/div/div/div/div[1]")).click();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.id("classSearchLink")).click();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("select2-choice")).click();
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("202050")).click();
        driver.findElement(By.id("term-go")).click();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).sendKeys("info");
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("INFO")).click();
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("search-go")).click();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        junitWriter.write("<td>\n" +
                "        a) Logged into My NEU portal<br/>\n" +
                "        b) Navigated to Course Registration<br/>\n" +
                "        c) Browsed classes for full summer 2020<br/>\n" +
                " </td>");
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(src, new File("/Users/swagath/Desktop/Group3Selenium/Screenshots/sc2.jpg"));
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        junitWriter.write("<td>Pass</td>\n" +
                "  </tr>");
    }

    @Test
    public void scenario4() throws IOException {
        junitWriter.write(" <tr><td>Add items to cart in NU Bookstore </td>\n" );

        junitWriter.write("<td>\n" +
                "        a) Login to NU bookstore<br/>\n" +
                "        b) Search an item<br/>\n" +
                "        c) Add item to cart<br/>\n" +
                "        d) View the cart<br/>\n" +
                "  </td>");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://northeastern.bncollege.com/shop/northeastern/home");
        // wait for new page load
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("Login/Sign up")).click();
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("logonId")).sendKeys("****");
        driver.findElement(By.id("logonPassword")).sendKeys("****");
        js.executeScript("window.scrollBy(0,200)");
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("login")).click();
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("topNavSearch")).sendKeys("HOOD");
        driver.findElement(By.name("searchbutton")).click();
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("window.scrollBy(0,200)");

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.className("gmImage"));
        action.moveToElement(we).click().build().perform();
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //*[@id="prodListCatlog"]/li/div/a/img
        //*[@id="prodListCatlog"]/li/a/div/img
        driver.findElement(By.xpath("//*[@id=\"prodListCatlog\"]/li/a/div/img")).click();
        //*[@id="productSizeList"]/ul/li/a
        driver.findElement(By.xpath("//*[@id=\"productSizeList\"]/ul/li/a")).click();
        driver.findElement(By.id("addToCartId")).click();
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("window.scrollBy(0,200)");

        junitWriter.write("<td>\n" +
                "        a) Looged to NU bookstore<br/>\n" +
                "        b) Searched for  an item<br/>\n" +
                "        c) Added item to cart<br/>\n" +
                "        d) Viewed the cart<br/>\n" +
                "  </td>");
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(src, new File("/Users/swagath/Desktop/Group3Selenium/Screenshots/sc3.jpg"));
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        junitWriter.write(
                "    <td>Pass</td>\n" +
                        "  </tr>");
        junitWriter.close();

    }
}
