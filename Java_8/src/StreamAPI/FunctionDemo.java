package StreamAPI;

import java.util.function.Function;

public class FunctionDemo {
	public static void main(String[] args) {
		
		Function<String, Character> fn = (a) -> a.charAt(0);
		System.out.println(fn.apply("Govind"));
		
		Function<String, Integer> fn1 = (a) -> a.length();
		System.out.println(fn1.apply("Govind"));
		
		Function<String, String> fn2 = (a) -> a.toUpperCase();
		System.out.println(fn2.apply("Govind"));
	}
}
