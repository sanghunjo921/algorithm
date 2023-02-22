package string;

import java.util.ArrayList;

public class MyStringBuilder {
    char[] data;
    int size ;  // 5 0 ~4

    private void increase() {
        increase(size * 2);
    }
    public MyStringBuilder(int size) {
        data = new char[size];
    }

    public MyStringBuilder() {
        this(5);
    }

    private void increase(int totalSize) {
//        char [] ns = data;
//        size += size;
//        data = new char[size];
//        for(int i = 0 ; i < ns.length; i ++) {
//            data[i] = ns[i];
//        }
        char [] ns = new char[totalSize];
        for(int i = 0 ; i < size ; i++) {
            ns[i] = data[i];
        }
        data = ns;
        ns = null;
    }

    MyStringBuilder append(String s) {

       for(char c : s.toCharArray()) {
           if(size == data.length) {
               increase();
           }
           data[size++] = c;
       }
        return this;
    }

//    MyStringBuilder delete(int start, int end) {
//        for(int i = start; )
//    }


    MyStringBuilder replace(int start , int end, String str) {
        if(end-start != str.length()) {
            return null;
        }
        int j = 0;
        for(int i = start ; i < end ; i ++) {
                data[i] = str.charAt(j++);
        }
        return this;
    }

     boolean isPermuted(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] arr = new int[26];

        for (char c : str1.toCharArray()) {
            int index = c-97;
            arr[index]++;
        }

        for (char c : str2.toCharArray()) {
           int index = c-97;
           arr[index]--;
            if (arr[index] <0) {
               return false;
           }
        }
        return true;
    }




    MyStringBuilder insert(int index, String str) {
// abc
//        for(char c: str.toCharArray()) {
//            for(int i = size-1; i >= index ; i--) {
//                char temp = data[i];
//
//                data[i+1 ] = temp;
//                data[i] = c;
//            }
//            index ++;
//        }
        int totalSize = size + str.length();
        if(data.length <= totalSize) {
            increase(totalSize);
        }
        int i = totalSize -1;
        for(; i >= index + str.length(); i-- ){
            int idx = i-str.length();
            data[i] =  data[idx];
        }
        int strSize = str.length();
        for(;i >= index; i-- ) {
            data[i] = str.charAt(strSize--);
        }

        return this;
    }






    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("abc");
        sb.append("123");
        sb.append("abc").append("123");
    }
}
