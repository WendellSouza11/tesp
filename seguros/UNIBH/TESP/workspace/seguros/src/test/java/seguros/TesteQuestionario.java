package seguros;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unibh.seguros.entidades.Questionario;

public class TesteQuestionario {
	
	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

}
	@Test
	public void testeValidacaoQuestionarioOK() {
		Questionario o = new Questionario(1L, true, "teste", true, true, true, true, true, 1L, true, true, true);
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Questionario>> constraintViolations = validator.validate(o);
		Assert.assertEquals(0, constraintViolations.size());
	}
	
	@Test
	public void testeValidacaoQuestionarioErro() {
		Questionario o = new Questionario(1L, true, "@", true, true, true, true, true, 1L, true, true, true);
		
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Questionario>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Questionario> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(1, constraintViolations.size());
	
	
	}

}
