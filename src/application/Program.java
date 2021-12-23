package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import entities.Candidate;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> reportVotes = new HashMap<>();
        
		//"C:\\temp\\in.txt"
		System.out.println("Enter file full path:");
		String path =   sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
					
				String calculatingVotes[] = line.split(",");
				Candidate candidates = new Candidate(calculatingVotes[0],Integer.parseInt(calculatingVotes[1]));
				if (reportVotes.containsKey(candidates.getName())){
					int sum = reportVotes.get(candidates.getName());
					reportVotes.put(candidates.getName(), candidates.getVotes()+sum);
					line = br.readLine();
				
				} else {
					reportVotes.put(candidates.getName(), candidates.getVotes());
					line = br.readLine();
					


				}
				
				
			}
			
			for (String key: reportVotes.keySet()) {
				System.out.println(key + " - " + reportVotes.get(key));

			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}