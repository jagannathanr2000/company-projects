package exceptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class AirPlane {
	AirPlane() throws IOException {
		System.out.println("AirPlane");
		throw new IOException();
	}
}
public class AirJet extends AirPlane{
	
	AirJet() throws IOException {
		super();
		
	}
	public static void main(String[] args) {
		int[] numbers = {1,2,4};
//		Stream<Integer> intStream = IntStream.range(0,10).collect(Collectors.toList()).stream();
//		int sum = Integer::SUM;
		try {
			AirJet jet = new AirJet();
		} catch(IOException e) {
			System.out.println("IO Exception while creating object AirJet");
//			Stream.of(numbers[0],numbers[1]);
//			Arrays.stream(numbers);
//			Stream<String> emptyStream = Stream.empty();
		}
		
		
	}
}

