package seguros;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unibh.seguros.entidades.Setor;

public class TesteSetor {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testeValidacaoSetorOK() {
		Setor o = new Setor(1L, "Recursos Humanos", "RH", null, null);
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Setor>> constraintViolations = validator.validate(o);
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoSetorErro() {
		Setor o = new Setor(1L, "Recursos Humanos@", "RH", null, null);
		System.out.println(o);
		Set<ConstraintViolation<Setor>> constraintViolations = validator.validate(o);
		Assert.assertEquals(1, constraintViolations.size());
		System.out.println(" Erro de Validacao: " + constraintViolations.iterator().next().getMessage());
	}

}
