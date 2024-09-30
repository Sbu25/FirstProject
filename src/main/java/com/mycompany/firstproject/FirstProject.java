/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.firstproject;

/**
 *
 * @author langt
 */
import static java.time.Clock.system;
import static java.time.InstantSource.system;
import java.util.Scanner;

/**
 *
 * @author langt
 */
public class FirstProject {

    public static void main(String[] args) {
        System.out.println("Enter Username");
        String Username = scanner.nextline();
        Scanner sc = new Scanner(System.in);
        
          System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        if (username.contains("_") && username.length() <= 5) {
            System.out.println("username successfully captured");
        }else {
            System.out.println("username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            boolean isUsernameValid = false;
            if (isUsernameValid) {
            System.out.println("username successfully captured");
        } else {
            System.out.println("username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }
            boolean isPasswordValid = false;

        if (isPasswordValid) {
            System.out.println("password successfully captured");
        } else {
            System.out.println("password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
        }
        }
    }
}