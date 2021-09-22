package Elementos;

import org.openqa.selenium.By;

public class Elementos {

	private By campoBusca = By.id("searchBar");
	private By btnVerOferta = By.xpath("//*[@id=\"WhiteBox\"]/div[1]/div[2]/div/div/a");
	private By reornoBusca = By.xpath("/html/body/div[1]/header/div[2]/div/div/div/a/div[2]");
	private By versoes = By.xpath("//div[normalize-space()='Todas as versões']");
	private By retornoVersao = By.xpath("//a[normalize-space()='1.5 DX 16V FLEX 4P AUTOMÁTICO']");
	private By retornoTelaVersao = By.xpath("//h3[normalize-space()='1.5 DX 16V FLEX 4P AUTOMÁTICO']");

	public By getCampoBusca() {
		return campoBusca;
	}

	public By getBtnVerOferta() {
		return btnVerOferta;
	}

	public By getReornoBusca() {
		return reornoBusca;
	}

	public By getVersoes() {
		return versoes;
	}

	public By getRetornoVersao() {
		return retornoVersao;
	}

	public By getRetornoTelaVersao() {
		return retornoTelaVersao;
	}

}
