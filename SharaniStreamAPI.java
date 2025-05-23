package com.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class SharaniStreamAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ListOfInteger = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        List<String> ListOfString = new ArrayList<>(Arrays.asList("apple","banana","orange","apple","grapes"));
        SharaniStreamAPI streamapi = new SharaniStreamAPI();
        
        Map<Boolean, List<Integer>> oddNumberss = ListOfInteger.stream().collect(Collectors.partitioningBy(num -> num%2 == 0));
        System.out.println("oddNumberss: "+oddNumberss);
        
        List<Integer> oddNumbers = streamapi.seperateOddEven(ListOfInteger);
        System.out.println("oddNumbers" +oddNumbers); //{false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
        
        ListOfInteger.stream().filter(n->n%2!=0).forEach(System.out::println); //1, 3, 5, 7, 9
        
        List<Integer>  removeduplicate= streamapi.removingduplicate(ListOfInteger);
        System.out.println("removeduplicate" +removeduplicate); //removeduplicate[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        
        List<Integer>  ascendingOrder= streamapi.ascendingOrder(ListOfInteger);
        System.out.println("ascendingOrder" +ascendingOrder); //ascendingOrder[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        
        List<Integer>  descendingOrder= streamapi.descendingOrder(ListOfInteger);
        System.out.println("descendingOrder " +descendingOrder); //descendingOrder [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        
        System.out.println("findMultipleOf5 " +streamapi.findMultipleOf5(ListOfInteger)); //findMultipleOf5 [5, 10]
        
        System.out.println("findMax " +streamapi.findMax(ListOfInteger)); // findMax 10
        System.out.println("findMax2 " +streamapi.findMax2(ListOfInteger)); // findMax2 10
        System.out.println("findMin2 " +streamapi.findMin2(ListOfInteger));
        System.out.println("findMin " +streamapi.findMin(ListOfInteger)); //findMin 1
        System.out.println("findsecondMax " +streamapi.findsecondMax(ListOfInteger)); // findsecondMax 2
        System.out.println("findTop3MaxNumber " +streamapi.findTop3MaxNumber(ListOfInteger)); //findTop3MaxNumber [10, 9, 8]
        System.out.println("SumOfEvenNum " +streamapi.SumOfEvenNum(ListOfInteger)); //SumOfEvenNum 30
        System.out.println("secondlargest " +streamapi.secondlargest(ListOfInteger)); //secondlargest 9
        System.out.println("largest " +streamapi.largest(ListOfInteger)); //largest 10
        System.out.println("square " +streamapi.square(ListOfInteger)); //square [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
	}
        public List<Integer> seperateOddEven(List<Integer> ListOfInteger) {
    		return ListOfInteger.stream().collect(Collectors.partitioningBy(n->n%2==0)).get(false);
    	    
    	}
    	public List<Integer> removingduplicate(List<Integer> ListOfInteger){
    		return ListOfInteger.stream().distinct().collect(Collectors.toList());
    	}
    	public List<Integer> ascendingOrder(List<Integer> ListOfInteger){
    	  return ListOfInteger.stream().sorted().collect(Collectors.toList());
        }
    	public List<Integer> descendingOrder(List<Integer> ListOfInteger){
    		return ListOfInteger.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    	}
    	public List<Integer> findMultipleOf5(List<Integer> ListOfInteger){
    		return ListOfInteger.stream().filter(m->m%5==0).collect(Collectors.toList());
    	}
    	public int findMax(List<Integer> ListOfInteger) {
    		return ListOfInteger.stream().max(Comparator.naturalOrder()).get();
    		
    	}
    	public int findMax2(List<Integer> ListOfInteger) {
    		return ListOfInteger.stream().max(Integer::compareTo).orElseThrow(null);
    		
    	}
    	public int findMin(List<Integer> ListOfInteger) {
    		return ListOfInteger.stream().min(Integer::compareTo).get();
    		
    	}
    	public int findMin2(List<Integer> ListOfInteger) {
    		return ListOfInteger.stream().sorted().findFirst().get();
    		
    	}
    	public int findsecondMax(List<Integer> ListOfInteger) {
    		return ListOfInteger.stream().distinct().sorted().skip(1).findFirst().get(); //for min make sorted(Comparator.naturalOrder)
    	}
        public List<Integer> findTop3MaxNumber(List<Integer> ListOfInteger) {
            return 	ListOfInteger.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        }
        
        //squaring the number and also remove the duplicates
        public List<Integer> square(List<Integer> ListOfInteger) {
            //ListOfInteger.stream().distinct().sorted().mapToInt(i->i*i).forEach(System.out::println);
            return ListOfInteger.stream().distinct().sorted().map(i->i*i).collect(Collectors.toList());
        }
        
        
        //maxnumber
        public int largest(List<Integer> ListOfInteger) {
        	//return ListOfInteger.stream().distinct().sorted(Comparator.reverseOrder()).findFirst().get();
            return ListOfInteger.stream().max(Comparator.naturalOrder()).get();
        }
        
        //second largest number
        public int secondlargest(List<Integer> ListOfInteger) {
        	return ListOfInteger.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        }
        //sum of the even number
        public int SumOfEvenNum(List<Integer> ListOfInteger){
        	return ListOfInteger.stream().filter(i->i%2==0).mapToInt(Integer::intValue).sum();
        }
}
