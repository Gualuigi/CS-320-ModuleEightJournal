public class Contact{

    // variables
    private final String contactID;
    private String firstName;
    private String lastName;
    private String Number;
    private String Address;

    // constructor
    public Contact(String contactID, String firstName, String lastName, String Number, String Address){

        // illegal argument exceptions checks
        if (contactID == null || contactID.length() > 10) { // making sure length under 10 and not null
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) { // making sure length under 10 and not null
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) { // making sure length under 10 and not null
            throw new IllegalArgumentException("Invalid last name");
        }
        if (Number == null || !Number.matches("\\d{10}")) { // making sure length is 10 digits and not null
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        if (Address == null || Address.length() > 30) { // making sure length under 30 and not null
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactID= contactID; // must not exceed 10 characters
        this.firstName = firstName; // must not exceed 10 characters
        this.lastName = lastName; // must not exceed 10 characters
        this.Number = Number; // must have exactly 10 digits
        this.Address = Address; // must not exceed 30 characters
    }

    // getters
    public String getContactID() {
        return contactID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return Address;
    }
    public String getNumber() {
        return Number;
    }
    // setters with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }
    public void setNumber(String Number) {
        if (Number == null || !Number.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        this.Number= Number;
    }
    public void setAddress(String Address) {
        if (Address == null || Address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.Address = Address;
    }

    @Override
    public String toString(){
        return " ID - " + contactID +", Contact info (Name: " + firstName + " " + lastName +  ", Number: " + Number + ", Address: " + Address + ")";
    }
}