public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Clown 🤡 !");
        HashTable hashTable = new HashTable();
        hashTable.insert("Alice","0122");
        hashTable.insert("Alice","0123");
        hashTable.insert("Adel","01234");
        hashTable.printHashTable();
        hashTable.delete("Adel");
        hashTable.printHashTable();
        hashTable.Search("Alice");
    }
}