package practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05CheckBox extends TestBase {

    @Test
    public void test01() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");


        // checkbox elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox2 = driver.findElement(By.id("vfb-6-2"));
        WebElement checkBox3 = driver.findElement(By.id("vfb-6-3"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        if (!checkBox3.isSelected()){
            checkBox3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkBox2.isSelected());

    }
}
