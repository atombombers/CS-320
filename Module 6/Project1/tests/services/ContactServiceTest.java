package services;

import org.junit.jupiter.api.Test;

import models.Contact;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Order;


public class ContactServiceTest {

	@Test
	@Order(1)
	void testUpdateFirstName() {
		System.out.println("Test to update first name:\n");
		ContactService service = new ContactService();
		service.addContact("Ms.", "Smith", "1234567890", "123 Rainbow Road");
		String id = service.contactList.get(0).getContactID();
		service.updateFirstName("Jane", id);
		service.displayContactList();
		assertEquals("Jane", service.getContact(id).getFirstName(), "First name was not updated.");
	}

	@Test
	void testUpdateLastName() {
		System.out.println("Test to update last name:\n");
		ContactService service = new ContactService();
		service.addContact("Ms.", "Smith", "1234567890", "123 Rainbow Road");
		String id = service.contactList.get(0).getContactID();
		service.updateLastName("Jones", id);
		service.displayContactList();
		assertEquals("Jones", service.getContact(id).getLastName(), "Last name was not updated.");
	}

	@Test
	void testUpdatePhoneNumber() {
		System.out.println("Test to update phone number:\n");
		ContactService service = new ContactService();
		service.addContact("Ms.", "Smith", "1234567890", "123 Rainbow Road");
		String id = service.contactList.get(0).getContactID();
		service.updateNumber("1001002020", id);
		service.displayContactList();
		assertEquals("1001002020", service.getContact(id).getNumber(), "Phone number was not updated.");
	}

	@Test
	void testUpdateAddress() {
		System.out.println("Test to update address:\n");
		ContactService service = new ContactService();
		service.addContact("Ms.", "Smith", "1234567890", "123 Rainbow Road");
		String id = service.contactList.get(0).getContactID();
		service.updateAddress("100 Anywhere Ave", id);
		service.displayContactList();
		assertEquals("100 Anywhere Ave", service.getContact(id).getAddress(), "Address was not updated.");
	}

	@Test
	void testDeleteContact() {
		System.out.println("Test to check that contacts are deleted correctly:\n");
		ContactService service = new ContactService();
		service.addContact("Ms.", "Smith", "1234567890", "123 Rainbow Road");
		String id = service.contactList.get(0).getContactID();
		service.deleteContact(id);
		// Ensure that the contactList is now empty by creating a new empty contactList to compare it with
		ArrayList<Contact> contactListEmpty = new ArrayList<Contact>();
		service.displayContactList();
		assertEquals(service.contactList, contactListEmpty, "The contact was not deleted.");
	}

	@Test
	void testAddContact() {
		System.out.println("Test to check that contacts are added correctly:\n");
		ContactService service = new ContactService();
		service.addContact("Ms.", "Smith", "1234567890", "123 Rainbow Road");
		service.displayContactList();
		assertNotNull(service.getContact("0"), "Contact was not added correctly.");
	}

}
