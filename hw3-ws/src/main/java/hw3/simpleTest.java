package hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class simpleTest {
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        System.out.println(temp);
        Collections.reverse(temp);
        System.out.println(temp);
    }
}
