package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.entities.Product;

public class Program {

	public static void main(String[] args) {

		String path = "C:\\Users\\renatop.santos\\Desktop\\workspaces\\in.txt";
		List<Product> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Double price = Double.valueOf(fields[1]);
				Integer quantity = Integer.valueOf(fields[2]);
				Product prod = new Product(name, price, quantity);
				list.add(prod);
				line = br.readLine();			
			}
			System.out.println("PRODUCTS: ");
			list.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
