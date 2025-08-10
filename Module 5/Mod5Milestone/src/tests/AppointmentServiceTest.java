package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import appointment.AppointmentService;

public class AppointmentServiceTest {
	
	// Runs after each test to reset the shared static map so tests don't affect each other
	@AfterEach
	void tearDown() throws Exception {
		AppointmentService.appointments.clear();
	}
	
/************************
 * addAppointment TESTS *
 ************************/

// Add appointment with valid input
@Test
void testAddAppointment() {
	String Id = "0";
	String description = "This is the description.";
	Calendar calendar = Calendar.getInstance();
	
	// Set the date to future date of January 1, 2026
	calendar.set(Calendar.MONTH, 01);
	calendar.set(Calendar.DATE, 01);
	calendar.set(Calendar.YEAR, 2026);
	
	// Convert Calendar to Date object for the appointment
	Date validDate = calendar.getTime();
	
	// Create a new instance of the service to test
	AppointmentService tempAppointment = new AppointmentService();
	
	// Verify that the appointment list is initially empty
	assertEquals(0, AppointmentService.appointments.size());
	
	// Call the method to add a new appointment
	tempAppointment.addAppointment(validDate, description);
	
	// Check that the appointment was added with the expected ID, date and description
	assertTrue(AppointmentService.appointments.containsKey(Id));
	assertEquals(validDate, AppointmentService.appointments.get(Id).getDate());
	assertEquals(description, AppointmentService.appointments.get(Id).getDescription());
}
	
// Add appointment with invalid input
@Test
void testAddInvalidAppt() {
	String Id = "0";
	String description = null; // Invalid description; This should trigger an exception
	Calendar calendar = Calendar.getInstance();
	
	// Set the date to future date of January 1, 2026
	calendar.set(Calendar.MONTH, 01);
	calendar.set(Calendar.DATE, 01);
	calendar.set(Calendar.YEAR, 2026);
	
	// Convert Calendar to Date object for the appointment
	Date validDate = calendar.getTime();
	
	// Assert that an IllegalArgumentException is thrown when trying to add an appointment with a null description
	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
	{
  		AppointmentService tempAppointment = new AppointmentService(); // Create an instance of the service
  		tempAppointment.addAppointment(validDate, description); // Attempt to add the invalid appointment
    });
  	
	// Check that the exception message is what is expected
  	assertEquals("Invalid description", exception.getMessage());
	
}

/***************************
 * deleteAppointment TEST *
 ***************************/

@Test
void testDeleteAppointment() {
	String Id = "0";
	String description = "This is the description.";
	Calendar calendar = Calendar.getInstance();
	
	// Set the date to future date of January 1, 2026
	calendar.set(Calendar.MONTH, 01);
	calendar.set(Calendar.DATE, 01);
	calendar.set(Calendar.YEAR, 2026);
	
	// Convert Calendar to Date object for the appointment
	Date validDate = calendar.getTime();
	
	// Create a new instance of the service to test
	AppointmentService tempAppointment = new AppointmentService();
	
	// Verify that the appointment list is initially empty
	assertEquals(0, AppointmentService.appointments.size());
	
	// Add three appointments (IDs 0, 1, and 2)
	tempAppointment.addAppointment(validDate, description); // ID 0
	tempAppointment.addAppointment(validDate, description); // ID 1
	tempAppointment.addAppointment(validDate, description); // ID 2
	
	// Confirm all three appointments were added
	assertEquals(3, AppointmentService.appointments.size());
	
	// Delete the appointment with ID "1"
	tempAppointment.deleteAppointment("1");
	
	// Ensure ID "1" appointment was removed
	assertEquals(2, AppointmentService.appointments.size());
	
	// Confirm appointment with ID "1" is no longer in the map
	assertFalse(AppointmentService.appointments.containsKey("1"));
	
	// Attempt to delete the same ID again
	tempAppointment.deleteAppointment("1");
	
	 // Size should remain unchanged after trying to delete a non-existent appointment
	assertEquals(2, AppointmentService.appointments.size());
	
}

}
