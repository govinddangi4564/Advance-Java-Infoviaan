package StreamAPI;

import java.util.function.Consumer;

public class ConsumerDemo {
	public static void main(String[] args) {
		
		Consumer<Integer> cons = (a) -> System.out.println(a + 1);
		cons.accept(10);
	}
}
