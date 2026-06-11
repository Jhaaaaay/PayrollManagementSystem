
package payrollmanagementsystem;
import java.sql.*;

public class EmployeeDAO {

    Connection conn = DBConnection.getConnection();

 
    public void addEmployee(Employee emp) {

            String sql = "INSERT INTO employees(first_name, last_name, position, monthly_salary, overtime_hours, overtime_rate) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, emp.getFirstName());
            pst.setString(2, emp.getLastName());
            pst.setString(3, emp.getPosition());
            pst.setDouble(4, emp.getMonthlySalary());
            pst.setDouble(5, emp.getOvertimeHours());
            pst.setDouble(6, emp.getOvertimeRate());

            pst.executeUpdate();
            System.out.println("Employee Added Successfully!");

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }


    public void viewEmployees() {

        String sql = "SELECT * FROM employees";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nEMPLOYEE LIST");
            System.out.println("-----------------------------------------");

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("employee_id") +
                        " | Name: " + rs.getString("first_name") + " " + rs.getString("last_name") +
                        " | Position: " + rs.getString("position") +
                        " | Salary: " + rs.getDouble("monthly_salary")   
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateSalary(int id, double newSalary) {

        String sql = "UPDATE employees SET monthly_salary = ? WHERE employee_id = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setDouble(1, newSalary);
            pst.setInt(2, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Salary Updated Successfully!");
            } else {
                System.out.println("Employee Not Found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Deleted Successfully!");
            } else {
                System.out.println("Employee Not Found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
    public void computePayroll(int id) {

        String sql = "SELECT * FROM employees WHERE employee_id = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                double salary = rs.getDouble("monthly_salary");

                double sss = salary * 0.05;
                double tax = salary * 0.10;
                double pagibig = salary * 0.02;
                double overtimeHours =
                rs.getDouble("overtime_hours");

                double overtimeRate =
                rs.getDouble("overtime_rate");

                double overtimePay =
                overtimeHours * overtimeRate;
                
                double totalDeduction = sss + tax + pagibig;
                double netSalary =
                salary + overtimePay - totalDeduction;

                System.out.println("\nPAYROLL DETAILS");
                System.out.println("----------------------------------");
                System.out.println("Employee: " + rs.getString("first_name") + " " + rs.getString("last_name"));
                System.out.println("Basic Salary: " + salary);
                System.out.println("SSS Deduction: " + sss);
                System.out.println("Tax Deduction: " + tax);
                System.out.println("Pag-IBIG Deduction: " + pagibig);
                System.out.println("Overtime Hours: "+ overtimeHours);
                System.out.println("Overtime Rate: " + overtimeRate);
                System.out.println("Overtime Pay: " + overtimePay);
                System.out.println("Net Salary: " + netSalary);
                

            } else {
                System.out.println("Employee Not Found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateOvertime(int employeeId,
                           double overtimeHours,
                           double overtimeRate) {

            String sql = "UPDATE employees SET overtime_hours=?, overtime_rate=? WHERE employee_id=?";

        try {

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setDouble(1, overtimeHours);
        pst.setDouble(2, overtimeRate);
        pst.setInt(3, employeeId);

        int rows = pst.executeUpdate();

        if(rows > 0) {
            System.out.println("Overtime Updated Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }

        } catch(SQLException e) {
                 e.printStackTrace();
        }
    }
}
