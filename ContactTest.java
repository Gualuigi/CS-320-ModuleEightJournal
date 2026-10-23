import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    // Tests successful creation and getters/setters
    @Test
    public void testContactSuccessAndSetters() {
        Contact contact = new Contact("1", "Becky", "Griffin", "1234567894", "bgriff@gmail.com");
        assertEquals("1", contact.getContactID());
        contact.setFirstName("Becky");
        assertEquals("Becky", contact.getFirstName());
    }

    // Tests constructor failures
    @Test
    public void testConstructorFailures() {
        // null ID
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567899", "UnknownDude@gmail.com"));
        // extra long ID
        assertThrows(IllegalArgumentException.class, () -> new Contact("23216516745156971", "William", "Thatcher", "1123456789", "KnightsTaleFan@gmail.com"));
        // extra long firstName
        assertThrows(IllegalArgumentException.class, () -> new Contact("3", "BruceBrucieBruciendo", "Wayne", "5566541254", "notTheManBehindMask@gmail.com"));
        // extra long Lastname
        assertThrows(IllegalArgumentException.class, () -> new Contact("4", "Clark", "KentWillForeverBeTheBestFarmhandInSmallville", "1612345678", "iHartLL4ever@gmail.com"));
        // extra long Number
        assertThrows(IllegalArgumentException.class, () -> new Contact("5", "Johnny", "Test", "13131646464979797858558525252", "JTAndHisBestDog03@gmail.com"));
        // extra long Address
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Giraffe", "Daniels", "1234567889", "ReallyLongLegs-Fingernails-Toenails-AndVeryLongEmailAddresses123456789@gmail.com"));
    }

    // Tests setter failures
    @Test
    public void testSetterFailures() {
        Contact contact = new Contact("1", "Hercules", "Zeus'Son", "1234567890", "02Hero@gmail.com");
        // setting first name as null
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        // setting first name as longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("HadesIsWayBetterThanZeus"));
        // setting last name as longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ZeusSucksAtBasketball-Am-I-Write?"));
        // setting number to null
        assertThrows(IllegalArgumentException.class, () -> contact.setNumber(null));
        // setting address to null
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}