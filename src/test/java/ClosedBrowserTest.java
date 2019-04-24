import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClosedBrowserTest {
    @Test
    public void closedChrome() throws InterruptedException {
//        设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        WebDriver webDriver= new ChromeDriver();
        Thread.sleep(5000);
//        webDriver.close();
        webDriver.quit();
    }
}
