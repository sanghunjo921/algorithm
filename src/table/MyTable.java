package table;

public interface  MyTable<T> {


     void put (String key, T value);

     T remove(String key);

    T get(String key);


}
