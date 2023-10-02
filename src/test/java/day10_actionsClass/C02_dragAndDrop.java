package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_dragAndDrop extends TestBase {

  @Test
  public void test01(){
      //1- https://demoqa.com/droppable adresine gidelim
      driver.get("https://demoqa.com/droppable");
      //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
      WebElement suruklenecekElement = driver.findElement(By.xpath("//*[@id='draggable']"));
      WebElement surklenecekHedefAlan= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

      Actions actions = new Actions(driver);
      actions.dragAndDrop(suruklenecekElement,surklenecekHedefAlan).perform();

      //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

      String expectedyazi = "Dropped!";
      String actualYazi = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
      Assert.assertEquals(expectedyazi,actualYazi);

      bekle(3);
  }
}
