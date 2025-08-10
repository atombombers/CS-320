package services;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

class TaskServiceTest {
 
    // Runs after each test to reset the shared static map so tests don't affect each other
	@AfterEach
    void tearDown() throws Exception {
        TaskService.tasks.clear();
   } 
   /***************************
    * Add A Task Test
    ***************************/
   @Test
    void testAddTask(){
        // First ID that will be generated
        String Id = "0";
        String name = "Brooke Slampak";
        String description = "This is the description.";

        TaskService tempTask = new TaskService();

        // Ensure that the map starts empty
        assertEquals(0, TaskService.tasks.size());

        // Add a task
        tempTask.addTask(name, description);

        // Checks that the task was added with correct values
        assertTrue(TaskService.tasks.containsKey(Id));
        assertEquals(name, TaskService.tasks.get(Id).getName());
        assertEquals(description, TaskService.tasks.get(Id).getDescription());

   }

   /***************************
    * Delete A Task Test
    ***************************/
   @Test
   void testDeleteTask(){

    String name = "Brooke Slampak";
    String description = "This is the description.";

    TaskService tempTask = new TaskService();

     // Ensure the map starts empty
     assertEquals(0, TaskService.tasks.size());

     // Add 3 tasks with IDs 0, 1, 2
     tempTask.addTask(name, description); //0
     tempTask.addTask(name, description); //1
     tempTask.addTask(name, description); //2

    // Confirm that all were added
    assertEquals(3, TaskService.tasks.size());

    // Delete task with ID "1"
    tempTask.deleteTask("1");

    // Check size and absence of ID "1"
    assertEquals(2, TaskService.tasks.size());
    assertFalse(TaskService.tasks.containsKey("1"));

   }

    /***************************
    * Update A Task Test
    ***************************/
   @Test
    void testUpdateTask(){
        String Id = "0";
        String name = "Brooke Slampak";
        String description = "This is the description.";

        TaskService tempTask = new TaskService();

        // Add a task with ID "0"
        tempTask.addTask(name, description); 

        // Update task "0" with a new description
        tempTask.updateTask("0", name, "This is the new description."); 

        // Verify the change
        assertEquals("This is the new description.", TaskService.tasks.get(Id).getDescription());
        assertEquals(name, TaskService.tasks.get(Id).getName());

   }

}