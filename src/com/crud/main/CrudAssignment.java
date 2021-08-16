package com.crud.main;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import com.crud.Controller.EmployeeCRUD;

public class CrudAssignment {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static EmployeeCRUD db = new EmployeeCRUD();
    public static void main(String[] args) throws Exception {

        // TODO Auto-generated method stub

        String option = "";
        do {
            System.out.println("");
            System.out.println("C Create new Employee Details");
            System.out.println("R Get All Employee");
            System.out.println("U Update Employee By Id");
            System.out.println("D Delete Employee By Id");
            System.out.println("O Get Particular Employee By Id");
            System.out.println("E Exist");
            System.out.println("---------------------");
            System.out.println("Enter an options C R U D");
            System.out.println("---------------------");
            option = br.readLine();
            System.out.println("\n");

            switch(option.toUpperCase()) {
                case "C":
                    createEmployee();
                    break;
                case "R" :
                    getAllEmployee();
                    break;
                case "U":
                    updateEmployee();
                    break;
                case "D":
                    deleteEmployee();
                    break;
                case "E":
                    System.out.println("******************************Thankyou******************** For Continue Please Restart your Application Again*************************************");
                    System.exit(0);
                    break;
                case "O":
                    getEmployeeById();
                    break;
                default:
                    System.out.println("Invalid Option! Please enter again with correct option");
                    break;

            }

        } while(!option.equals("E"));
    }

    private static void getEmployeeById()  {
        // TODO Auto-generated method stub
        db.getEmployeeById();
    }

    private static void createEmployee() throws Exception {
        db.createEmployee();
    }
    private static void getAllEmployee() {
        // TODO Auto-generated method stub
        db.getAllEmployee();

//		List<Employee> employeeList = db.getAllEmployee();
//		//here fetch all employee from getAllEmployee function
//		for(Employee emp : employeeList) {
//			displayEmployee(emp);
//		}
//		System.out.println("\n");
    }

    private static void updateEmployee() throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        db.updatedEmployee();
    }

    private static void deleteEmployee() throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        db.deleteEmployee();
    }
}