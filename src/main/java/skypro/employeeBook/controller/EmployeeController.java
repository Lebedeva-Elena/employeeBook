package skypro.employeeBook.controller;

import org.springframework.web.bind.annotation.*;
import skypro.employeeBook.dto.Employee;
import skypro.employeeBook.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee remoteEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee getEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping
    public Collection<Employee> findAll(){
        return employeeService.findAll();
    }

}
