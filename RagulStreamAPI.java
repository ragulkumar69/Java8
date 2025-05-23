package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RagulStreamAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ListOfInteger = new ArrayList<>(Arrays.asList(1,2,3,11,12,4,5,8,6,7,8,9,10));
	    System.out.println("=============================================Number===================================================================");
        
        Map<Boolean, List<Integer>> oddEven = ListOfInteger.stream().collect(Collectors.partitioningBy(num -> num%2 == 0));
        System.out.println("oddEven: "+oddEven); 	// oddEven: {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
	
	    List<Integer> removeDuplicate = ListOfInteger.stream().distinct().collect(Collectors.toList());
	    System.out.println("removeDuplicate: "+removeDuplicate); //	removeDuplicate: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	    
	    List<Integer> ascendingOrder = ListOfInteger.stream().sorted().collect(Collectors.toList());
	    System.out.println("ascendingOrder: "+ascendingOrder); //	ascendingOrder: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	    
	    List<Integer> descendingOrder = ListOfInteger.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	    System.out.println("descendingOrder: "+descendingOrder); //	descendingOrder: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
	    
	    List<Integer> findMultipleOf5 = ListOfInteger.stream().filter(num -> num%5 == 0).collect(Collectors.toList());
	    System.out.println("findMultipleOf5: "+findMultipleOf5); //	findMultipleOf5: [5, 10]
	    
	    Integer findMax = ListOfInteger.stream().max(Comparator.naturalOrder()).get();
	    System.out.println("findMax: "+findMax); //	findMax: 10
	    
	    List<Integer> findMax2 = ListOfInteger.stream().sorted(Comparator.reverseOrder()).limit(2).collect(Collectors.toList());
	    System.out.println("findMax2: "+findMax2); //	findMax2: [10, 9]
	    
	    Integer findMin = ListOfInteger.stream().min(Comparator.naturalOrder()).get();
	    System.out.println("findMin: "+findMin); //	findMin: 1
	    
	    List<Integer> findMin2 = ListOfInteger.stream().sorted().limit(2).collect(Collectors.toList());
	    System.out.println("findMin2: "+findMin2); //	findMin2: [1, 2]
	    
	    Optional<Integer> findsecondMax = ListOfInteger.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
	    System.out.println("findsecondMax: "+findsecondMax); //	findsecondMax: Optional[9]
	    
	    List<Integer> findTop3MaxNumber = ListOfInteger.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
	    System.out.println("findTop3MaxNumber: "+findTop3MaxNumber); //	findTop3MaxNumber: [10, 9, 8]
	    
	    Integer SumOfEvenNum = ListOfInteger.stream().filter(num -> num%2 == 0).mapToInt(c -> c).sum();
	    System.out.println("SumOfEvenNum: "+SumOfEvenNum); //	SumOfEvenNum: 30
	    
	    //Integer secondlargest = ListOfInteger.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	    //System.out.println("secondlargest: "+secondlargest);  //	secondlargest: 9
	    
	    List<Integer> square = ListOfInteger.stream().map(n -> n*n).collect(Collectors.toList());
	    System.out.println("square: "+square);  //	square: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
	    
	    //================================================================================================================
	    System.out.println("======================================================String==========================================================");
	    List<String> ListOfString = new ArrayList<>(Arrays.asList("apple","banana","orange","apple","grapes","Kiwi"));
        
        List<Integer> LengthOfString = ListOfString.stream().map( len -> len.length()).collect(Collectors.toList());
        System.out.println("LengthOfString: "+LengthOfString);
        
        List<String> GreaterThen5 = ListOfString.stream().filter(len -> len.length() > 5).collect(Collectors.toList());
        System.out.println("GreaterThen5: "+GreaterThen5);
        
        List<Integer> GreaterThen5WithFilterAndMap = ListOfString.stream().filter( str -> str.length() > 5).map( str -> str.length()).collect(Collectors.toList());
        System.out.println("GreaterThen5WithFilterAndMap: "+GreaterThen5WithFilterAndMap);
        
        Long CountGreaterThen5 = ListOfString.stream().filter( str -> str.length() > 5).count();
        System.out.println("CountGreaterThen5: "+CountGreaterThen5);
        
        List<String> UpperCase = ListOfString.stream().map(str ->str.toUpperCase()).collect(Collectors.toList());
        System.out.println("UpperCase: "+UpperCase);
        
        List<String> Vowels = ListOfString.stream().filter( str -> str.length() > 5 && "aeiouAEIOU".indexOf(str.charAt(0))!= -1).collect(Collectors.toList());
        System.out.println("Vowels: "+Vowels);
        
        String longestString = ListOfString.stream().distinct().max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("longestString: "+longestString);
        
        Map<Character, Long> frequencyOfCharacter = ListOfString.stream().flatMap(str -> str.chars().mapToObj(c -> (char) c)).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("frequencyOfCharacter: "+frequencyOfCharacter);
	    
        String SeparatedByCommas = ListOfString.stream().collect(Collectors.joining(",","{","}"));
        System.out.println("SeparatedByCommas: "+SeparatedByCommas);
        
        Map<Integer, List<String>> GroupStringsByLength = ListOfString.stream().collect(Collectors.groupingBy(str->str.length()));
        System.out.println("GroupStringsByLength: "+GroupStringsByLength);
	    
	    
	}

}
