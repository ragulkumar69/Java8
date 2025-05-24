package com.java8.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamFunctions {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		List<Integer> num1 = Arrays.asList(2,3,5,3,18,9,22,11,9);
		List<String> fruits = Arrays.asList("Mango","Apple","Banana","Kiwi","pineapple");
		List<String> flats = Arrays.asList("A11","A12","B10","a15","a17");
//		num1.add(5);
		
		//Odd Numbers
		List<Integer> num1Test = num1.stream().filter(n -> n%2 != 0).collect(Collectors.toList());
		System.out.println("Odd Numbers "+num1Test); //Odd Numbers [3, 5, 3, 9, 11, 9]
		// removing duplicate
		List<Integer> num1Dup = num1.stream().filter(n -> n%2 != 0).distinct().collect(Collectors.toList());
		System.out.println("Odd Numbers without duplicate "+num1Dup); //Odd Numbers without duplicate [3, 5, 9, 11]
		//length of the every fruit
		System.out.println("Length of the fruit "+fruits.stream().map(f -> f.length()).collect(Collectors.toList())); //Length of the fruit [5, 5, 6, 4, 9]
		//print only those fruits where length is greater then 5
		System.out.println("Length of the fruit is 5 in String "+fruits.stream().filter(f -> f.length() >5).collect(Collectors.toList())); //Length of the fruit is 5 in String [Banana, pineapple]
		//print only those fruits where length is greater then 5 in number (using .filter & .map)
		System.out.println("Length of the fruit is 5 in num "+fruits.stream().filter(f -> f.length()>5).map(fr -> fr.length()).collect(Collectors.toList())); //Length of the fruit is 5 in num [6, 9]
		//.count() to check how many fruits create then 5
		System.out.println("How many fruit are greater then 5 count "+fruits.stream().filter(f -> f.length()>5).count()); //How many fruit are greater then 5 count 2
		
		//Sorting .sorted()
		//Ascending
		System.out.println("Sorted "+num1.stream().sorted().collect(Collectors.toList())); //Sorted [2, 3, 3, 5, 9, 9, 11, 18, 22]
		//Custom Ascending
		System.out.println("Custom Ascending Sorted "+num1.stream().sorted((num, num2) -> num.compareTo(num2) ).collect(Collectors.toList()));  //Custom Ascending Sorted [2, 3, 3, 5, 9, 9, 11, 18, 22]
		//custom Descending
		System.out.println("Custom Descending Sorted "+num1.stream().sorted((num, num2) -> num2.compareTo(num) ).collect(Collectors.toList())); //Custom Descending Sorted [22, 18, 11, 9, 9, 5, 3, 3, 2]
		
		//find value with char
		System.out.println("Flats start with A "+flats.stream().filter(f -> f.startsWith("A")).collect(Collectors.toList())); //Flats start with A [A11, A12]
		//uppercase
		System.out.println("Flats start with A with uppercase "+flats.stream().map(f -> f.toUpperCase()).filter(f -> f.startsWith("A")).collect(Collectors.toList()));
//		Flats start with A with uppercase [A11, A12, A15, A17]
		
		Map<String, Integer> map = new HashMap<>();
		map.put(null, null);
		
		Set<String> set = new HashSet<>();
		set.add(null);
		
		
	}

}
