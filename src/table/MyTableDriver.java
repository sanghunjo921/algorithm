package table;

public class MyTableDriver {



    public static void main(String[] args) {
        HashTable<String> table = new HashTable<String>();
        table.put("1", "dog");
        table.put("2","cat");
        table.put("3", "pig");
        table.put("4", "horse");
        System.out.println(table.remove("1"));
        System.out.println(table);

//        table.remove("1");

    }
}
