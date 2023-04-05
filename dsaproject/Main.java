/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duytran.dsaproject;

/**
 *
 * @author duytran
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Message manager = new Message();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. Input message");
            System.out.println("2. Send message");
            System.out.println("3. View messages");
            System.out.println("4. Delete all messages in the queue");
            System.out.println("5. Exit");
            System.out.print("Make a selection: ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    System.out.print("Enter message to enqueue: ");
                    String message = scanner.nextLine();
                    manager.enqueueMessage(message);
                    break;
                case 2:
                    manager.sendMessage();
                    break;
                case 3:
                    manager.viewMessages();
                    break;
                case 4:
                    manager.clearQueue();
                    System.out.println("Queue cleared.");
                    break;

                case 5:
                    System.out.println("Exiting menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
