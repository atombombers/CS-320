package services;

import java.util.HashMap;

import models.Task;

public class TaskService {

    // Integer used to generate unique IDs for tasks
    int currentIdNum = 0;

    // Static HashMap to store tasks using their ID as the key
    public static HashMap<String, Task> tasks = new HashMap<String, Task>();

    // Adds a new task with a unique ID
    public void addTask(String _name, String _description){
        // Convert the current numeric ID to a String
        String stringID = Integer.toString(currentIdNum);
        // Create a new Task object with the generated ID, name, and description
        Task tempTask = new Task (stringID, _name, _description);
        // Add the new Task to the tasks map using the string ID as the key
        tasks.put(stringID, tempTask);	
        // Increment the ID counter to ensure the next task has a unique ID
	    currentIdNum++;
    }

    // Deletes a task by ID; throws exception if not found
    public void deleteTask(String _ID) {
        if (!tasks.containsKey(_ID)) {
            throw new IllegalArgumentException("Task with ID " + _ID + " does not exist.");
        }
        tasks.remove(_ID);
    }

    // Updates name and description of a task by ID; throws exception if not found
    public void updateTask(String _ID, String _newName, String _newDescription) {
        Task task = tasks.get(_ID);
        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + _ID + " does not exist.");
        }
        task.setName(_newName);
        task.setDescription(_newDescription);
    }
}
