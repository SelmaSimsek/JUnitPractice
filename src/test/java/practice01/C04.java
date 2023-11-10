package practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C04 extends TestBase {
    // https://www.google.com/ adresine gidin
    // sayfa baslıgının "Google" kelimesini icerdigini test edin
    // arama cubuguna "Nutella" yazıp aratın
    // bulunan sonuc sayısını yazdırın
    // sonuc sayısının 100000000  fazla oldugunu test edin


    @Test
    public void test01() throws InterruptedException {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        boolean sayfaBaslik = driver.getTitle().contains("Google");
        Assert.assertTrue(sayfaBaslik);

        driver.findElement
                (By.xpath("//div[.='Tümünü reddet']"))
                .click();


        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.id("APjFqb")).
                sendKeys("Nutella", Keys.ENTER);
        Thread.sleep(2000);

        // bulunan sonuc sayısını yazdırın
        String sonucYazisi = driver.findElement(By.id("result-stats")).getText();
        System.out.println("sonucYazisi = " + sonucYazisi);

        // sonuc sayısının 100000000  fazla oldugunu test edin
        String sonucSayisi = sonucYazisi.split(" ")[1]; //159.000.000
        sonucSayisi = sonucYazisi.replaceAll("\\D",""); //159000000
        int sonucSayi = Integer.valueOf(sonucSayisi);

        Assert.assertTrue(sonucSayi>100000000);



    }
}
