package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class Arquivo {

	public static void gravaProduto() throws IOException {

		Produto prod = new Produto();
		prod.setId(1);
		prod.setDescricao("desc");
		prod.setPreco(new BigDecimal(7.35));

		File file = new File("produto.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(prod);
	}

	public void lerProduto() throws IOException {
		InputStream inputstream;
		inputstream = new FileInputStream("produto.txt");

		int data = inputstream.read();
		while (data != -1) {
			System.out.println(data);

			data = inputstream.read();
		}
		inputstream.close();
		
		// File file = new File("produto.txt");
		// FileInputStream fis = new FileInputStream(file);
		// ObjectInputStream ois = new ObjectInputStream(fis);
		// Produto prod;
		// ois.writeObject(prod);

	}

	public static void main(String[] args) throws IOException {
		gravaProduto();
	}
}
