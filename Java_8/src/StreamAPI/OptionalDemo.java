package StreamAPI;

import java.util.Optional;

public class OptionalDemo {
	
	public static String getName() {
		// database
		return null;
	}
	
	public static void main(String[] args) {
		
//		Optional<String> s = Optional.of(null);
//		System.out.println(s.get());
		
		
		
//		Optional<String> s = Optional.ofNullable(null);
//		if(s.isPresent()) {
//			System.out.println(s.get());
//		}
//		System.out.println("Other Work");
		
		
		Optional<String> s = Optional.ofNullable(null);
		s.ifPresent(System.out::println);
		System.out.println("Other Work");
		
		
		
	}
}
