package string;

import java.util.ArrayList;
import java.util.List;

public class StringPractice {

    private List<Integer> data;

    public StringPractice() {
        data = new ArrayList<>();
    }

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        String rtn = "";
        for(int i : data) {
            rtn += 1;
        }
        return rtn;
    }


}

// wrapper class : In OOP, primitype (int) -> wrapper (Integer)
// wrapper when primitive is not usable

//stack is faster (only current function uses it)than heap but very small

// array vs arraylist :