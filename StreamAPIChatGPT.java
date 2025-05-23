package com.java8.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPIChatGPT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Write a Stream API expression to filter even numbers, square them, and
		// collect the result into a list.
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> filterEvenSquare = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
		System.out.println("filterEvenSquare: "+filterEvenSquare);
		
		// Write a Stream API expression to find the frequency of each word and return
		// it as a Map<String, Long>.
		List<String> wordss = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
		Map<String, Long> frequencyOfEachWord = wordss.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("frequencyOfEachWord: "+frequencyOfEachWord);
		
		// Write a Stream API expression to create a single string that joins all words
		// in uppercase, separated by commas.
		List<String> words = Arrays.asList("one", "two", "three", "four", "five");
		String joinAllUppercase = words.stream().map(String::toUpperCase).collect(Collectors.joining(","));
		System.out.println("joinAllUppercase: "+joinAllUppercase); // Output: ONE,TWO,THREE,FOUR,FIVE

		// Write a Stream API expression to find and print the duplicate elements in the
		// list.
		List<Integer> numbersDup = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> uniqueNumber = new HashSet<Integer>();
		Set<Integer> FindDuplicateElements = numbersDup.stream().filter(num -> !uniqueNumber.add(num))
				.collect(Collectors.toSet());
		System.out.println("FindDuplicateElements: "+FindDuplicateElements);
		
		//Write a Stream API expression to find the square of each number and filter those whose square is greater than 20.
		List<Integer> sqNumbers = Arrays.asList(3, 9, 2, 8, 6, 5);
		List<Integer> SquareEachNumber = sqNumbers.stream().map(sq -> sq*sq).filter(sq -> sq > 20).collect(Collectors.toList());
		System.out.println("SquareEachNumber: "+SquareEachNumber);
		
//		Write a Stream API expression to remove duplicates and sort the names in alphabetical order.
		List<String> names = Arrays.asList("John", "Alice", "Bob", "John", "David", "Alice");
		List<String> removeDuplicatesAndSort = names.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("removeDuplicatesAndSort: "+removeDuplicatesAndSort);
		
		//Write a Stream API expression to partition the numbers into two groups:
		//one for even numbers, one for odd numbers
		List<Integer> numbersOE = Arrays.asList(4, 5, 6, 7, 8, 9, 10);
		Map<Boolean, List<Integer>> SplitOddEven = numbersOE.stream().collect(Collectors.partitioningBy(num -> num%2 == 0));
		System.out.println("SplitOddEven: "+SplitOddEven);
		
		//Write a Stream API expression to split all the sentences into words, flatten them into a single stream, convert them to lowercase, remove duplicates, and collect into a sorted list.
		List<String> sentences = Arrays.asList(
			    "Java is awesome",
			    "Stream API is powerful",
			    "I love programming"
			);
		List<String> SplitIntoWordsAndLowercase = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")).map(String::toLowerCase)).distinct().sorted().collect(Collectors.toList());
		System.out.println("SplitIntoWordsAndLowercase: "+SplitIntoWordsAndLowercase);
		
		
		
	}

}
