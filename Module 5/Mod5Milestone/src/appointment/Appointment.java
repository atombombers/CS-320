package appointment;

import java.util.Date;

public class Appointment {

    private String Id;
    private Date date;
    private String description;

/*********************
 * OBJECT VALIDATIONS
 *********************/

    // Validates that the ID is neither null or longer than 10 characters
    private final boolean validID(String Id){
        // If ID is null or greater than 10 characters
        if(Id == null || Id.length() > 10){
            // Invalid ID
            return false;
        }
        // Otherwise, valid ID
        return true;
    }

    // Validates that the date is neither null or in the past
    private final boolean validDate(Date date) { //_date
        // If date is null or before the given date
        if (date == null || date.before(new Date())){
            // Invalid date
            return false;
        }
        // Otherwise, valid date
        return true;
    }

    // Validates that the description is neither null or longer than 50 characters
    private final boolean validDescription(String description) {
        // If description is null or longer than 50 characters
        if (description == null || description.length() > 50) {
            // Invalid description
            return false;
        }
        // Otherwise, valid description
        return true;
    }

/**************************
 * APPOINTMENT CONSTRUCTOR
 **************************/

    public Appointment(String Id, Date date, String description) {
        if(!this.validID(Id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(!this.validDate(date)) {
			throw new IllegalArgumentException("Invalid date");
		}
		
		if(!this.validDescription(description)) {
			throw new IllegalArgumentException("Invalid description");
		}	

        setID(Id);
        setDate(date);
        setDescription(description);
    }

/**************
 * GETTERS
 **************/

    public int getId(){
        return Integer.valueOf(Id);
    }

    public Date getDate(){
        return date;
    }

    public String getDescription(){
        return description;
    }

/**************
 * SETTERS
 **************/  

    private void setID(String Id){
        this.Id = Id;
    }

    public void setDate(Date date){
        if(!this.validDate(date)) {
			throw new IllegalArgumentException("Invalid date");
		}
        this.date = date;
    }

    public void setDescription(String description){
        if(!this.validDescription(description)) {
			throw new IllegalArgumentException("Invalid description");
		}
        this.description = description;
    }

}
