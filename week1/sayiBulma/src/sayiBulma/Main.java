package sayiBulma;

public class Main {

	public static void main(String[] args) {
		int[] sayilar=new int[] {1,2,5,7,9,0};
		int aranacak=8;
		boolean isExist=false;
		for (int sayi : sayilar) {
			if(sayi==aranacak) {
				System.out.println(aranacak+" sayisi sayilar dizisinde bulunmaktadir.");
				isExist=true;
				break;
			}
		}
		if(!isExist) {
			System.out.println(aranacak+" sayisi sayilar dizisinde bulunmamaktadir.");
		}
		

	}

}
