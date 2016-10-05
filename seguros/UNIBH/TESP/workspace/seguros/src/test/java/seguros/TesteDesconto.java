package seguros;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unibh.seguros.entidades.Desconto;



public class TesteDesconto {

	
	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@Test
	public void testeValidacaoDescontoOK() {
		Date data = new Date(); //Desnecessário quando quando já tem o new Date() em baixo
		Desconto o = new Desconto(1L, "A", new Date(), null, new BigDecimal ("100.00"));
				
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Desconto>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Desconto> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(0, constraintViolations.size());
	}
	
	
		
}
