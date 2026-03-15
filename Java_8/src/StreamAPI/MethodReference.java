package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {
	public static void main(String[] args) {
		
		// className::methodNAme :
		// object::methodName :
		// className:: -> String::new -> a-> new String(a) ->
		
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		
		Arrays.stream(arr).forEach(System.out::println);
		
		List<Employee> list = List.of(
				new Employee(101, "raj",29, 49000),
				new Employee(102, "Abhi",25, 78000),
				new Employee(103, "Goutam",40, 63000),
				new Employee(104, "Jay",39, 50000),
				new Employee(105, "rajesh",20, 41000));
		
		List<String> empName = list.stream()
									.map(Employee::getName)
									.map(String::toUpperCase)
									.collect(Collectors.toList());
		
		System.out.println(empName);
	}
}
