package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class Task1 {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		
		List<Employee> list = List.of(
				new Employee(101, "raj",29, 49000),
				new Employee(102, "Abhi",25, 78000),
				new Employee(103, "Goutam",40, 63000),
				new Employee(104, "Jay",39, 50000),
				new Employee(105, "rajesh",20, 41000));
		
		list.stream().forEach(a -> System.out.println(a));
		
		System.out.println("--------------------------------------------------------------------");
		
		list.stream().filter(a -> a.getName().startsWith("A")).forEach(a -> System.out.println(a));
		System.out.println("----------------------------------------------------------------------");
		list.stream().filter(a -> a.getAge() > 35).forEach(a -> System.out.println(a));
		System.out.println("----------------------------------------------------------------------");
		list.stream().filter(a -> a.getSalary() > 50000).forEach(a -> System.out.println(a));
		System.out.println("----------------------------------------------------------------------");
		Arrays.stream(arr).filter(a -> a%2 != 0).forEach(a -> System.out.print(a + " "));
		System.out.println("----------------------------------------------------------------------");
//		Arrays.stream()
		
		
	}
}
