package part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
		
		for(int i = 0; i <values.size(); i++) {
			Integer value1 = values.get(i);
			for(int j = i + 1; j < values.size(); j++) {
				Integer value2 = values.get(j);
				for(int k = j + 1; k < values.size(); k++) {
					Integer value3 = values.get(k);
					if(value1 + value2 + value3 == 2020) {
						System.out.println("Values at intedices " + i + ", " + j + ", " + k);
						System.out.println("Values are " + value1 + ", " + value2 + ", " + value3);
						System.out.println(value1 * value2 * value3);
					}
				}			
			}
		}
	}
}
