package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		System.out.println("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.valueOf(fields[1]);
				
				if(map.containsKey(name)) {
					int votesSoFar = map.get(name);
					map.put(name, votesSoFar + votes);
				} else {
					map.put(name, votes);
				}
				
				line = br.readLine();
			}
			
			for (String key : map.keySet()) {
				System.out.println("Candidato: " + key + " | Votos Totais: " + map.get(key));
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		sc.close();
	}
}
