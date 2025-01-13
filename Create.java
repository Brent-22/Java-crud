package pack2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Create {
	private static final String FILE_NAME = "hotel_logs.txt";
	
	
	//Set attributes
	int RoomNumber;
	String Name;
	String checkinDate;
	String checkoutDate;
	String guestAmount;
	String roomType;
	String requests;
	
	
	//perform room check, if room is available set RoomNumber to the RN value
	int checkRoom(int RN) {
		RoomModule room = new RoomModule();
		if ((room.validateRoom(RN)) == 1) {
			return 1;
		}
        this.RoomNumber = RN;
		return 0;
	}
	
	//set values for each attribute
	void setName(String setName) {
		this.Name = setName;
	}
	
	void SetCheckDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	
	void SetCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	void setGuestNumber(String guestAmount) {
		this.guestAmount = guestAmount;
	}
	
	void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	void setRequests(String requests) {
		this.requests = requests;
	}
	
	
	//save attributes into txt file
	void saveData() {
		//intiialize room module class and rooms boolean
		RoomModule room = new RoomModule();
		boolean[] rooms = room.rooms;
		
		//concatenate all data together, separated by a ','
		String record = RoomNumber + "," + Name + "," + checkinDate + "," + checkoutDate + "," + guestAmount + "," + roomType + "," + requests;
		
		//set room number to true inside the boolean array, so when it's called it returns a true, meaning the room is occupied
    	rooms[RoomNumber] = true;
    	
    	//access the file
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
    		//write the record into a text file
            writer.write(record);
            //enter a new line for spacing
            writer.newLine();
            System.out.println("Guest reservation logged successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the record.");
        }
	}
}
