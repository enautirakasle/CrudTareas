package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.After;
import org.junit.Before;
// Generated by Selenium IDE
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class VerTareasOKTest {
  private WebDriver driver;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void verTareasOK() {
    driver.get("http://localhost:8080/CrudTareas/IndexTarea");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.linkText("Ver")).click();
    assertEquals("Ver Tarea", driver.getTitle());
    
  }
}