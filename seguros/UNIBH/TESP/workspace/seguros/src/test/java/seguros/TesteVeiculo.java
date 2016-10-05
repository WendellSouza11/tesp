package seguros;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unibh.seguros.entidades.TipoCombustivel;
import br.unibh.seguros.entidades.Veiculo;

public class TesteVeiculo {
	
	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

}
	@Test
	public void testeValidacaoVeiculoOK() {
		Veiculo o = new Veiculo(1L, "Fiat", "Gol", 2015, 2016, "ABC-1234", "HFSF6434566GFDS", TipoCombustivel.GASOLINA, true, true);
		
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Veiculo>> constraintViolations = validator.validate(o);
		Assert.assertEquals(0, constraintViolations.size());
	}
	
	@Test
	public void testeValidacaoVeiculoErro() {
		Veiculo o = new Veiculo(1L, "Fiat@", "Gol", 2015, 2016, "ABC-1234", "HFSF6434566GFDS", TipoCombustivel.GASOLINA, true, true);
				
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Veiculo>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Veiculo> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(1, constraintViolations.size());
	
	
	}
	

}
