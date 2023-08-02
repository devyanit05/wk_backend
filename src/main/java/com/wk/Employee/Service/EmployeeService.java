/*---------------------------------------------------------------------
  --------------------------*Service (Interface)*------------------------
---------------------------------------------------------------------*/

package com.wk.Employee.Service;

import com.wk.Employee.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee emp);

    List<Employee> getAll();

    List<Employee> getFiltered();

    String deleteAllEmp();

    Employee deleteEmpById(Long id);

    Employee updateEmpById(Employee emp, Long id);

    Employee updatePatch(Employee emp, Long id);




}
