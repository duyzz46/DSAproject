/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsaproject;

/**
 *
 * @author duyzz
 */
import java.util.Scanner;

public class QueueMessage {

    static final int MAX_SIZE = 100;

    static Scanner scanner = new Scanner(System.in);

    static String[] messages = new String[MAX_SIZE];
    static int front = 0;
    static int rear = -1;
    static int count = 0;

    static StackArray sentStack = new StackArray(MAX_SIZE);
    static StackArray receivedStack = new StackArray(MAX_SIZE);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nQueue Message");
            System.out.println("=============");
            System.out.println("1. Input message");
            System.out.println("2. Send message");
            System.out.println("3. Received message / View message");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputMessage();
                    break;
                case 2:
                    sendMessage();
                    break;
                case 3:
                    viewMessage();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    public static void inputMessage() {
        if (count == MAX_SIZE) {
            System.out.println("Message queue is full!");
            return;
        }

        scanner.nextLine(); // Consume newline character

        System.out.print("Enter message: ");
        String message = scanner.nextLine();

        rear = (rear + 1) % MAX_SIZE;
        messages[rear] = message;
        count++;

        System.out.println("Message added to queue.");
    }

    public static void sendMessage() {
        if (count == 0) {
            System.out.println("Message queue is empty!");
            return;
        }

        String message = messages[front];

        sentStack.push(message);
        front = (front + 1) % MAX_SIZE;
        count--;

        System.out.println("Message sent: " + message);
    }

    public static void viewMessage() {
        System.out.println("Received messages:");
        while (!sentStack.isEmpty()) {
            String message = sentStack.pop();
            receivedStack.push(message);
            System.out.println("- " + message);
        }

        System.out.println("Queue messages:");
        for (int i = front; i <= rear; i++) {
            System.out.println("- " + messages[i]);
        }

        while (!receivedStack.isEmpty()) {
            String message = receivedStack.pop();
            sentStack.push(message);
        }
    }
}


