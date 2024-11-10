public class ContactNode {
    public String firstName;
    public String phoneNumber;
    public ContactNode next = null;

    public ContactNode(String firstName, String phoneNumber, ContactNode next) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.next = next;
    }
    public ContactNode(String firstName, String phoneNumber) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }
}
