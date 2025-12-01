package com.example.demo.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class StudentApiMenu {

    private static final String BASE_URL = "http://localhost:9191/students";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("\n========== STUDENT API MENU ==========");
            System.out.println("1. Create Student");
            System.out.println("2. Get Student by ID");
            System.out.println("3. Get All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = readIntSafe();

            switch (choice) {
                case 1 -> createStudent();
                case 2 -> getStudentById();
                case 3 -> getAllStudents();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    // SAFELY READ INTEGER INPUT
    private static int readIntSafe() {
        while (true) {
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                sc.nextLine();  // consume newline
                return num;
            } else {
                System.out.print("❌ Invalid input! Enter a number: ");
                sc.nextLine();  // clear invalid entry
            }
        }
    }

    // CREATE STUDENT
    private static void createStudent() throws Exception {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age (number only): ");
        int age = readIntSafe();

        System.out.print("Enter city: ");
        String city = sc.nextLine();

        String json = """
                {
                  "name": "%s",
                  "age": %d,
                  "city": "%s"
                }
                """.formatted(name, age, city);

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("\nResponse: " + res.body());
    }

    // GET STUDENT BY ID
    private static void getStudentById() throws Exception {
        System.out.print("Enter Student ID: ");
        int id = readIntSafe();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("\nResponse: " + res.body());
    }

    // GET ALL STUDENTS
    private static void getAllStudents() throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("\nResponse: " + res.body());
    }

    // UPDATE STUDENT
    private static void updateStudent() throws Exception {
        System.out.print("Enter Student ID to Update: ");
        int id = readIntSafe();

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new age (number only): ");
        int age = readIntSafe();

        System.out.print("Enter new city: ");
        String city = sc.nextLine();

        String json = """
                {
                  "name": "%s",
                  "age": %d,
                  "city": "%s"
                }
                """.formatted(name, age, city);

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("\nResponse: " + res.body());
    }

    // DELETE STUDENT
    private static void deleteStudent() throws Exception {
        System.out.print("Enter Student ID to Delete: ");
        int id = readIntSafe();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .DELETE()
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("\nResponse: " + res.body());
    }
}
