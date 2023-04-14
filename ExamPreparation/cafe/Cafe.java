package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if(this.employees.size() < this.capacity){
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){
        return employees.removeIf(employee -> employee.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        return employees.stream().max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }
    public Employee getEmployee(String name){
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }
    public int getCount(){
        return employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:",this.name));
        sb.append(System.lineSeparator());
        employees.forEach(employee -> sb.append(String.format("%s%n", employee.toString())));
        return sb.toString().trim();
    }
}
