/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author langt
 */
public class Task {
    
}


class Task {
    private static int taskCount = 0;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskCount++;
        this.taskID = createTaskID();
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        String taskNamePart = taskName.substring(0, 2).toUpperCase();
        String developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + taskNumber +
               "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription +
               "\nTask ID: " + taskID +
               "\nTask Duration: " + taskDuration + " hours";
    }

    public int returnTotalHours() {
        return taskDuration;
    }

    public static void main(String[] args) {
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "Doing");
        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        // Print details of each task
        for (Task task : tasks) {
            System.out.println(task.printTaskDetails());
        }

        // Check total hours
        int totalHours = tasks.stream().mapToInt(Task::returnTotalHours).sum();
        System.out.println("Total task duration: " + totalHours + " hours");
    }
}
