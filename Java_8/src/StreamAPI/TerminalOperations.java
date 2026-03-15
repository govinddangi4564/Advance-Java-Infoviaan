package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperations {
	public static void main(String[] args) {

		List<Employee> list = List.of(new Employee(101, "raj", 29, 49000), new Employee(102, "Abhi", 25, 78000),
				new Employee(103, "Goutam", 40, 63000), new Employee(104, "Jay", 39, 50000),
				new Employee(105, "rajesh", 20, 41000));

		List<Employee> collect = list.stream().filter(a -> a.getAge() > 35).collect(Collectors.toList());
		collect.forEach(a -> System.out.println(a));

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4 };

		int[] evenArray = Arrays.stream(arr).filter(a -> a % 2 == 0).toArray();
		System.out.println(Arrays.toString(evenArray));

		int sum = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
		System.out.println("Sum = " + sum);

		int multiply = Arrays.stream(arr).reduce(1, (a, b) -> a * b);
		System.out.println("Multiplication = " + multiply);
	}
}
