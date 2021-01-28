import java.util.Arrays;
import java.util.Scanner;


public class RegistandOrg {
    public static void main(String[] args){
        System.out.println("Welcome to the Student Registration Form!");
        System.out.println("Enter your name and then surname:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner = new Scanner(System.in);
        String surname = scanner.nextLine();
        StudentWithActivity newStudent = new StudentWithActivity(name, surname);

        System.out.println("Now we`d like you to enter the day, month and year of your birth:");
        scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        newStudent.setDateOfBirth(day, month, year);

        System.out.println("Then enter your faculty and then speciality:");
        scanner = new Scanner(System.in);
        String faculty = scanner.nextLine();
        newStudent.setRelevantFaculty(faculty);

        scanner = new Scanner(System.in);
        String speciality = scanner.nextLine();
        newStudent.setRelevantSpeciality(speciality);

        System.out.println("Then enter your course:");
        scanner = new Scanner(System.in);
        int course = scanner.nextInt();
        newStudent.setCourse(course);

        System.out.println("Enter your hometown:");
        scanner = new Scanner(System.in);
        String hometown = scanner.nextLine();
        newStudent.setHometown(hometown);

        System.out.println("Here you can see our organizations: ");
        Organizations[] organizations = Organizations.values();
        for (Organizations s : organizations) { System.out.println(s);}
        System.out.println("Choose any you want to take part or none of it and enter the number of a variant you`ve chosen: ");
        scanner = new Scanner(System.in);
        newStudent.chooseOrganization(scanner.nextInt());

        System.out.println(newStudent);
    }
}

