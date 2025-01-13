package pack2;
import java.io.*;
import java.util.Scanner;

public class ha {
    //private static final String FILE_NAME = "hotel_logs.txt";
    //public static boolean[] rooms = new boolean[101];
   
    
    public static void main(String[] args) {
    	RoomModule room = new RoomModule();
    	
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n--- HOTEL RESERVATION MENU ---");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            //initialize read object for displaying available rooms 
            Read read = new Read();
            //switch case used for CRUD operations
            switch (choice) {
            	//Case 1: Create
                case 1:
                	
                	//Displays list of available and occupied rooms
                	room.displayRoom();
                	
                	//Checks rooms boolean array variable to see if a room is available
                	boolean[] rooms = room.rooms;
                	
                	//Create 'create' object
                	Create create = new Create();
                	
                	System.out.println();
                	System.out.println("enter 0 to cancel");
                	System.out.print("Enter room number: ");
                	
                	
                    int RN = scanner.nextInt();
                    
                    //Input a room number to check if it is available and store the returned value into 'availableRoom' variable
                    int availableRoom = create.checkRoom(RN);
                    
                    //if the variable returns a 1 the room is occupied, break the loop and start over again
                    if (availableRoom == 1) {
                    	break;
                    }
                    
                    //ask for user details and set create object attributes
                    scanner.nextLine();
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    create.setName(name);

                    System.out.print("Enter check in date: ");
                    String CI = scanner.nextLine();
                    create.SetCheckDate(CI);

                    System.out.print("Enter check out date: ");
                    String CO = scanner.nextLine();
                    create.SetCheckoutDate(CO);
                    
                    System.out.print("Enter number of guests: ");
                    String GN = scanner.nextLine();
                    create.setGuestNumber(GN);
                    
                    System.out.print("Enter room type (Standard, Deluxe, Suite): ");
                    String type = scanner.nextLine();
                    create.setRoomType(type);
                    
                    System.out.print("Extra requests: ");
                    String req = scanner.nextLine();
                    create.setRequests(req);
                	
                    //save attributes into 'hotel_logs' file
                    create.saveData();
                    break;
                case 2:
                	//runs read method from read class to display all rooms
                	Read.read();
                    break;
                case 3:
                	//Initialize update class
                	Update update = new Update();
                	
                	//set placeholder values, part is for the order of which the data is stored, room number = 0, name = 1 etc. value is the value to be modified into
                	int part = 0;
                	String value = "nil";
                	
                	//display rooms
                	Read.read();
                	System.out.println();
                	
                	//ask user for room number
                	System.out.print("Enter the number of the guest to update: ");
                    String num = scanner.nextLine();
                    
                    //perform check if someone lives on that room
                    if (room.validateRoom(Integer.parseInt(num)) == 0) {
                    	System.out.println("This guest does not exist!");
                    	break;
                    }
                    
                    //use of switch case in choosing which data entry to edit
                	System.out.println();
                	System.out.println("Select option to edit:"
                            + "\n1. Room Number"
                            + "\n2. Guest Name"
                            + "\n3. Check in Date"
                            + "\n4. Check out Date"
                            + "\n5. Number of guests"
                            + "\n6. Room type"
                            + "\n7. Extra requests"
                            + "\n0. Cancel");
                    int ans = scanner.nextInt();
                    scanner.nextLine();
                    switch (ans) {
                    case 1:
                        System.out.print("Enter new room number: ");
                        value = scanner.nextLine();
                        part = 0;
                        break;
                    case 2:
                        System.out.print("Enter new guest name: ");
                        value = scanner.nextLine();
                        part = 1;
                        break;
                    case 3:
                        System.out.print("Enter new check-in date: ");
                        value = scanner.nextLine();
                        part = 2;
                        break;
                    case 4:
                        System.out.print("Enter new check-out date: ");
                        value = scanner.nextLine();
                        part = 3;
                        break;
                    case 5:
                        System.out.print("Enter new number of guests: ");
                        value = scanner.nextLine();
                        part = 4;
                        break;
                    case 6:
                        System.out.print("Enter new room type: ");
                        value = scanner.nextLine();
                        part = 5;
                        break;
                    case 7:
                        System.out.print("Enter new extra requests: ");
                        value = scanner.nextLine();
                        part = 6;
                        break;
                    case 0:
                        System.out.println("Update canceled.");
                        value = "cancel";
                        break;
                    default:
                        System.out.println("Invalid option. No changes made.");
                        value = "default";
                        break;
                    }
                	
                    //call update method with the parameters to edit the value
                	update.update(num,part,value);
                    break;
                case 4:
                	//initialize delete class
                	Delete delete = new Delete();
                	
                	
                	//display the rooms
                	room.displayRoom();
                	
                	
                    System.out.print("Enter the room number to delete: ");
                    int roomDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    //call deleteByLine method with the room number as the parameter
                    delete.deleteByLine(roomDelete);
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    
}

