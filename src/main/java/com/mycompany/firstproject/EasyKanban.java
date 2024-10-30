/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.firstproject;

/**
 *
 * @author langt
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

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
        this.taskID = generateTaskID();
    }

    private String generateTaskID() {
        String taskNamePart = taskName.substring(0, 2).toUpperCase();
        String developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }

    @Override
    public String toString() {
        return "Task Status: " + taskStatus +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + taskNumber +
               "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription +
               "\nTask ID: " + taskID +
               "\nTask Duration: " + taskDuration + " hours";
    }

    public int getTaskDuration() {
        return taskDuration;
    }
}

public class EasyKanban {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        if (!login(username, password)) {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting application.");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        while (true) {
            String menu = JOptionPane.showInputDialog("Choose an option:\n1) Add tasks\n2) Show report\n3) Quit");
            switch (menu) {
                case "1":
                    addTasks();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    showTotalHours();
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option, please try again.");
            }
        }
    }

    private static boolean login(String username, String password) {
        // Replace with actual login validation
        return username.equals("user") && password.equals("password");
    }

    private static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription;
            while (true) {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                if (taskDescription.length() <= 50) {
                    JOptionPane.showMessageDialog(null, "Task successfully captured");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                }
            }
            String developerDetails = JOptionPane.showInputDialog("Enter developer details (First and Last name):");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
            String[] statuses = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status", "Task Status", 
                            JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
            tasks.add(task);
            JOptionPane.showMessageDialog(null, task.toString());
        }
    }

    private static void showTotalHours() {
        int totalHours = tasks.stream().mapToInt(Task::getTaskDuration).sum();
        JOptionPane.showMessageDialog(null, "Total task duration: " + totalHours + " hours");
    }
}
