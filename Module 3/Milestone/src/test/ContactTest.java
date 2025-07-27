package test;

import contact.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
 
	@DisplayName("Contact ID cannot have more than 10 characters")
	void testContactIDWithMoreThanTenCharacters() {
		Contact contact = new Contact("FirstName", "LastName", "PhoneNumb", "Address");
		if (contact.getContactID().length() > 10) {
			fail("Contact ID has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Contact First Name cannot have more than 10 characters")
	void testContactFirstNameWithMoreThanTenCharacters() {
		Contact contact = new Contact("Christopher", "LastName", "PhoneNumb", "Address");
		if (contact.getFirstName().length() > 10) {
			fail("First Name has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Contact Last Name cannot have more than 10 characters")
	void testContactLastNameWithMoreThanTenCharacters() {
		Contact contact = new Contact("FirstName", "Middlebrook", "PhoneNumb", "Address");
		if (contact.getLastName().length() > 10) {
			fail("Last Name has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Contact phone number is exactly 10 characters")
	void testContactNumberWithMoreThanTenCharacters() {
		Contact contact = new Contact("FirstName", "LastName", "12345678900", "Address");
		if (contact.getNumber().length() != 10) {
			fail("Phone number length does not equal 10.");
		}
	}

	@Test
	@DisplayName("Contact address cannot have more than 30 characters")
	void testContactAddressWithMoreThanThirtyCharacters() {
		Contact contact = new Contact("FirstName", "LastName", "PhoneNumbr",
				"1234 Cedarwood Avenue Apt C Pittsburgh PA 15216");
		if (contact.getAddress().length() > 30) {
			fail("Address has more than 30 characters.");
		}
	}
	
	@Test
	@DisplayName("Contact First Name cannot be null")
	void testContactFirstNameNotNull() {
		Contact contact = new Contact(null, "LastName", "PhoneNumbr", "Address");
		assertNotNull(contact.getFirstName(), "First name was null.");
	} 
	
	@Test
	@DisplayName("Contact Last Name cannot be null")
	void testContactLastNameNotNull() {
		Contact contact = new Contact("FirstName", null, "PhoneNumbr", "Address");
		assertNotNull(contact.getLastName(), "Last name was null.");
	}

	@Test
	@DisplayName("Contact Phone Number cannot be null")
	void testContactPhoneNotNull() {
		Contact contact = new Contact("FirstName", "LastName", null, "Address");
		assertNotNull(contact.getNumber(), "Phone number was null.");
	}

	@Test
	@DisplayName("Contact Address cannot be null")
	void testContactAddressNotNull() {
		Contact contact = new Contact("FirstName", "LastName", "PhoneNumbr", null);
		assertNotNull(contact.getAddress(), "Address was null.");
	}
}