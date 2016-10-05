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

import br.unibh.seguros.entidades.EtapaProcesso;
import br.unibh.seguros.entidades.TipoDecisao;
import br.unibh.seguros.entidades.Tramitacao;

public class TesteTramitacao {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@Test
	public void testeValidacaoTramitacaoOK() {
		Date data = new Date();
		Tramitacao o = new Tramitacao(1L, null, EtapaProcesso.APROVADA, new Date(20-01-2015), TipoDecisao.AUTOMATICA, null, null, null);
				
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Tramitacao>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Tramitacao> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoTramitacaoErro() {
		Date data = new Date();
		Tramitacao o = new Tramitacao(1L, null, EtapaProcesso.APROVADA, null, TipoDecisao.AUTOMATICA, null, null, null);
				
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Tramitacao>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Tramitacao> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(1, constraintViolations.size());
	}

	
	
}
