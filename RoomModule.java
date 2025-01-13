package pack2;
import java.io.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RoomModule {
	static Scanner scanner = new Scanner(System.in);
	private static final String FILE_NAME = "hotel_logs.txt";
	public static boolean[] rooms = new boolean[101];
	
	static void updateRoom() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
//                System.out.println("len" + parts.length);
                	int nums = Integer.parseInt(parts[0]);
                	rooms[nums] = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No records found. Please create records first.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the records.");
        }
	}
	
	int validateRoom(int RN) {
		updateRoom();
		if (rooms[RN] == true) {
        	System.out.println("Room occupied!");
        	return 1;
        } else if (RN == 0) {
        	return 1;
        } else {
        	return 0;
        }
	}
	
	static void displayRoom() {
		updateRoom();
    	System.out.println("Available rooms:");
    	for (int i = 1; i <= (rooms.length -1); i++) {
    		if (rooms[i] == true) {
    			System.out.print("[" + i + "]" + " ");
    		} else {
    			System.out.print(i + " ");
    		}
    		
    		if (i % 10 == 0) {
    			System.out.print("\n");
    		}
    	}
    }
    

}
