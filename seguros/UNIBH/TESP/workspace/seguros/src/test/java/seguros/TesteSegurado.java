package seguros;

import java.util.Date;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unibh.seguros.entidades.Segurado;

public class TesteSegurado {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@Test
	public void testeValidacaoSeguradoOK() {
		Date data = new Date();
		Segurado o = new Segurado(1L, "Antônio", "M", "01637892667", "(31)1234-5678", "(31)3459-5403", "(31)98541-2613",
				"vander.ls.bh@hotmail.com", data, data, "A", "14922259", "MG", "11", "A", data, data, "Rua Franciso Jota",
				"97", "Casa", "31575-360", "Lebom", "Belo Horizonte", "MG");
		//Segurado o = new Segurado(id, nome, sexo, cpf, telefoneComercial, telefoneResidencial, telefoneCelular, email, dataNascimento, dataCadastro, classe, numeroRG, orgaoExpedidorRG, numeroHabilitacao, tipoHabilitacao, dataValidadeHabilitacao, dataPrimeiraHabilitacao, logradouro, numero, complemento, cep, bairro, cidade, estado)
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Segurado>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Segurado> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoSeguradoErro() {
		Date data = new Date();
		Segurado o = new Segurado(1L, "Antônio@", "M", "01637892667", "(31)1234-5678", "(31)3459-5403", "(31)98541-2613",
				"vander.ls.bh@hotmail.com", data, data, "A", "14922259", "MG", "11", "A", data, data, "Rua Franciso Jota",
				"97", "Casa", "31575-360", "Lebom", "Belo Horizonte", "MG");
		//Segurado o = new Segurado(id, nome, sexo, cpf, telefoneComercial, telefoneResidencial, telefoneCelular, email, dataNascimento, dataCadastro, classe, numeroRG, orgaoExpedidorRG, numeroHabilitacao, tipoHabilitacao, dataValidadeHabilitacao, dataPrimeiraHabilitacao, logradouro, numero, complemento, cep, bairro, cidade, estado)
		
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Segurado>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Segurado> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(1, constraintViolations.size());
	}

	

}