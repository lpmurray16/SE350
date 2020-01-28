package hw3;

import java.util.*;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class fp {
	
static <U,V> List<V> map(Iterable<U> someList, Function<U,V> func) {
	List<V> temp = new ArrayList<V>();
	for (U elem: someList) {
		//some new V = func.apply(elem) and then..
		V tv = func.apply(elem);
		//add the new V to temp List
		temp.add(tv);
	}
	//return temp List
	return temp;
}


static <U,V> V foldLeft(V someV, Iterable<U> someList, BiFunction<V,U,V> func){
	for(U elem: someList){
		someV = func.apply(someV, elem);
	}
	return someV;
}




static <U,V> V foldRight(V someV, Iterable<U> someList, BiFunction<U,V,V> func) {
	for(U elem: someList){
		someV = func.apply(elem, someV);
	}
	return someV;
}


static <U> Iterable<U> filter(Iterable<U> someList, Predicate<U> p){

	List<U> res = new ArrayList<U>();
	for(U elem: someList){
		 boolean ToF = p.test(elem);
		 if(ToF == true){
		 	res.add(elem);
		 }
	}
	return res;
}


static <U> U minVal(Iterable<U> someList){
	List<U> temp = new ArrayList<U>();
	for(U elem: someList){
		temp.add(elem);
	}
	Collections.sort(temp, null);
	return temp.get(0);
}

static <U> U maxVal(Iterable<U> someList){
	List<U> temp = new ArrayList<U>();
	for(U elem: someList){
		temp.add(elem);
	}
	Collections.sort(temp, null);
	return temp.get(temp.size()-1);
}

static <U extends Comparable<U>> int minPos(Iterable<U> someList){
	BiFunction<Integer, U, Integer> minPosition = (a, b)->{
		ArrayList<U> temp = new ArrayList<>();
		someList.forEach(temp::add);
		if(temp.get(a).compareTo(b) < 0){
			return a;
		} else if (temp.get(a).compareTo(b) > 0){
			return temp.indexOf(b);
		} else {
			return a;
		}
	};

	int res = foldLeft(0, someList, minPosition);
	return res;
}

	public static void main(String[] args) {

		// ALL TEST IN TEST FILE (fpTEST.java)

	}

}

class Person{
	final int salary;
	final String name;
	
	Person(int salary, String name){
		this.salary = salary;
		this.name = name;
	}
	
	int getSalary() { return salary; }
	String name() { return name;}

	@Override
	public String toString() {
		return "Person{" +
				"salary=" + salary +
				", name='" + name + '\'' +
				'}';
	}
}