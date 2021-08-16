package com.crud.model;

public class Employee implements Comparable<Employee> {
    private long id;
    private String name;
    private int salary;
    public Employee() {
        super();  //super can be used to invoke immediate parent class method.
        // super() can be used to invoke immediate parent class constructor
        // TODO Auto-generated constructor stub
    }
    public Employee(long id, String name, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String toString() {

        return id+"                          "+name+"                  "+salary+"";
    }
    @Override
    public int compareTo(Employee o) {
        // TODO Auto-generated method stub
        return (int) (this.id-o.id);
    }
}