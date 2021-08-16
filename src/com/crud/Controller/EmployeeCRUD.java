package com.crud.Controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import com.crud.model.Employee;

public class EmployeeCRUD {
    public static final String ANSI_GREEN = "\u001B[32m"; // color
    public static final String ANSI_BLUE = "\u001B[34m";//color
    public static final String ANSI_PURPLE = "\u001B[35m"; // color
    public static final String ANSI_YELLOW = "\u001B[33m"; // color

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Faster,Much more efficient for reading files
    static List<Employee> list = new LinkedList<>(); // Stored our data inside Linked List
    static Iterator<Employee> itr; // used for set value in list and that's why I used this class
    static boolean found; // helper


    //Get All Employee Information
    public void getAllEmployee() {

        try
        {
            System.out.println("hello from get Request");
            System.out.println(ANSI_BLUE+"Employee_Id----------Employee_Name----------Employee_Salary");
            System.out.println("-------------------------------------------------------------------------------");
            itr= list.iterator(); // travel and giving one by one data and  iterate over the loop
            Collections.sort(list); // sort the Object by I'd this operation done in my Employee class look over there, Comparable functional interface
            while(itr.hasNext()) { // if data present it run continue till the end it returns boolean value
                Employee emp = itr.next(); // next data inside itr and it stored inside emp then print the data
                System.out.println(ANSI_PURPLE+emp);
            }
            //System.out.println(list);
            System.out.println("-------------------------------------------------------------------------------");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    //Creating new employee
    public void createEmployee() {

        try
        {

            // TODO Auto-generated method stub
            System.out.println("hello from create Request");
            System.out.println("\n");
            System.out.println(ANSI_YELLOW+"Please Enter  Id");
            long employeeId= Long.parseLong(br.readLine()); //input
            System.out.println("\n");
            System.out.println(ANSI_YELLOW+"Please Enter  Name");
            String employeeName = br.readLine(); //input
            if(employeeName == "") {
                System.out.println("name must required:=>"+employeeName);
            }
            if(StringErrorHandling(employeeName) == true) {
                throw new InputError("Please Enter more than 2 Character Or May be You have Entered Special Symbol");
            }
            System.out.println("\n");
            System.out.println(ANSI_YELLOW+"Please Enter  Salary");
            int employeeSalary= Integer.parseInt(br.readLine()); //input
            if(employeeSalary < 0 ) {
                throw new InputError("Please Enter Positive Number, You value is ->"+employeeSalary);
            }
            System.out.println("\n");
            if(employeeId < 0 ) {
                throw new InputError("Please Enter Positive Number, You value is ->"+employeeId);
            }

            if(containsEmployeeId(list, employeeId) == true) { //this is for checking Id, Present or Not
                // contains the id
                throw new InputError("User Id Already Exist");
            } else {
                // does not contain the id
                list.add(new Employee(employeeId,employeeName,employeeSalary));
                if(list.isEmpty()) { // if list are empty this block execute
                    System.out.println(ANSI_YELLOW+"Try again because data haven't filled yet");
                }
                else {
                    System.out.println(ANSI_GREEN+"Successfull data inserted");
                }

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    //This function is for the checking id , if id is present in our list it return true , by the help of this function we can check duplicate id is there or not
    private static boolean containsEmployeeId(List<Employee> EmployeeInfo, long id) {
        for (Employee emp : EmployeeInfo) { //enhance loop
            if (emp.getId() == id) { // I used getId(), if my current id is existed inside my employee object emp.getId() it returns true
                return true;
            }
        }
        return false;
    }

    // this function is responsible for updating Employee Object for updating i have used unique field is called id
    public void updatedEmployee() {
        // TODO Auto-generated method stub

        try
        {

            System.out.println("hello from update Request");
            System.out.println("Please Enter Employee Id for Updation");
            long employeeId = Long.parseLong(br.readLine()); //input
            if(employeeId < 0 ) {
                throw new InputError("Please fil positive number in Id field :=>"+employeeId);
            }
            System.out.println("****************");
            ListIterator<Employee> li = list.listIterator();
            found = false;
            while(li.hasNext()) {
                Employee emp1 = li.next();
                if(emp1.getId() == employeeId) {
                    System.out.println("Enter New Name");
                    String employeeName = br.readLine();
                    if(employeeName == "") {
                        throw new InputError("Please fill name in name field");
                    }
                    if(StringErrorHandling(employeeName)==true) {
                        throw new InputError("Please Enter More than 2 character Or May be you have entered Special Symbol");
                    }
                    System.out.println("Enter New Salary");
                    int employeeSalary = Integer.parseInt(br.readLine());
                    if(employeeSalary == 0 ||employeeSalary < 0 ) {
                        throw new InputError("Salary should greater than 0");
                    }
                    li.set(new Employee(employeeId,employeeName,employeeSalary));
                    found = true;
                }
            }
            if(!found) {
                System.out.println("Incorrect! Id is not Found");
            } else {
                System.out.println("Data updated Successfully");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    // this function this responsible for delete particular Employee Information by Id
    public void deleteEmployee() {


        try
        {
            System.out.println("hello from delete Request");
            System.out.println("Enter Employee Id");
            long employeeId1 = Long.parseLong(br.readLine());
            System.out.println("------------------------------");
            found = false;
            itr = list.iterator();
            while(itr.hasNext()) {
                Employee emp = itr.next();
                if(emp.getId() == employeeId1) {
                    itr.remove(); //remove data from employee object
                    found = true;
                }
            }
            if(!found) {
                System.out.println("Id Not Exist");
            } else {
                System.out.println("oh yeah!! Record delete Successfully");
            }
            System.out.println("------------------------------");


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    // Responsible for fetching particular Employee Information from Object
    public void getEmployeeById(){

        try
        {
            System.out.println("hello from get Employee By Id");
            System.out.println("Enter Employee Id");
            long employeeId = Long.parseLong(br.readLine());
            System.out.println("------------------------------------------------------------");
            found = false;
            itr = list.iterator();
            while(itr.hasNext()) {
                Employee emp = itr.next();
                if(emp.getId() == employeeId) {
                    System.out.println(emp);
                    found = true;
                }
            }
            if(!found) {
                System.out.println("Id Not Exist");
            }
            System.out.println("------------------------------------------------------------");


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    //String error handling function
    private static boolean StringErrorHandling(String str) {
        char[] ch1 = new char[str.length()]; // here I have converted String into Char array
        String special = "!@#$%&*()\'+,-./:;<=>?[]^_`{|}"; // if string having special char or not
        for(int i = 0; i < str.length(); i++) {
            ch1[i] = str.charAt(i);
            char ch = str.charAt(i);
            if(special.contains(Character.toString(ch))) {
                return true;
            }
        }
        if(ch1.length<3) {
            return true;
        }
        return false;
    }
}
