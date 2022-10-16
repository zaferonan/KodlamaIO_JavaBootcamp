
public class CustomerManager {
	
	private Customer customer;
	private CreditService creditService;


	
	
	public CustomerManager(Customer customer, CreditService creditService) {
		super();
		this.customer = customer;
		this.creditService = creditService;
	}

	public void Save() {
		System.out.println("Musteri kaydedildi.");
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void Delete() {
		System.out.println("Musteri silindi.");
		
	}
	public void giveCredit() {
		creditService.Calculate();
		System.out.println("kredi verildi.");
	}
	
	
	
}
