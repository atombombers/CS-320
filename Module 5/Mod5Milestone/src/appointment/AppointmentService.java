package appointment;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {

    // Integer used to generate unique IDs for tasks
    int currentIdNum = 0;

    // Static HashMap to store appointments using their ID as the key
    public static HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();

    // Adds a new appointment with a unique ID
    public void addAppointment(Date _date, String _description){
        // Convert the current numeric ID to a String
        String stringID = Integer.toString(currentIdNum);
        // Create a new Appointment object with the generated ID, date, and description
        Appointment tempAppointment = new Appointment (stringID, _date, _description);
        // Add the new Task to the tasks map using the string ID as the key
        appointments.put(stringID, tempAppointment);	
        // Increment the ID counter to ensure the next task has a unique ID
	    currentIdNum++;
    }

    public void deleteAppointment(String _ID) {

		if(appointments.containsKey(_ID)) {			
			appointments.remove(_ID);
		}		
	}
}