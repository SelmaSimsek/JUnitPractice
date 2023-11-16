package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C06_Actions_Iframe extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String amazonHandle = driver.getWindowHandle();
        System.out.println(amazonHandle);
        driver.navigate().refresh();
        driver.navigate().refresh();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin
                // mause'u bu menunun ustune getirelim
        WebElement dilMenü = driver.findElement(By.className("icp-nav-link-inner"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dilMenü).perform();
        bekle(2);

        // Change country/region butonuna basiniz
        WebElement changeButton = driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]"));
        changeButton.click();


        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.id("icp-dropdown"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");


        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
        bekle(2);
        //acılan dil menusu kapanmadıgı icin go to website butonu gorunmuyor
        //menuyu geri kapatmak icin sayfada herhangi bir yere tıkladım

        WebElement goToButton=driver.findElement(By.className("a-button-input"));
        bekle(3);
        goToButton.click();
        //yeni sekme acılıyor, window handle degeri degisiyor

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        /*      String yeniHandle="";
       for (String handle:whSet) {
            if (!handle.equals(amazonHandle)){
                yeniHandle=handle;
            }
        }*/

        Set<String> whSet = driver.getWindowHandles();
        String yeniHandle = whSet.toArray()[1].toString();
        driver.switchTo().window(yeniHandle);
        bekle(10);
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Elektronik"));


    }
}
