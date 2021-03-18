import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while (!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:

            }
        }
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add new contact to the list.");
        System.out.println("\t 3 - To modify a contact in the list.");
        System.out.println("\t 4 - To remove a contact from the list.");
        System.out.println("\t 5 - To search for a contact in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addContact(){
        System.out.println("Enter a new contact name: ");
        String contactName = scanner.nextLine();

        if (mobilePhone.findPositionByName(contactName)>=0){
            System.out.println("Contact already exists.");
        } else {
            System.out.println("Enter contact's phone number: ");
            int contactPhoneNumber = scanner.nextInt();

            mobilePhone.queryContact(contactName, contactPhoneNumber);
        }


    }



}
