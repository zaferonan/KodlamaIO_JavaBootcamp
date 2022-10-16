
public abstract class BaseCreditmanager implements CreditService {

	@Override
	public void Save() {
		System.out.println("kaydedildi");
		
	}

	@Override
	public abstract void Calculate() ;

	
}
