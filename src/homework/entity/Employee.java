package homework.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("name: %-10s age: %-4d salary: %-9.2f", name, age, salary);
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("Alice", 18, 16800.0));
        list.add(new Employee("Bob", 31, 19000.0));
        list.add(new Employee("Candice", 29, 88000.0));
        list.add(new Employee("David", 26, 10000.0));
        list.add(new Employee("Grand", 22, 12600.0));

        for (Employee e : list) {
            System.out.println(e);
        }
    }
}
