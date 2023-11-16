package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Iframe extends TestBase {
    @Test
    public void test01() {

        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");
        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);
        WebElement playTusu = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();
        bekle(2);

        // videoyu durdurunuz
        WebElement durdurOynatTusu = driver.findElement
                (By.xpath("//button[@class='ytp-play-button ytp-button']"));
        durdurOynatTusu.click();
        bekle(2);

        // videoyu tam ekran yapınız
        WebElement ekranTusu = driver.findElement
                (By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        ekranTusu.click();
        bekle(2);

        // videoyu calıstırınız
        durdurOynatTusu.click();
        bekle(2);

        // videoyu kucultunuz
        ekranTusu.click();
        bekle(2);

        // videoyu durdurunuz
        durdurOynatTusu.click();
        bekle(2);

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazi.isDisplayed());


        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        WebElement yaziEl = driver.findElement(By.xpath("//h1[text()='jQuery Flexy Plugin Demos']"));
        Assert.assertTrue(yaziEl.isDisplayed());
    }
}