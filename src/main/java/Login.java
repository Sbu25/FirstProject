/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author langt
 */
  public class Login {
    private String storedUsername;
    private String storedPassword;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 15;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is incorrectly formatted";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements";
        }
        this.storedUsername = username;
        this.storedPassword = password;
        return "User has been registered successfully";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        System.out.println(login.registerUser("user_name", "Password1!"));
        System.out.println(login.returnLoginStatus("user_name", "Password1!"));
    }
}

    

    

