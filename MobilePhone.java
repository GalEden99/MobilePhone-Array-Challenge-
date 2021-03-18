import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contactsList = new ArrayList<Contact>();

    public void storeContact(Contact contact){
        contactsList.add(contact);
    }

    public void modifyContact(Contact currentContact, Contact newContact){
        int position = findContact(currentContact);
        if (position>=0) {
            modifyContact(position, newContact);
        }
    }

    public void modifyContact(int position, Contact newContact){
        contactsList.set(position, newContact);
        System.out.println("Contact has been modified.");

    }

    private int findContact(Contact searchContact) {
        return contactsList.indexOf(searchContact);
    }

    public boolean searchContact(Contact searchContact) {
        if (contactsList.indexOf(searchContact)>=0){
            return true;
        } return false;
    }

    public void removeContact(Contact contact){
        int position = findContact(contact);
        if (position>=0){
            removeContact(position);
        }
    }

    public void removeContact(int position){
        contactsList.remove(position);
    }

    public void queryContact(String contactName, int contactPhoneNumber){
        Contact contact = new Contact(contactName, contactPhoneNumber);
        contactsList.add(contact);
    }

    public void printContactList(){
        for(int i=0; i<contactsList.size(); i++){
            System.out.println((i+1) + ". " + contactsList.get(i).getName()
                    + " -> " + contactsList.get(i).getPhoneNumber() ); // check get(i)
        }
    }

    public int findPositionByName(String searchContactName){
        for (int i=0; i<contactsList.size(); i++){
            String currentName = contactsList.get(i).getName();

            if (searchContactName.equals(currentName) ){
                return i; // found position
            }
        }
        return -1; // = did not found
    }
}
