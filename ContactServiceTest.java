import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;

    // making sure this starts before runs
    @BeforeEach
    public void setUp() {
        // makes new list before each test
        service = new ContactService();
    }

    // checks if adding a valid contact works without errors
    @Test
    public void testAddingContact() {
        // creating a good contact object
        Contact contact = new Contact("1", "Bill", "Nye", "1254202345", "ScienceRules@gmail.com");
        // adds contact
        service.addContact(contact);
        // creating a second contact with a different ID
        Contact contact2 = new Contact("2", "Bill", "Murray", "1987654311", "whoUgonnaCall@gmail.com");
        // makes sure that adding this new contact does not cause issues
        assertDoesNotThrow(() -> service.addContact(contact2));
    }

    // checks to if it crashes when we pass an empty null contact
    @Test
    public void testCannotAddNullContact() {
        // makes sure that passing a null forces an illegal argument error
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    // checks that 2 contacts cannot have same ID
    @Test
    public void testCannotAddDuplicateID() {
        // 2 different contacts with the exact same ID
        Contact firstPerson = new Contact("1", "Jimmy", "Johns", "3216548448", "getyaSammies@gmail.com");
        Contact secondPerson = new Contact("1", "Sub", "Way", "0987653221", "5dollaftlong@gmail.com");
        service.addContact(firstPerson);
        //adding 2nd person to make sure it gives us illegal argument error
        assertThrows(IllegalArgumentException.class, () -> service.addContact(secondPerson));
    }

    // checking if deleting a contact by ID works
    @Test
    public void testDeletingContact() {
        // creating contact to later delete
        Contact contact = new Contact("1", "Millers", "AleHouse", "3215654125", "burgersNfries@gmail.com");
        service.addContact(contact);
        // deletes ID 1 and makes sure it does not cause errors
        assertDoesNotThrow(() -> service.deleteContact("1"));
        // tries deleting 1 again, but instead would cause an error since its already gone
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1"));
    }

    // tests if deleting an ID that doesn't exist causes errors
    @Test
    public void testDeleteMissingID() {
        // tries deleting ID 50 from empty list
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("50"));
    }

    // checks if updating every field on a contact changes the data properly
    @Test
    public void testUpdateAllFields() {
        // creates a normal contact with no errors
        Contact contact = new Contact("1", "Frankie", "Valli", "3216549874", "SherryBaby@gmail.com");
        service.addContact(contact);
        // we update contact with ID 1
        service.updateContact("1", "Johnny", "Test", "1212121212", "JohnnyNDog@gmail.com");
        // we check the contact directly to make sure that fields changed to the new values
        assertEquals("Johnny", contact.getFirstName());
        assertEquals("Test", contact.getLastName());
        assertEquals("1212121212", contact.getNumber());
        assertEquals("JohnnyNDog@gmail.com", contact.getAddress());
    }

    // checks if passing a null during update keeps the old values
    @Test
    public void testUpdateKeepsOldValues() {
        // creates a normal contact with no errors
        Contact contact = new Contact("1", "Frankie", "Valli", "3216549874", "SherryBaby@gmail.com");
        service.addContact(contact);
        // update it, but passing null for the things we don't want to change
        service.updateContact("1", null, "Sinatra", null, "FlyMe@gmail.com");
        // making sure Frankie and the  number stayed the same after we passed null
        assertEquals("Frankie", contact.getFirstName());
        assertEquals("3216549874", contact.getNumber());
        // making sure the last name and address successfully updated to the new values
        assertEquals("Sinatra", contact.getLastName());
        assertEquals("FlyMe@gmail.com", contact.getAddress());
    }

    // checks if trying to update an ID that does not exist causes an error
    @Test
    public void testUpdateMissingID() {
        // tries updating ID "60" to confirm it gives error because that ID doesn't exist
        assertThrows(IllegalArgumentException.class, () ->
                service.updateContact("60", "Go", "Diego", "3213216549", "SafariAdven@gmail.com")
        );
    }
}
