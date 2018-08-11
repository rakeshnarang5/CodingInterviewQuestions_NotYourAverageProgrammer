import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		// n
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i<=100;i++) {
			numbers.add(i);
		}
		printFizzBuzz(numbers);
	}

	// Time complexity: O(n*1) = O(n)
	// Space complexity: O(1)
	private static void printFizzBuzz(List<Integer> numbers) {
		for(Integer number : numbers) {
			determineAndPrintFizzBuzz(number);
		}
	}
	
	// Time complexity: O(1)
	private static void determineAndPrintFizzBuzz(Integer number) {
		if(number % 3 == 0 && number % 5 == 0)
			System.out.println("FizzBuzz");
		else if (number % 3 == 0)
			System.out.println("Fizz");
		else if (number % 5 == 0)
			System.out.println("Buzz");
		else
			System.out.println(number);
	}

}
