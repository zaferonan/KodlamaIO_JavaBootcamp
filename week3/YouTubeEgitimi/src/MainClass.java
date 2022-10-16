
public class MainClass {
	
	public static void main(String[] args) {
		CreditManager creditManager=new CreditManager();
		creditManager.Calculate();
		creditManager.Save();
		
		
		Customer customer= new Customer();
		customer.setId(100);
		customer.setCity("Balikesir");
		
		CustomerManager customerManager=new CustomerManager(customer,new TeacherCreditManager());
		customerManager.Save();
		customerManager.giveCredit();
		customerManager.Delete();
		
		Company company= new Company("Arcelik","100000");
		company.setId(200);
		
		CustomerManager customerManager2=new CustomerManager(company,new MilitaryCreitManager());
		customerManager2.giveCredit();
		
		
		
	}

}
