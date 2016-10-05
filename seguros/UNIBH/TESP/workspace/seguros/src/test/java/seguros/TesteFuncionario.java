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

import br.unibh.seguros.entidades.Funcionario;

public class TesteFuncionario {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@Test
	public void testeValidacaoFuncionarioOK() {
		Date data = new Date();
		Funcionario o = new Funcionario(1L, "Joao", "M", "01637892667", "(31)0999-9999", "(99)9999-9999",
				"(99)89999-9999", "joao@joao", data, data, null, "PERFIL", "123456789", "12345");
		// Funcionario o = new Funcionario(id, nome, sexo, cpf,
		// telefoneComercial, telefoneResidencial, telefoneCelular, email,
		// dataNascimento, dataCadastro, setor, perfil, login, senha)
		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(o);
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoFuncionarioErro() {
		Date data = new Date();
		Funcionario o = new Funcionario(1L, "Joao", "B", "01637892667", "(31)0999-9999", "(99)9999-9999",
				"(99)89999-9999", "joao@joao", data, data, null, "PERFIL", "123456789", "12345");

		System.out.println(o);
		Assert.assertNotNull(o);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Funcionario> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}

		Assert.assertEquals(1, constraintViolations.size());
	}

}
