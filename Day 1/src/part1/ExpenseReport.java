package part1;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ExpenseReport {

	public static void main(String[] args) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		try {
			File myObj = new File("src/input.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		    		values.add(new Integer(myReader.nextLine()));
		    }
		    	myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		
		while(!values.isEmpty()) {
			Integer current = values.remove(0);
			for(int i = 0; i < values.size(); i++) {
				if(current + values.get(i) == 2020) {
					System.out.println(current * values.get(i));
				}
			}
		}
	}
}
