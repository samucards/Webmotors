package Pages;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import junit.framework.Assert;

public class Pages {
	public static WebDriver driver;

	public void pauser(int tempo, String descricaoPasso) throws InterruptedException {

		try {
			Thread.sleep(tempo);
		} catch (NoSuchElementException e) {
			Assert.fail(LocalDateTime.now() + " erro no passo \" + descricaoDoPasso");
		}

	}

	public void escrever(By elemento, String texto, String descricaoPasso) throws IOException {
		try {

			driver.findElement(elemento).sendKeys(texto);

		} catch (Exception e) {
			Assert.fail(LocalDateTime.now() + " -- erro ao tentar " + descricaoPasso);
			screnShoot(descricaoPasso);

		}
	}

	public void clicar(By elemento, String descricaoPasso) throws IOException {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			Assert.fail(LocalDateTime.now() + " --erro ao tentar " + descricaoPasso);
			screnShoot(descricaoPasso);

		}
	}

	public void btnEnter(By elemento, String descricaoPasso) throws IOException {
		try {
			driver.findElement(elemento).submit();
		} catch (Exception e) {
			Assert.fail(LocalDateTime.now() + " --erro ao tentar " + descricaoPasso);
			screnShoot("erros/" + descricaoPasso);
		}
	}

	public void screnShoot(String print) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
	//	 File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// File DestFile = new File(print);
		// FileUtils.copyFile(SrcFile, DestFile);
	}

	public void fecharBrowser(String descricaoPasso) throws IOException {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail(LocalDateTime.now() + " --erro ao tentar " + descricaoPasso);
			screnShoot(descricaoPasso);

		}
	}

	@SuppressWarnings("deprecation")
	public void selecionarComboPosicao(By elemento, int posicao, String descricaoDoPasso) {
		try {
			WebElement webElement = driver.findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByIndex(posicao);
		} catch (NoSuchElementException e) {
			Assert.fail(LocalDateTime.now() + "descriÁ„o do passo");
		}
	}

	public void selecionarComboTexto(By elemento, String texto, String descricaoDoPasso) {
		try {
			WebElement webElement = driver.findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByVisibleText(texto);
			;
		} catch (NoSuchElementException e) {
			Assert.fail(LocalDateTime.now() + " erro no passo \" + descricaoDoPasso");
		}
	}

	public void validarTexto(By elemento, String texto, String descricaoPasso) {
		try {
			String mensagem = driver.findElement(elemento).getText();
			assertEquals(texto, mensagem);

		} catch (NoSuchElementException e) {
			Assert.fail(LocalDateTime.now() + " erro no passo \" + descricaoDoPasso");
		}

	}

	public void executarNavegador(String appUrl, String navegador, String descricaoPasso) throws IOException {

		try {
			if (navegador == "CHROME" || navegador == "FIREFOX") {
				if (navegador == "CHROME") {
                  
					System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("incognito");
					driver = new ChromeDriver(options);
					driver.get(appUrl);
					driver.manage().window().maximize();
					 driver.manage().deleteAllCookies();
				} else if (navegador == "FIREFOX") {
					System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
					driver = new FirefoxDriver();
					driver.get(appUrl);
					driver.manage().window().maximize();

				}

			} else {
				System.out.println("Op√ß√£o inv√°lida escolha CHROME ou FIREFOX");
			}

		} catch (Exception e) {
			Assert.fail(LocalDateTime.now() + " --erro ao tentar " + descricaoPasso);
			screnShoot(descricaoPasso);

		}
		
	}
	
}