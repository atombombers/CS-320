package contact;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	
	private final String contactID; // contactID is final so that it may not be changed 
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	private static AtomicLong idGenerator = new AtomicLong(); // idGenerator is static to prevent duplicates

	public Contact(String firstName, String lastName, String number, String address) {
		
		// contactID is generated when the constructor is called
		this.contactID = String.valueOf(idGenerator.getAndIncrement());

		
		// firstName field
		// If the input is null or empty...
		if (firstName == null || firstName.isEmpty()) {
			// Set firstName to default value
			this.firstName = "NULL";
		} 
		// If first name is longer than 10 characters...
		else if (firstName.length() > 10) {
			// Truncate it to first 10 characters
			this.firstName = firstName.substring(0, 10);
		} 
		 // Otherwise, use the input as is
		else {
			this.firstName = firstName;
		}

		
		// lastName field
		// Operates the same as firstName
		if (lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
		} 
		else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		} 
		else {
			this.lastName = lastName;
		}
		
		
		// number field
		// If the input is null, empty, or not 10 digits long...
		if (number == null || number.isEmpty() || number.length() != 10) {
			// Assign placeholder number
			this.number = "0000000000";
		} 
		// If the input is valid, assign it to number
		else {
			this.number = number;
		}
		
		
		// address field
		 // If the input is null or empty...
		if (address == null || address.isEmpty()) {
			// Assign a default value
			this.address = "NULL";
		} 
		// If the input is longer than 30 characters...
		else if (address.length() > 30) {
			// Truncate it to the first 30
			this.address = address.substring(0, 30);
		} 
		// Otherwise, use the input as is
		else {
			this.address = address;
		}
	}

	// Getter functions
	
	public String getContactID() {
		return contactID;
	}
	
	public String getAddress() {
		return address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}
	
	// Setter functions 
	
	public void setFirstName(String firstName) {
		// If the input is null or empty...
		if (firstName == null || firstName.isEmpty()) {
			// Set firstName to default value
			this.firstName = "NULL";
		} 
		// If first name is longer than 10 characters...
		else if (firstName.length() > 10) {
			// Truncate it to first 10 characters
			this.firstName = firstName.substring(0, 10);
		} 
		// Otherwise, use the input as is
		else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		// Operates the same as setFirstName
		if (lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
		} 
		else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		} 
		else {
			this.lastName = lastName;
		}
		
	}

	public void setNumber(String number) {
		// If the input is null, empty, or not 10 digits long...
		if (number == null || number.isEmpty() || number.length() != 10) {
			// Assign placeholder number
			this.number = "0000000000"; 
		} 
			// If the input is valid, assign it to number
		else {
			this.number = number;
		}
	}

	public void setAddress(String address) {
		 // If the input is null or empty...
		if (address == null || address.isEmpty()) {
			// Assign a default value
			this.address = "NULL";
		} 
		// If the input is longer than 30 characters...
		else if (address.length() > 30) {
			// Truncate it to the first 30
			this.address = address.substring(0, 30);
		} 
		// Otherwise, use the input as is
		else {
			this.address = address;
		}
	}
}
