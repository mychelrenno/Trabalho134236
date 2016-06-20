package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Produto;
import model.Produtos;

public class Xml {

	public static void gravarProduto() throws JAXBException, IOException {

		Produto prod = new Produto();
		prod.setId(1);
		prod.setDescricao("desc");
		prod.setPreco(new BigDecimal(7.35));

		Produto prod2 = new Produto();
		prod2.setId(2);
		prod2.setDescricao("desc2");
		prod2.setPreco(new BigDecimal(8.46));

		List<Produto> listProd = new ArrayList<>();
		listProd.add(prod);
		listProd.add(prod2);

		// for (Produto produto : listProd) {
		// System.out.println(produto.getId());
		// }

		Produtos produtos = new Produtos();
		produtos.setProdutos(listProd);

		JAXBContext context = JAXBContext.newInstance(Produtos.class);
		Marshaller marshal = context.createMarshaller();

		marshal.marshal(produtos, System.out);

		// FileWriter writer = new FileWriter("produto.xml");
		// marshal.marshal(produtos, writer);
		marshal.marshal(produtos, new File("produto.xml"));
	}

	public static void lerProduto() throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Produtos.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		Produtos produtos = (Produtos) unmarshaller.unmarshal(new File("produto.xml"));

		for (Produto produto : produtos.getProdutos()) {
			System.out.println("\n------------------------------------------------------");
			System.out.println(produto.getId());
			System.out.println(produto.getDescricao());
			System.out.println(produto.getPreco());
		}
	}

	public static void main(String[] args) throws JAXBException, IOException {
		gravarProduto();
		lerProduto();
	}
}
