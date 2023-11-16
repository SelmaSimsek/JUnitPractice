package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");

        // 'Drag me' kutusunu tutup 'Drop here' kutusunun ustune birakiniz
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop);
        bekle(2);

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        String dropped = driver.findElement
                (By.xpath("//p[text()='Dropped!']")).getText();
        Assert.assertEquals("Dropped!",dropped);

    }
}
