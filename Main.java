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
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    quit = true;
                    break;
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

    public static void updateContact(){
        System.out.println("Enter the name of contact to modify: ");
        String contactName = scanner.nextLine();
        int position = mobilePhone.findPositionByName(contactName);

        System.out.println("position = " + position);

        if (position>=0){
            System.out.println("Enter contact's new phone number: ");
            int contactPhoneNumber = scanner.nextInt();

            Contact newContact = new Contact(contactName, contactPhoneNumber);
            mobilePhone.modifyContact(position, newContact);
        } else {
            System.out.println("Contact does not exists.");
        }
    }

    public static void removeContact(){
        System.out.println("Enter contact name to remove: ");
        String removeName = scanner.nextLine();
        int position = mobilePhone.findPositionByName(removeName);

        mobilePhone.removeContact(position);
    }

    public static void searchForContact(){
        System.out.println("Contact to search for: ");
        String searchName = scanner.nextLine();
        int position = mobilePhone.findPositionByName(searchName);

        if (position>=0){
            System.out.println("Found contact.");
        } else System.out.println("Contact not found.");
    }

}
