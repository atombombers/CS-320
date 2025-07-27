package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.Task;

class TaskTest {

    /***********************************
     * Constructor Initialization Tests
     ***********************************/

    // Constructor with valid inputs
    @Test
    void validContructor(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = "This is the description.";

        // Create a new Task instance with valid inputs
        Task tempTask = new Task(Id, name, description);

        // Assertions to validate that values were set correctly
        assertEquals(1, tempTask.getId());
        assertEquals(name, tempTask.getName());
        assertEquals(description, tempTask.getDescription());

    }     

    // Constructor with invalid long description input
    @Test
    void invalidConstructDescription(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = "This description is invalid because it is too long."; // Description too long

        // Should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {new Task(Id, name, description);});
    }

    // Constructor with invalid null description input
    @Test
    void invalidConstructNullDescription(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = null; // Description null

        // Should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {new Task(Id, name, description);});
    }

    // Constructor with invalid long ID
    @Test
    void invalidConstructorID(){

        String Id = "01234567890"; //ID too long
        String name = "Brooke Slampak";
        String description = "This is the description.";

        // Should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {new Task(Id, name, description);});
    }

    // Constructor with invalid null ID
    @Test
    void invalidConstructNullID(){

        String Id = null; //ID null
        String name = "Brooke Slampak";
        String description = "This is the description.";

        // Should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {new Task(Id, name, description);});
    }

    // Constructor with invalid long name input
    @Test
    void invalidConstructName(){

        String Id = "1";
        String name = "Smitty Werbenjagermanjensen";
        String description = "This is the description.";

        // Should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {new Task(Id, name, description);});
    }

    // Constructor with invalid null name input
    @Test
    void invalidConstructNullName(){

        String Id = "1";
        String name = null;
        String description = "This is the description.";

        // Should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {new Task(Id, name, description);});
    }


     /***********************************
     * setName Tests
     ***********************************/

    // Constructor with valid setName
    @Test
    public void validSetName(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = "This is the description.";
        
        Task tempTask = new Task(Id, name, description);  

        tempTask.setName("Test Name");        
        assertEquals("Test Name", tempTask.getName());
    }

    // Constructor with invalid long setName
    @Test
    public void invalidSetName(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = "This is the description.";
        
        Task tempTask = new Task(Id, name, description);  

        // Expect an exception when setting an overly long name
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {tempTask.setName("Smitty Werbenjagermanjensen");});	

    }

    // Constructor with invalid null setName
    @Test
    public void invalidNullSetName(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = "This is the description.";
        
        Task tempTask = new Task(Id, name, description);  

       // Expect an exception when setting a null name
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {tempTask.setName(null);});
    }

    /***********************************
     * setDescription Tests
     ***********************************/

    //setDescription with valid input
    @Test
    public void validSetDescription(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = "This is the description.";
        
        Task tempTask = new Task(Id, name, description); 

        tempTask.setDescription("This is the new description.");

        assertEquals("This is the new description.", tempTask.getDescription());
    }

    //setDescription with invalid long description input
    @Test
    public void invalidSetDescription(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = "This is the description.";
        
        Task tempTask = new Task(Id, name, description); 

        // Expect an exception when setting an overly long name
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {tempTask.setName("This description is invalid because it is too long.");});	
    }

    //setDescription with invalid null description input
    @Test
    public void invalidNullSetDescription(){

        String Id = "1";
        String name = "Brooke Slampak";
        String description = "This is the description.";
        
        Task tempTask = new Task(Id, name, description); 

        // Expect an exception when setting a null name
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        {tempTask.setName(null);});	
    }
}