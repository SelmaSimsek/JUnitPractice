package practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C07Dropdown extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Books" secenegini secin
        /*
        Dropdown i handle ederken 3 adim
        1-ddm locate et
        2- select objesi olustur
        3-
         */
        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(ddm);
        //select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");
        select.selectByVisibleText("Books");

        Thread.sleep(2000);

        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).
                sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        String result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(result.contains("Java"));
    }
}
