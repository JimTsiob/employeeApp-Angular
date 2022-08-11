package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repo){
        employeeRepository = repo;
    }

    @Override
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id,Employee employee){
        //Optional<Employee> temp = employeeRepository.findEmployeeById(id).orElseThrow(()->new RuntimeException("Did not find employee with id : " + id));
        Employee user = employeeRepository.findEmployeeById(id).orElseThrow(() -> new RuntimeException("Did not find employee with id : " + id));
        employeeRepository.delete(user);
    }

    @Override
    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new RuntimeException("Did not find employee with id : " + id));
    }
}
