package Teste;


import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.Serealizacao;

public class testeSerealizacao {

	@Before
	public void setUp() throws Exception {
		Serealizacao s = new Serealizacao();
	}

	@Test
	public final void testGravarProduto() {
		assertEquals(expected, actual);
	}
	

	@Test
	public final void testLerProduto() {
		fail("Not yet implemented"); // TODO
	}
	
}