/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollmanagementsystem;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private double monthlySalary;
    private double overtimeHours;
    private double overtimeRate;

    

    public Employee(String firstName, String lastName,
                    String position, double monthlySalary, double overtimeHours, double overtimeRate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.monthlySalary = monthlySalary;
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    public double getOvertimeHours() {
    return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
    this.overtimeHours = overtimeHours;
    }

    public double getOvertimeRate() {
    return overtimeRate;
    }

    public void setOvertimeRate(double overtimeRate) {
    this.overtimeRate = overtimeRate;
    }
    
}