package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class MapDemo {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10,1,2,3,4};
		
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
		System.out.println();
		
		Arrays.stream(arr).map(a -> a * a).forEach(a -> System.out.print(a + " "));
		System.out.println();
		
		Arrays.stream(arr).distinct().forEach(a -> System.out.print(a + " "));
		System.out.println();
		
		List<Employee> list = List.of(
				new Employee(101, "raj",29, 49000),
				new Employee(102, "Abhi",25, 78000),
				new Employee(103, "Goutam",40, 63000),
				new Employee(104, "Jay",39, 50000),
				new Employee(105, "rajesh",20, 41000));
	
		list.stream().forEach(a -> System.out.println(a));

		// update data
		
		list.stream()
			.map(a -> {a.setAge(a.getAge() + 1); return a;})
			.forEach(a -> System.out.println(a));
		
		list.stream()
			.filter(a -> a.getSalary() > 60000)
			.map(a -> {a.setSalary(a.getSalary() + (a.getSalary() * 0.1)); return a;})
			.forEach(a -> System.out.println(a));
		
		
		list.stream()
			.filter(a -> a.getName().startsWith("A"))
			.map(a -> {a.setSalary(a.getSalary() + 500.0); return a;})
			.forEach(a -> System.out.println(a));

		// Apply limit and print data
		
		list.stream()
			.limit(2)
			.forEach(a -> System.out.println(a));
	 
		// skip data
		
		list.stream()
			.skip(3)
			.forEach(a -> System.out.println(a));
	}
}
