package pack2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Delete {
	private static final String FILE_NAME = "hotel_logs.txt";
	static void deleteByLine(int h) {
		RoomModule room = new RoomModule();
		boolean[] rooms = room.rooms;
		
        int roomDelete = h;
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
                if (parts.length > 0 && Integer.parseInt(parts[0]) == roomDelete) {
                    found = true; // Skip this line
                    rooms[roomDelete] = false; // Mark the room as available
                } else {
                    content.append(line).append(System.lineSeparator());
                }
            }
            reader.close();

            if (!found) {
                System.out.println("Line " + roomDelete + " not found.");
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                writer.write(content.toString());
            }
            System.out.println("Record deleted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the record.");
        }
    }
}
