package pack2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Update {
	//initialize txt file variable
	private static final String FILE_NAME = "hotel_logs.txt";
	static void update(String num, int part, String value) {
        String gnUpdate = num;
        RoomModule room = new RoomModule();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("File not found. Please create the file first.");
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            boolean found = false;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7 && parts[0].equals(gnUpdate)) {
                    found = true;
                    if (part == 0) {
                    	if (room.validateRoom(Integer.parseInt(value)) == 1) {
                    		System.out.println("Someone is alreadyy in this room!");
                    		return;
                    	}
                    	parts[part] = value;
                    } else {
                    	parts[part] = value;
                    }
                   
                    
                    content.append(String.join(",", parts)).append(System.lineSeparator());
                } else {
                    content.append(line).append(System.lineSeparator());
                }
            }
            reader.close();

            if (!found) {
                System.out.println("Guest #" + gnUpdate + " not found.");
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                writer.write(content.toString());
            }
            System.out.println("Record updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the record.");
        }
    }

}
