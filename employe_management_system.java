import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int employeeId;
    private String employeeName;
    private String jobTitle;
    private double annualSalary;

    public Employee(int employeeId, String employeeName, String jobTitle, double annualSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.jobTitle = jobTitle;
        this.annualSalary = annualSalary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getJobTitle() { return jobTitle; }
    public double getAnnualSalary() { return annualSalary; }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + employeeName + ", Job Title: " + jobTitle + ", Annual Salary: " + annualSalary;
    }
}

class EmployeeManager {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployeeToSystem(Employee newEmployee) {
        employeeList.add(newEmployee);
        System.out.println("Employee added to the system successfully.");
    }

    public void displayAllEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void removeEmployeeFromSystem(int employeeId) {
        employeeList.removeIf(employee -> employee.getEmployeeId() == employeeId);
        System.out.println("Employee removed from the system successfully.");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner userInput = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println("1. Add a new employee to the system");
            System.out.println("2. View all employees in the system");
            System.out.println("3. Remove an employee from the system");
            System.out.println("4. Exit the system");
            System.out.print("Enter your choice: ");
            userChoice = userInput.nextInt();
            userInput.nextLine(); // Consume newline

            switch (userChoice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int employeeId = userInput.nextInt();
                    userInput.nextLine(); // Consume newline
                    System.out.print("Enter employee name: ");
                    String employeeName = userInput.nextLine();
                    System.out.print("Enter job title: ");
                    String jobTitle = userInput.nextLine();
                    System.out.print("Enter annual salary: ");
                    double annualSalary = userInput.nextDouble();
                    employeeManager.addEmployeeToSystem(new Employee(employeeId, employeeName, jobTitle, annualSalary));
                    break;
                case 2:
                    employeeManager.displayAllEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to remove: ");
                    int idToRemove = userInput.nextInt();
                    employeeManager.removeEmployeeFromSystem(idToRemove);
                    break;
                case 4:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userChoice != 4);

        userInput.close();
    }
}