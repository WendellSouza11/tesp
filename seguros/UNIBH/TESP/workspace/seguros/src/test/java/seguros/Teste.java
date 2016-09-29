package seguros;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.seguros.entidades.Funcionario;
import br.unibh.seguros.entidades.Segurado;
import br.unibh.seguros.entidades.Setor;

public class Teste {

	@Test
	public void testeCriacaoFuncionario() {

		Funcionario o = new Funcionario(1L, "Maria", "F", "0123456789", null, null, null, null, null, null, null, null,
				null);
		System.out.println(o);
		Assert.assertNotNull(o);

	}

	@Test
	public void testeComparacaoFuncionario() {

		Funcionario o = new Funcionario(1L, "Joao", "M", "0123456789", null, null, null, null, null, null, null, null,
				null);
		Funcionario o2 = new Funcionario(1L, "Joao", "M", "0123456789", null, null, null, null, null, null, null, null,
				null);
		Assert.assertTrue(o.equals(o2));
		Funcionario o3 = new Funcionario(2L, "Maria", "F", "0123456789", null, null, null, null, null, null, null, null,
				null);
		Assert.assertFalse(o.equals(o3));

	}

	@Test
	public void testeCriacaoSegurado() {

		Segurado o = new Segurado(1L, "João", "M", "11111111111", null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null);
		System.out.println(o);
		Assert.assertNotNull(o);

	}

	@Test
	public void testeComparacaoSegurado() {

		Segurado o = new Segurado(1L, "Joao", "M", "11111111111", null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null);
		Segurado o2 = new Segurado(1L, "Joao", "M", "11111111111", null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null);
		Assert.assertTrue(o.equals(o2));
		Segurado o3 = new Segurado(2L, "Maria", "F", "11111111111", null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null);
		Assert.assertFalse(o.equals(o3));

	}

	@Test
	public void testeCriacaoSetor() {

		Setor o = new Setor(1L, "Recursos Humanos", "RH");
		System.out.println(o);
		Assert.assertNotNull(o);

	}

	@Test
	public void testeComparacaoSetor() {

		Setor o = new Setor(1L, "Recursos Humanos", "RH");
		Setor o2 = new Setor(1L, "Recursos Humanos", "RH");
		Assert.assertTrue(o.equals(o2));
		Setor o3 = new Setor(2L, "Operações", "op");
		Assert.assertFalse(o.equals(o3));

	}

}
