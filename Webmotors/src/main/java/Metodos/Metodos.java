package Metodos;

import java.io.IOException;

import Elementos.Elementos;
import Pages.Pages;

public class Metodos extends Pages {
	Elementos e = new Elementos();

	public void acessarPlataforma(String site) throws IOException {
		executarNavegador(site, "CHROME", "Abrindo navegador");

	}

	public void marca(String marca) throws IOException {
		escrever(e.getCampoBusca(),marca, "buscando marcar");
		clicar(e.getBtnVerOferta(), "botão buscar");
	}

	public void modelo(String modelo) throws IOException, InterruptedException {
       pauser(2000, "Pausa");
		escrever(e.getCampoBusca(), modelo, "buscando modelo");
		pauser(2000, "pausa");
		clicar(e.getReornoBusca(), "retorno do modelo");
	}

	public void versao() throws IOException, InterruptedException {
		pauser(2000, "Pausa");
		clicar(e.getVersoes(), "abrindo tipos de versao");
		pauser(2000, "Pausa");
		clicar(e.getRetornoVersao(), "clicando na versão");
      
	}

	public void validação() throws InterruptedException, IOException {
		pauser(2000, "Pausa");
		System.out.println(e.getRetornoTelaVersao());		
		validarTexto(e.getRetornoTelaVersao(), "1.5 DX 16V FLEX 4P AUTOMÁTICO", "validando texto");
		pauser(2000, "Pausa");
		 fecharBrowser("fechando navegador");
	}
}
