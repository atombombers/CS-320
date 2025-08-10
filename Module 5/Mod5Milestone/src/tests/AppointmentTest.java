package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.Test;
import appointment.Appointment;

class AppointmentTest {
	
// Constructor with valid inputs
@Test
void testValidAppointment(){

    String Id = "1";
    Calendar calendar = Calendar.getInstance();
    String description = "This is the description.";

    // Set a valid future date
    calendar.set(Calendar.MONTH, 01);
    calendar.set(Calendar.DATE, 01);
    calendar.set(Calendar.YEAR, 2026);

    // Convert Calendar to Date
    Date validDate = calendar.getTime();

    // Create Appointment object with valid inputs
    Appointment tempAppointment = new Appointment(Id, validDate, description);

    // Assert that the values are set correctly
    assertEquals(1, tempAppointment.getId());
    assertEquals(validDate, tempAppointment.getDate());
    assertEquals(description, tempAppointment.getDescription());  
}

// Invalid long ID
@Test
void testInvalidApptId(){

    String Id = "01234567890"; // Invalid long ID
    Date date = new Date();
    String description = "This is the description.";
    
    // Expect an exception due to invalid ID
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
    {new Appointment(Id, date, description);});
    
    // Assert that the correct error message is returned
    assertEquals("Invalid ID", exception.getMessage());
}

// Invalid null ID
@Test
void testInvalidNullApptId(){
    String Id = null; // Invalid null ID
    Date date = new Date();
    String description = "This is the description.";
    
    // Expect an exception due to invalid ID
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
    {new Appointment(Id, date, description);});
    
    // Assert that the correct error message is returned
    assertEquals("Invalid ID", exception.getMessage());

}

// Invalid past date
@Test
void testInvalidApptDate(){
    String Id = "1";
    Calendar calendar = Calendar.getInstance();
    String description = "This is the description.";

    // Set an invalid past date
    calendar.set(Calendar.MONTH, 01);
    calendar.set(Calendar.DATE, 01);
    calendar.set(Calendar.YEAR, 2025);

    Date invalidDate = calendar.getTime();

    // Expect an exception due to invalid date
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
    {new Appointment(Id, invalidDate, description);});
    
    // Assert that the correct error message is returned
    assertEquals("Invalid date", exception.getMessage()); 
}

// Invalid null date
@Test
void testInvalidNullApptDate(){
    String Id = "1";
    Date invalidDate = null; // Invalid null date
    String description = "This is the description.";

    Calendar calendar = Calendar.getInstance();

    calendar.set(Calendar.MONTH, 07);
    calendar.set(Calendar.DATE, 30);
    calendar.set(Calendar.YEAR, 2025);

    Date validDate = calendar.getTime();
    
    Appointment tempAppointment = new Appointment(Id, validDate, description); 
    
    // Expect an exception due to invalid ID
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
    {new Appointment(Id, invalidDate, description);});
    
    // Assert that the correct error message is returned
    assertEquals("Invalid date", exception.getMessage());

    // Also expect an exception when setting a null date via setter
    exception = assertThrows(IllegalArgumentException.class, () -> 
    {tempAppointment.setDate(null);});
}

// Invalid long description
@Test
void testInvalidApptDescription(){
    String Id = "1";
    Calendar calendar = Calendar.getInstance();
    String description = "This description is invalid because it is too long."; // Invalid long description

    // Set a valid future date
    calendar.set(Calendar.MONTH, 01);
    calendar.set(Calendar.DATE, 01);
    calendar.set(Calendar.YEAR, 2026);

    Date validDate = calendar.getTime();

    // Create a valid appointment
    Appointment tempAppointment = new Appointment(Id, validDate, "Test");

    // Expect exception on invalid description in constructor
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
    {new Appointment(Id, validDate, description);});
      	
    assertEquals("Invalid description", exception.getMessage());
    
    // Also expect exception when setting too long description via setter
    exception = assertThrows(IllegalArgumentException.class, () -> 
    {tempAppointment.setDescription(description);});
      	
    assertEquals("Invalid description", exception.getMessage());
}

// Invalid null description
@Test
void testInvalidNullApptDescription(){

    String Id = "1"; 
    String description = null; // Invalid null description
      	
    // Set valid date
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, 12);
    calendar.set(Calendar.DATE, 31);
    calendar.set(Calendar.YEAR, 2025);
    Date validDate = calendar.getTime();
      	              
    // Expect exception for null description
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
    {new Appointment(Id, validDate, description);});
    
    assertEquals("Invalid description", exception.getMessage());
}
}