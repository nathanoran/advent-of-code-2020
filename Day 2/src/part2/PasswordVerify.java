package part2;

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
			boolean valid = false;
			
			String[] lineSplit = lines.get(i).split(" ", 3);
			String[] policy = lineSplit[0].split("-");
			int idx1 = Integer.parseInt(policy[0]) - 1;
			int idx2 = Integer.parseInt(policy[1]) - 1;
			char contains = lineSplit[1].charAt(0);
			char[] password = lineSplit[2].toCharArray();
						
			
			if(password[idx1] == contains) {
				valid = true;
			}
			
			if(password[idx2] == contains) {
				if(valid) {
					valid = false;
				} else {
					valid = true;
				}
			}
			
			if(valid) {
				totalValid += 1;
			}
		}
		
		System.out.println(totalValid);
	}
}

