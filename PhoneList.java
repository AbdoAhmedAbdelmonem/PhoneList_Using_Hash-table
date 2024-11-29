public class PhoneList {
    public  ContactNode head;

    public PhoneList(){
        head = null;
    }

    public void AddContact(String name, String phone) {
        ContactNode newNode = new ContactNode(name, phone);
        if (IsinListN(name)) {
            System.out.println("Phone Contact with Name " + name + " already exists 🙆‍♂️👀");
            System.out.println();
            return;
        }
        if (IsinListP(phone)){
            System.out.println("Phone Contact with PhoneNumber " + phone + " already exists  🥲");
            System.out.println();
            return;
        }
        if (head == null) {
            head = newNode;
        } else {
            ContactNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Contact With Name "+name+" added successfully.🤩✅");
        System.out.println();
    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Empty List");
        } else {
            ContactNode current = head;
            while (current != null) {
                System.out.print(" --> [ Name: " + current.firstName + ", PhoneNumber: " + current.phoneNumber + "]");
                current = current.next;
            }
            System.out.println();
        }
    }
    public void update(String oldName, String NewPhoneNumber) {
        ContactNode current = head;
        boolean updated = false;
        while (current != null) {
            if (current.firstName.equals(oldName)) {
                current.phoneNumber = NewPhoneNumber;
                System.out.println("Phone Contact with Name " + oldName + " updated successfully. 😍");
                System.out.println("New Phone Number: " + NewPhoneNumber+" ⚡");
                System.out.println();
                updated = true;
            }
            current = current.next;
        }
        if (!updated) {
            System.out.println("Phone Contact with Name " + oldName + " not found. 😞");
        }
    }

    public void Search(String name) {
        ContactNode current = head;
        boolean found = false;
        if (isEmpty()) {
            System.out.println("No contacts found With Name " + name +" ⚠️") ;
        } else {
            while (current != null) {
                if (current.firstName.equals(name)) {
                    System.out.println("Contact found 🙈");
                    System.out.println("[ Name: " + current.firstName + ", PhoneNumber: " + current.phoneNumber + "] ");
                    System.out.println();
                    found = true;
                    break;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("There is no such contact with this name. 🥲");
            }
        }
    }

    public void DeleteContent(String name) {
        if (isEmpty()) {
            System.out.println("No contacts found for Deleting 😡!!");
            System.out.println();
        } else {
            if (head.firstName.equals(name)) {
                head = head.next;
                System.out.println("Contact With Name "+name+" removed successfully.🗑️🚮");
                System.out.println();
                return;
            }

            ContactNode current = head;
            while (current.next != null) {
                if (current.next.firstName.equals(name)) {
                    current.next = current.next.next;
                    System.out.println("Contact With Name "+name+" removed successfully.🗑️🚮");
                    System.out.println();
                    return;
                }
                current = current.next;
            }
            System.out.println("Contact not found.😟");
            System.out.println();
        }
    }


    public boolean isEmpty(){
        return head == null;
    }

    public boolean IsinListN( String name ){
        ContactNode current = head;
        while(current != null){
            if(current.firstName.equals(name)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public boolean IsinListP( String phone ){
        ContactNode current = head;
        while(current != null){
            if(current.phoneNumber.equals(phone)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
