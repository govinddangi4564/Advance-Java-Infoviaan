package StreamAPI;

import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		
		Supplier<String> sup = () -> "Welcome to the advance class";
		System.out.println(sup.get());
		
		Supplier<Double> r = () -> Math.random();
		System.out.println(r.get());
	}
}
