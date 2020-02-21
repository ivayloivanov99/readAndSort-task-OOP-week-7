package fmi.informatics.extending;

public class Person {

	private String firstName = "Ivan";
	private String middleName = "Dimitrov";
	private String lastName = "Ivanov";
	private int nameCounter;

	public Person() {

	}

	public Person(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public Person(String firstName, int nameCounter) {
		this.firstName = firstName;
		this.nameCounter = nameCounter;

	}

	public int getNameCounter() {
		return nameCounter;
	}

	public void setNameCounter(int nameCounter) {
		this.nameCounter = nameCounter;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
