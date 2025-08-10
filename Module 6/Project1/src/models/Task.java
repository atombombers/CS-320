package models;

public class Task {

	private String Id;
    private String name;
    private String description;

    //checks to see if Id is within acceptable limits
    private boolean validId(String Id){
        //if Id is null or longer than 10 characters...
        if (Id == null || Id.length() > 10) {
            //Id is not within acceptable limits
            return false;
        }
        //Otherwise, Id is within acceptable limits, return true
        return true;
    }

    //checks to see if name is within acceptable limits
    private boolean validName(String name){
        //if name is null or more than 20 characters
        if(name == null || name.length() > 20){
            //name is not within acceptable limits
            return false;
        }
        //Otherwise, name is within acceptable limits, return true
        return true;
    }

    //checks to see if description is within acceptable limits
    private boolean validDescription(String description){
        //if description is null or more than 20 characters
        if (description == null || description.length() > 50){
            //description is not within acceptable limits
            return false;
        }
        //Otherwise, description is within acceptable limits, return true
        return true;
    }

    public Task (String Id, String name, String description) {

        // Validate the 'Id' using validId method; throw exception if invalid
        if (!this.validId(Id)){
            throw new IllegalArgumentException("Invalid ID");
        }
        // Validate the 'name' using validName method; throw exception if invalid
        if (!this.validName(name)){
            throw new IllegalArgumentException("Invalid name");
        }
        // Validate the 'description' using validDescription method; throw exception if invalid
        if (!this.validDescription(description)){
            throw new IllegalArgumentException("Invalid description");
        }

        // Set values using setter methods after validation
        setID(Id);
		setName(name);
		setDescription(description);
    }
    
    /*****************************
     * GETTER METHODS
     ****************************/

    // Convert the String Id to an Integer before returning
    public int getId() {
		return Integer.valueOf(Id);
	}

    public String getName() {
		return name;
	}

    public String getDescription() {
		return description;
	}

    /*****************************
     * SETTER METHODS
     ****************************/

    private void setID(String Id){ 
        // Assign the provided Id to the instance variable
		this.Id = Id; 
	}

    public void setName(String name) {
        // Validate name before setting; throw exception if invalid
		if(!this.validName(name)) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
	}

    public void setDescription(String description) {
        // Validate description before setting; throw exception if invalid
		if(!this.validDescription(description)) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = description;
	}
}