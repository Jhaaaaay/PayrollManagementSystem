package payrollmanagementsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        int choice;

        do {

            System.out.println("\n===== PAYROLL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Compute Payroll");
            System.out.println("6. Update Overtime");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");
            
            while (!sc.hasNextInt()) {
            System.out.println("Characters not supported.");
            sc.next();
            }


            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();

                    System.out.print("Position: ");
                    String position = sc.nextLine();

                    System.out.print("Monthly Salary: ");
                    while (!sc.hasNextInt()) {
                    System.out.println("Please Enter Valid Amount!");
                    sc.next();
                    System.out.print("Monthly Salary: ");
                    }
                    
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    

                    Employee emp = new Employee(firstName, lastName, position, salary, 0, 0);
                    dao.addEmployee(emp);

                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();

                    dao.updateSalary(updateId, newSalary);
                    break;

                case 4:

                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteEmployee(deleteId);
                    break;

                case 5:

                    System.out.print("Enter Employee ID: ");
                    int payrollId = sc.nextInt();

                    dao.computePayroll(payrollId);
                    break;
                case 6:

                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();

                    System.out.print("Overtime Hours: ");
                    double hours = sc.nextDouble();

                    System.out.print("Overtime Rate: ");
                    double rate = sc.nextDouble();

                    dao.updateOvertime(id, hours, rate);

                    break;
                
                case 7:
                    System.out.println("Program Exited.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}