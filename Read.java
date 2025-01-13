package pack2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read {
	//initialize txt file variable
	private static final String FILE_NAME = "hotel_logs.txt";
    static void read() {
    	//read text file
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            //print out labels with spacing format
            System.out.println("\n--------------------------------------- Hotel Records ----------------------------------------------------------------------------");
            System.out.printf("%-7s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Room #", "Name", "Check in date", "Check out date", "Number of guests","Room type","Requests");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            
            //loop through each content until it returns a null
            while ((line = reader.readLine()) != null) {
            	//split contents in between ','
                String[] parts = line.split(",");
                //if total parts split are 7 then print out contents with same formatting making sure it's under the labels
                if (parts.length == 7) {
                    System.out.printf("%-7s %-20s %-20s %-20s %-20s %-20s %-20s\n", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No records found. Please create records first.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the records.");
        }
    }
}
