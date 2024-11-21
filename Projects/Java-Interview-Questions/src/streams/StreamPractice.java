package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,2,3,4,23,22,54,66,7,4,8};
		List<Integer> numbers = Arrays.asList(1,2,3,4,23,22,54,66,7,4,8);
		
		
		//1:Print Odd Numbers Using Streams
		System.out.println("\n---Odd Numbers---");
		numbers.stream().filter((x) -> x%2 == 1).map((x) -> Integer.toString(x)+" ").forEach(System.out::print);
		
		//2:Print all courses individually
		System.out.println("\n---Courses---");
		List<String> courses = Arrays.asList("Spring", 
				"Spring Boot", "API" , 
				"Microservices", "AWS", "PCF",
				"Azure", "Docker", "Kubernetes");
		courses.stream().forEach((course) -> System.out.print(course+", "));

		
		//3:Print the courses containing spring
		System.out.println("\n---Course Containing Spring---");
		courses.stream().filter(course -> course.contains("Spring")).forEach((course) -> System.out.print(course+", "));
		
		//4:Print Courses Whose Name has atleast 4 letters
		System.out.println("\n---Course of length 4---");
		courses.stream().filter(course -> course.length() >= 4).forEach((course) -> System.out.print(course+", "));
	
		//5:Print the cubes of odd numbers
		System.out.println("\n---Cube of odd numbers---");
		numbers.stream().filter((x) -> x%2 == 1).map((x) -> x*x*x).forEach((num) -> System.out.print(num+" "));
	
		
		//6:Print the number of characters in each course name
		System.out.println("\n---No of char in each course---");
		courses.stream().forEach((course) -> System.out.print(course.length()+", "));
		
		
		//7:Square every number in a list and find the sum of squares
		System.out.println("\n---Square and Sum of Squares---");
		int squareSum = numbers.stream().map((x) -> x*x).reduce(0,Integer::sum);
		System.out.println(squareSum);
		
		//8:Cube every number in a list and find the sum of cubes
		System.out.println("\n---Cube and Sum of Cubes---");
		int cubeSum = numbers.stream().map((x) -> x*x*x).reduce(0,Integer::sum);
		System.out.println(cubeSum);
		
		
		//9:Find Sum of Odd Numbers in a list
		System.out.println("\n---Sum of Odd Numbers---");
		int oddSum = numbers.stream().filter(x -> x%2 == 1).reduce(0,Integer::sum);
		System.out.println(oddSum);
		
		//10:Create a List with Even Numbers Filtered from the Numbers List
		System.out.println("\n---List with even no filtered---");
		List<Integer> evenNumbers = numbers.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);
		
		//11:Create a List with lengths of all course titles.
		System.out.println("\n---Length of char in each course as list---");
		List<Integer> courseLength = courses.stream().map(course -> course.length()).collect(Collectors.toList());
		
		
		//12:Find Functional Interface behind the second argument of reduce method. Create an implementation for the Functional Interface.
		//12:int sum = numbers.stream() .reduce(0, Integer::sum);
		System.out.println("\n---Functional Interface Implementation---");
		int sum = numbers.stream() .reduce(0, (a,b) -> a+b);
		System.out.println("Fn Interface Sum: "+sum);
		
		//13:Do Behavior Parameterization for the mapping logic.
		//List squaredNumbers = ;
		Function<Integer,Integer> cubeNumber = (x)-> x*x*x;
		List<Integer> squaredNumbers = mapAndCreateNewList(numbers,(x) -> x*x);
		List<Integer> cubedNumbers = mapAndCreateNewList(numbers,cubeNumber);
		System.out.println(squaredNumbers);
		System.out.println(cubedNumbers);
		//-------------------------------------------
		//Streams Interview Questions
		
		//14:Seperate Odd and Even Numbers
		System.out.println("\n---Even and Odd Numbers---");
		List<Integer> newNums = Arrays.asList(1,23,4,6,77,44,90,3,7,9,2,4,8);
		Map<Boolean,List<Integer>> res = newNums.stream().collect(Collectors.partitioningBy(i -> i%2 == 0));
		System.out.println(res);
		
		//15:Frequency of Each Character In String
		System.out.println("\n---Freq of each char---");
		String str = "Spring Boot";
		Map<Character,Long> freq = str.chars().mapToObj(c -> (char)c)
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(freq);
		
		
		//16:Sort the list in reverseorder
		System.out.println("\n---List Reverse---");
		newNums.stream().sorted(Comparator.reverseOrder()).forEach((n) -> System.out.print(n+" "));
		
		//17:Print Multiple of 5 from list
		System.out.println("\n---Multiple of 5 in list---");
		
		newNums.stream().filter(n -> n%5 == 0).forEach((n) -> System.out.print(n+" "));
		
		//18:Merge Two Unsorted Arrays Into Single Sorted Array
		System.out.println("\n---Merge 2 Sorted Array---");
		int[] arr1 = {1,2,3,4,5,6,7};
		int[] arr2 = {1,2,3,4,5,6,7};
		int[] mergedArr = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2))
				.sorted().toArray();
		System.out.println(Arrays.asList(mergedArr));
		
		//19:Merge Two Unsorted Arrays Into Single Sorted Array Without Duplicates
		System.out.println("\n---Merge 2 Sorted Array Without Duplicates---");
		int[] arr3 = {1,2,3,4,5,6,7};
		int[] arr4 = {1,2,3,4,5,6,7};
		int[] mergedArr1 = IntStream.concat(Arrays.stream(arr3),Arrays.stream(arr4))
				.sorted().distinct().toArray();
		System.out.println(Arrays.asList(mergedArr1));
		
		
		//20:
		
//		Function<Integer,Integer> fn = (x) -> x*x;
//		Predicate<Integer> pr = (x) -> x==0;
//		
//		Supplier<Integer> sp = (d) -> d;
//		
//		BinaryOperator<Integer> bi = new BinaryOperator<>() {
//			
//		};
		
		UnaryOperator<Integer> un = new UnaryOperator();
		BiConsumer<Integer,Integer> bic = new BiConsumer<>();
	
		
		
		Collections
	}
	public static List<Integer> mapAndCreateNewList(List<Integer> numbers,Function<Integer,Integer> function) {
		return numbers.stream().map(function).collect(Collectors.toList());
	}

}
