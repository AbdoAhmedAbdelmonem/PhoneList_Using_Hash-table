public class HashTable {
    private final int bucket = 1009;
    private final PhoneList[] table;

    public HashTable() {
        table = new PhoneList[bucket];
        for (int i = 0; i < bucket; i++) {
            table[i] = new PhoneList();
        }
    }

    public void insert(String name, String phone) {
        int index = (int) calc_hash(name);

        PhoneList bucketList = table[index];

        if (bucketList.IsinList(name)) {
            System.out.println("Contact with Name "+name+" Already inserted into the Hash Table 📲");
            System.out.println();
        } else {
            bucketList.AddContact(name, phone);
        }
    }

    public void update(String name, String phone) {
        int index = (int) calc_hash(name);
        PhoneList bucketList = table[index];
        if (bucketList.IsinList(name)) {
            bucketList.update(name,phone);
        }
    }

    public void delete(String name) {
        int index = (int) calc_hash(name);
        PhoneList bucketList = table[index];
        if (bucketList.IsinList(name)) {
            bucketList.DeleteContent(name);
        }else{
            System.out.println("Contact With Name "+name+" Not in Hash Table ⚠️");
        }
    }
    public void Search(String name) {
        int index = (int) calc_hash(name);
        PhoneList bucketList = table[index];
        bucketList.Search(name);
    }

    public void printHashTable() {
        for (int i = 0; i < bucket; i++) {
            PhoneList bucketList = table[i];
            if (bucketList == null || bucketList.isEmpty()) {
                continue;
            } else {
                System.out.print(i);
                bucketList.Display();
            }
            System.out.println();
        }
    }



    public static long calc_hash(String key) {
        int i, l = key.length();
        long hash = 0;

        for (i = 0; i < l; i++) {
            hash += Character.getNumericValue(key.charAt(i));
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);

        if (hash > 0) return hash % 1009;
        else return -hash % 1009;
    }

}
