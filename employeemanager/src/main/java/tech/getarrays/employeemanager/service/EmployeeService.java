package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id,Employee employee);
    Employee findEmployeeById(Long id);
}
