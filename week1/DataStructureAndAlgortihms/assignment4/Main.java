import java.util.*;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[" + employeeId + "] " + name + " | " + position + " | $" + salary;
    }
}

class EmployeeManagement {
    Employee[] employees;
    int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee e) {
        if (size == employees.length) {
            System.out.println("Array is full. Cannot add more employees.");
            return;
        }
        employees[size++] = e;
        System.out.println("Employee added: " + e);
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void listEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--size] = null;
        System.out.println("Employee with ID " + id + " deleted.");
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManagement ems = new EmployeeManagement(100); 
        System.out.println("\n========= Employee Management Menu =========");
        System.out.println("1. Add Employee");
        System.out.println("2. Search Employee by ID");
        System.out.println("3. List All Employees");
        System.out.println("4. Delete Employee by ID");
        System.out.println("0. Exit");
        while (true) {

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Position: ");
                    String position = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    ems.addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Search: ");
                    int searchId = sc.nextInt();
                    Employee e = ems.searchEmployee(searchId);
                    System.out.println(e != null ? e : "Employee not found.");
                    break;

                case 3:
                    System.out.println("\n📋 Employee List:");
                    ems.listEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int delId = sc.nextInt();
                    ems.deleteEmployee(delId);
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
