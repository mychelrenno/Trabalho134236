import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConexaoBancoTeste {

	private Connection c;

	@Test
	public void ConecaoBancoTeste() throws SQLException, ClassNotFoundException{
		
		c = new DaoImp().Conexao();
		
		assertNotNull(c);
	
	}
	
	@After
	public void fecharConexao() throws SQLException{
		c.close();
	}

}
