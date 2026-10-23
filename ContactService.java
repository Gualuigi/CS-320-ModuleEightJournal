import java.util.ArrayList;
import java.util.Iterator;

public class ContactService{
    // arrayList for storing contact objects
    private final ArrayList<Contact> contactList;

    // constructor to initialize empty list
    public ContactService(){
        this.contactList = new ArrayList<>();
    }

    // adding contact
    public void addContact(Contact newContact){
        // checks if newContact is null
        if (newContact == null){
            throw new IllegalArgumentException("Contact can not be null.");
        }
        // makes sure ID doesn't match another ID
        for (Contact con: contactList){
            if (con.getContactID().equals(newContact.getContactID())){
                throw new IllegalArgumentException("Contact ID already applied to other contact.");
            }
        }
        // adds new contact if not illegal argument found
        contactList.add(newContact);
    }
    // deleting contact by ID
    public void deleteContact(String contactID){
        // checks if ID is null
        if (contactID == null){
            throw new IllegalArgumentException("ID can not be null.");
        }
        boolean removed = false;
        // iteration to move through list
        Iterator<Contact> iterator = contactList.iterator();

        while(iterator.hasNext()){
            // grabbing the next contact in line
            Contact currentContact = iterator.next();
            // Checking if ID matches
            if (currentContact.getContactID().equals(contactID)){
                // removes from list
                iterator.remove();
                removed = true;
                // since found, will stop searching
                break;
            }
        }
        if (!removed){ // if not found, will throw exception error
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }
    public void updateContact(String contactID, String firstName, String lastName, String Number, String Address){
        // making sure ID is not null
        if (contactID == null){
            throw new IllegalArgumentException("Id can not be null.");
        }
        boolean found = false;
        // loop for finding contact
        for (Contact con : contactList){
            if (con.getContactID().equals(contactID)){
                found = true;
                // will only update non-null values
                if (firstName != null){
                    con.setFirstName(firstName);
                }
                if (lastName != null){
                    con.setLastName(lastName);
                }
                if (Number != null){
                    con.setNumber(Number);
                }
                if (Address != null){
                    con.setAddress(Address);
                }
                // after found and updated, will stop searching
                break;
            }
        }
        if (!found){ // if not found, will give error
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }
}
