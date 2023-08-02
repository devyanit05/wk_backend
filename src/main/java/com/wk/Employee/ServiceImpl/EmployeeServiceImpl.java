/*---------------------------------------------------------------------
  -----------------*ServiceImplementation (Class)*------------------
---------------------------------------------------------------------*/

package com.wk.Employee.ServiceImpl;

import com.wk.Employee.Entity.Employee;
import com.wk.Employee.Exception.ResourceNotFoundException;
import com.wk.Employee.Repository.EmployeeRepository;
import com.wk.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    @Override
    public Employee create(Employee emp) {
        return empRepo.save(emp);
    }

    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    public List<Employee> getFiltered(){
        List<Employee> l1 = empRepo.findAll();
        List<Employee> listOfEmployee = l1.stream().filter(i -> i.getSalary() > 1600000).collect(Collectors.toList());

        return listOfEmployee;
    }

    public String deleteAllEmp(){
        empRepo.deleteAll();
        return "All Employees fired!";
    }

    public Employee deleteEmpById(Long id){
        Optional<Employee> currentEmployee = empRepo.findById(id);

        if(currentEmployee.isPresent()){
            empRepo.deleteById(id);
            return currentEmployee.get();
//            return "Employee fired";
        }else{
//            return "Employee not present";
            throw new ResourceNotFoundException("Employee is not present in DB.");
        }
    }

    public Employee updateEmpById(Employee emp, Long id){
        Optional<Employee> currentEmployee = empRepo.findById(id);
        if(currentEmployee.isPresent()){
            empRepo.save(emp);
        }
        /*if(currentEmployee.isPresent()){
            Employee presentEmp = currentEmployee.get();
            presentEmp.setName(emp.getName());
            presentEmp.setSalary(emp.getSalary());
        }*/
        return currentEmployee.get();
    }

    public Employee updatePatch(Employee emp, Long id){
        Optional<Employee> currentEmployee = empRepo.findById(id);
        if(currentEmployee.isPresent()){
            //currentEmployee.get().setId(id);
            currentEmployee.get().setName(emp.getName());
            //currentEmployee.get().setSalary(emp.getSalary());
            empRepo.save(currentEmployee.get());
        }
        return currentEmployee.get();
    }
}
