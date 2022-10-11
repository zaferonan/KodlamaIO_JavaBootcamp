package switchDemo;

public class Main {

	public static void main(String[] args) {
		
		char grade='B';
		
		switch (grade) {
		case 'A': {
			System.out.println("Mukemmel : Gectiniz");
			break;
		}
		case 'B': 
		case 'C': {
			System.out.println("Iyi : Gectiniz");
			break;
		}
		case 'D': {
			System.out.println("Fena Degil : Gectiniz");
			break;
		}
		case 'F': {
			System.out.println("Maalesef : Kaldiniz");
			break;
		}
		default:
			System.out.println("Gecersiz Not Girdiniz");
		}

	}

}
