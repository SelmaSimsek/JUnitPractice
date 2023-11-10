package practice01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01Ilk {
    // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
    // ilk kutucuga 20 giriniz
    // ikinci kutucuga 30 giriniz
    // calculate'e tıklayınız
    // sonucu yazdırınız
    // sayfayi kapatiniz

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
      //  driver.close();
        Thread.sleep(3000);
    }

    @Test
    public void test01() {
        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 20 giriniz
        driver.findElement(By.id("number1")).sendKeys("20");

        // ikinci kutucuga 30 giriniz
        driver.findElement(By.id("number2")).sendKeys("30");

        // calculate'e tıklayınız
        driver.findElement(By.id("calculate")).click();

        // sonucu yazdırınız
        System.out.println(driver.findElement(By.id("answer")).getText());

        // sayfayi kapatiniz

    }
}
