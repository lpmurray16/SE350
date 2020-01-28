package hw3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static hw3.fp.*;
import static org.junit.Assert.assertTrue;

public class fpTEST {
    // (1) Use map to implement the following behavior (described in Python). 
    //		 i.e given a List<T> create a List<Integer> of the hashes of the objects. names = ['Mary', 'Isla', 'Sam']
    //		 for i in range(len(names)):
    //		 names[i] = hash(names[i])
    @Test
    public void testMap() {
        List<String> names = Arrays.asList("Bob", "Angela", "Toby");
        assertTrue(names.size() == 3 && names.get(names.size()-1) == "Toby");
        List<Integer> hashList = map(names, (String elem) -> elem.hashCode());
        // expected [66965, 1965651104, 2612274] based on print statement
        assertTrue(66965 == hashList.get(0) && hashList.get(1) == 1965651104);
    }
/*
    (2) Use foldleft to calculate the sum of a list of integers.
    i.e write a method: int sum(List<Integer> l)
    IN PROGRESS
*/
    @Test
    public void testFoldLeft(){
        List<Integer> intList = new ArrayList<>();
        intList.add(2);
        intList.add(3);
        intList.add(5);
        intList.add(1);
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> {
            return a+b;
        };
        int resSum = foldLeft(0, intList, sum);
        assertTrue(resSum==11);
    }
/*
    (3) Use foldRight to concatenate a list of strings i.e write a method
    String s (List<String> l)
    IN PROGRESS
*/
    @Test
    public void testFoldRight(){
        List<String> strList = new ArrayList<>();
        strList.add("My ");
        strList.add("Name ");
        strList.add("is ");
        strList.add("Logan ");
        BiFunction<String, String, String> concat = (a, b) -> {
            return a + b;
        };
        String resStr = foldRight("", strList, concat);
        assertTrue(resStr.equals("Logan is Name My "));
    }

/*
(4) consider an array of Persons. Use filter to
    print the names of the Persons whose salary is
    greater than 100000
*/
    @Test
    public void testFilter(){
        List<Person> per = new ArrayList<Person>();
        per.add(new Person(30000, "Jon Bob"));
        per.add(new Person(120000, "Logan M"));
        per.add(new Person(140000, "Haylee K"));
        per.add(new Person(60000, "Percy W"));
        assertTrue(per.size()==4);

        List<Person> testResult = (List<Person>) filter(per, (person) -> person.getSalary() > 100000);
        assertTrue(testResult.size()==2);
        System.out.println(testResult.toString());
    }

//(5) Use minVal to calculate the minimum of a List of Integers
    @Test
    public void testMinVal(){
        List<Integer> intList = Arrays.asList(3,4,6,1,3,5,8,9,23,4);
        int res = minVal(intList);
        assertTrue(res==1);
    }
/*
(6) Use maxVal to calculate the maximum of a List of Integers
*/
    @Test
    public void testMaxVal(){
        List<Integer> intList = Arrays.asList(3,4,6,1,3,5,8,9,23,4);
        int res = maxVal(intList);
        assertTrue(res==23);
    }
/*
(7) Use minPos to calculate the position of the
    minimum in  a List of  Integers
*/
    @Test
    public void testMinPos(){
        /*
        (8)  Use minPos to calculate the position of the
        minimum in  a List of  String
        */
        List<Integer> intList = Arrays.asList(3,4,6,1,3,5,8,9,23,4);
        int resPos = minPos(intList);
        assertTrue(resPos==3);


        List<String> strList = Arrays.asList("Cap", "Zack", "Pat", "Aardvark", "Griswold");
        int resPosStr = minPos(strList);
        assertTrue(resPosStr==3);

    }

}
