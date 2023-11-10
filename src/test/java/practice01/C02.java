package practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {
    // https://www.amazon.com/ adresine gidin
    // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
    // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin


    @Test
    public void test01() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        String expectedTagName ="input";
        String actualTagName = aramaKutusu.getTagName();

        if (expectedTagName.equals(actualTagName)){
            System.out.println("test pass");
        }else{
            System.out.println("test fail");
        }

        //Assert --> junit gelir
        Assert.assertEquals(expectedTagName,actualTagName);



    // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        String expectedName = "field-keywords";
        String actualName= aramaKutusu.getAttribute("name");

        Assert.assertEquals(expectedName,actualName);
}
}
