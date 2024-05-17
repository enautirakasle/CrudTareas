package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestsCRUDTareas {
	public static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.get("http://localhost:8080/CrudTareas/IndexTarea");

	}

	@AfterEach
	void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	@Test
	@DisplayName("Carga de pagina principal OK")
	void paginaPrincipalOk() {
		String title = driver.getTitle();
		assertEquals("Crud tareas", title);
	}
	
	@Test
	@DisplayName("Ver tarea OK")
	void verTareaOK() {
//	    driver.manage().window().setSize(new Dimension(1936, 1056));
	    driver.findElement(By.linkText("Ver")).click();
	    assertEquals("Ver Tarea", driver.getTitle());
	}
	
	@Test
	@DisplayName("Crear tarea OK")
	void crearTareaOK() {
	    driver.findElement(By.linkText("Crear")).click();
	    driver.findElement(By.name("titulo")).click();
	    driver.findElement(By.name("titulo")).sendKeys("Tarea test");
	    driver.findElement(By.name("descripcion")).click();
	    driver.findElement(By.name("descripcion")).sendKeys("Descripcion tarea test");
	    driver.findElement(By.name("dificultad")).click();
	    {
	      WebElement dropdown = driver.findElement(By.name("dificultad"));
	      dropdown.findElement(By.xpath("//option[. = 'alto']")).click();
	    }
	    driver.findElement(By.cssSelector("option:nth-child(2)")).click();
	    driver.findElement(By.name("usuarios[]")).click();
	    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
	    driver.findElement(By.name("Guardar")).click();
	    driver.findElement(By.cssSelector(".alert")).click();
	    assertEquals("Ok! Tarea creada correctamente.", driver.findElement(By.cssSelector(".alert")).getText());
	    
	}
	
	
	
	

}
