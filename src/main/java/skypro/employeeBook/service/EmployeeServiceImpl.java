package skypro.employeeBook.service;

import org.springframework.stereotype.Service;
import skypro.employeeBook.dto.Employee;
import skypro.employeeBook.exeption.EmployeeAlreadyAddedException;
import skypro.employeeBook.exeption.EmployeeNotFoundException;
import skypro.employeeBook.exeption.EmployeeStorageIsFullException;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeesMap;

    private static final int EMPLOYEES_SIZE = 3;

    public EmployeeServiceImpl() {
        this.employeesMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employeesMap.size() == EMPLOYEES_SIZE) {
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firstName, lastName);
        String key = generateKey(firstName, lastName);

        if (employeesMap.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }

        employeesMap.put(key, employee);

        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        String key = generateKey(firstName, lastName);

        Employee employee = employeesMap.remove(key);

        if (employee == null) {

            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {

        String key = generateKey(firstName, lastName);

        Employee employee = employeesMap.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    @Override
    public Collection<Employee> findAll(){

        return employeesMap.values();
    }



    private String generateKey(String firstName, String lastName) {
        return firstName + lastName;

    }
}

