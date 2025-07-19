package contact;

import java.util.ArrayList;

public class ContactService {
	
	// Creates an ArrayList to hold the list of contacts
	public ArrayList<Contact> contactList = new ArrayList<Contact>();

	// Prints the list of contacts to the console 
	public void displayContactList() {
		//Iterates over list of contacts stored in contactList
		for (int counter = 0; counter < contactList.size(); counter++) {
			System.out.println("Contact ID: " + contactList.get(counter).getContactID() + "\n");
			System.out.println("First Name: " + contactList.get(counter).getFirstName() + "\n");
			System.out.println("Last Name: " + contactList.get(counter).getLastName() + "\n");
			System.out.println("Phone Number: " + contactList.get(counter).getNumber() + "\n");
			System.out.println("Address: " + contactList.get(counter).getAddress() + "\n");
		}
	}

	// Uses Contact constructor to create and add a new contact to list
	public void addContact(String firstName, String lastName, String number, String address) {
		// Creates the new contact
		Contact contact = new Contact(firstName, lastName, number, address);
		contactList.add(contact);

	}

	// Finds matching Contact ID and returns the contact
	// If a matching Contact ID is not found, return a contact with default values
	public Contact getContact(String contactID) {
		Contact contact = new Contact(null, null, null, null);
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contact = contactList.get(counter);
			}
		}
		return contact;
	}


	// Search by contactID to delete from the list
	public void deleteContact(String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.remove(counter);
				break;
			}
			// Output message if no match is found
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}

	// Updates the contact's first name
	public void updateFirstName(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setFirstName(updatedString);
				break;
			}
			// Output message if no match is found
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}

	// Updates the contact's last name
	public void updateLastName(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setLastName(updatedString);
				break;
			}
			// Output message if no match is found
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}

	// Updates the contact's phone number
	public void updateNumber(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setNumber(updatedString);
				break;
			}
			// Output message if no match is found
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}

	// Updates the contact's address
	public void updateAddress(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setAddress(updatedString);
				break;
			}
			// Output message if no match is found
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}
}