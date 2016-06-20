package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

import model.Produto;

public class Serealizacao {

	public static void gravarProduto() throws IOException {

		Produto prod = new Produto();
		prod.setId(1);
		prod.setDescricao("desc");
		prod.setPreco(new BigDecimal(7.35));

		File file = new File("produto.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(prod);
	}

	public static void lerProduto() throws IOException, ClassNotFoundException {

		File file = new File("produto.txt");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Produto prod = (Produto) ois.readObject();
		System.out.println(prod.getId());
		System.out.println(prod.getDescricao());
		System.out.println(prod.getPreco());

	}

//	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		gravaProduto();
//		lerProduto();
//	}
}
