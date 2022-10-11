package loopDemo;

public class Main {

	public static void main(String[] args) {
		

		//For
		for (int i = 2; i < 10; i+=2) {
			System.out.println(i);
		}
		System.out.println("For Dongusu Bitti");
		//While
		int i=1;
		while (i<10) {
			System.out.println(i);
			i+=2;
		}
		System.out.println("While Dongusu Bitti");
		//Do-While 
		i=100;
		do {
			System.out.println(i);
			i+=2;
		} while (i<10);
		System.out.println("Do-While Dongusu Bitti");
	}

}
