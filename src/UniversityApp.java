import java.util.Scanner;

public class UniversityApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University uni = new University();
        int choice = 0;

        do {
            System.out.println("\n--- University Course Registration ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Register Course");
            System.out.println("4. Drop Course");
            System.out.println("5. Show Course List");
            System.out.println("6. Show Fees Report");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            // Input error handling
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String sId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String sName = scanner.nextLine();
                    System.out.print("Type (1 = Undergraduate, 2 = Postgraduate): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type == 1) {
                        uni.addStudent(new UndergraduateStudent(sId, sName));
                        System.out.println("Undergraduate student added.");
                    } else if (type == 2) {
                        uni.addStudent(new PostgraduateStudent(sId, sName));
                        System.out.println("Postgraduate student added.");
                    } else {
                        System.out.println("Invalid student type.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Course Code: ");
                    String cCode = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String cTitle = scanner.nextLine();
                    System.out.print("Enter Credits (1-6): ");
                    int credits = scanner.nextInt();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Lecturer Name: ");
                    String lecturer = scanner.nextLine();

                    uni.addCourse(new Course(cCode, cTitle, credits, capacity, lecturer));
                    System.out.println("Course added successfully.");
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String regSId = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    String regCCode = scanner.nextLine();
                    if (uni.register(regSId, regCCode)) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Registration failed! (Check limits, capacity or duplicates).");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    String dropSId = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    String dropCCode = scanner.nextLine();
                    if (uni.drop(dropSId, dropCCode)) {
                        System.out.println("Course dropped successfully.");
                    } else {
                        System.out.println("Failed to drop course.");
                    }
                    break;
                case 5:
                    uni.showCourseList();
                    break;
                case 6:
                    uni.printFeeReport();
                    break;
                case 7:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid option! Select between 1-7.");
            }
        } while (choice != 7);

        scanner.close();
    }
}