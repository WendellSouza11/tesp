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

import br.unibh.seguros.entidades.Proposta;

public class TesteProposta {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@Test
	public void testeValidacaoPropostaOK() {
		Date data = new Date();
		Proposta o = new Proposta(1L, data, "A", "CLASSE", new BigDecimal("90.00"), new BigDecimal("80.00"), data, data,
				2, new BigDecimal("50.00"), 12, "Caixa Economica", "AGENCIA", "SALDO", null, null, null, null);
/*(Long id, Date data, String classe, String codigoSusep, BigDecimal valorSegurado,
		BigDecimal valorFranquia, Date dataInicioVigencia, Date dataTerminoVigencia, int carenciaEmMeses,
		BigDecimal valorPremio, int diaPagamento, String bancoPagamento, String agencia, String conta,
		Segurado segurado, Veiculo veiculo, Questionario questionario, Set<Tramitacao> tramitacoes) */
		
System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Proposta>> constraintViolations = validator.validate(o);
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoPropostaErro() {
		Date data = new Date();
		Proposta o = new Proposta(1L, data, "A@", "CLASSE", new BigDecimal("90.00"), new BigDecimal("80.00"), data, data,
				2, new BigDecimal("50.00"), 12, "Caixa Economica", "AGENCIA", "SALDO", null, null, null, null);


		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Proposta>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Proposta> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(2, constraintViolations.size());

	}

}
