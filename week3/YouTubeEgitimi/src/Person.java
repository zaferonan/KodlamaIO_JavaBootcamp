
public class Person extends Customer{
	
	private String firstName;
	private String surName;
	private final String identityNumber;
	
	
	public Person(String firstName, String surName, String identityNumber) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.identityNumber = identityNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	
	

}
