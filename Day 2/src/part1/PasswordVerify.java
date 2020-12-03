package part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordVerify {

	public static void main(String[] args) {
		ArrayList<String> lines = new ArrayList<String>();
		
		int totalValid = 0;
		
		try {
			File myObj = new File("src/input");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		    		lines.add(myReader.nextLine());
		    }
		    	myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		
		for(int i = 0; i < lines.size(); i++) {
			String[] lineSplit = lines.get(i).split(" ", 3);
			String[] policy = lineSplit[0].split("-");
			int min = Integer.parseInt(policy[0]);
			int max = Integer.parseInt(policy[1]);
			char contains = lineSplit[1].charAt(0);
			char[] password = lineSplit[2].toCharArray();
			
			int numContains = 0;
			
			for(int j = 0; j < password.length; j++) {
				if(password[j] == contains) {
					numContains += 1;
				}
			}
			
			if(min <= numContains && max >= numContains) {
				totalValid += 1;
			}
		}
		
		System.out.println(totalValid);
	}
}
