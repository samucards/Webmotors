package Steps;

import java.io.IOException;

import Metodos.Metodos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	Metodos m = new Metodos();
	
	@Given("que o usuario acesse o {string}")
	public void que_o_usuario_acesse_o(String site) throws IOException {
	   m.acessarPlataforma(site);
	}

	@When("realizar a busca por marca {string}")
	public void realizar_a_busca_por_marca(String marca) throws IOException {
	 m.marca(marca);
	}

	@When("o modelo {string}")
	public void o_modelo(String modelo) throws IOException, InterruptedException {
	  m.modelo(modelo);
	}

	@Then("sera exibido retorno da busca")
	public void ser_exibido_retorno_da_busca() throws InterruptedException, IOException {
	m.validação();
	}

	@When("a versao")
	public void a_versao() throws IOException, InterruptedException {
	  m.versao();
	}
}
