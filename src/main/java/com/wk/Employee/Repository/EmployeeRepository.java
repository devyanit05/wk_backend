/*---------------------------------------------------------------------
  ----------------*EmployeeRepository (Interface)*-----------------
---------------------------------------------------------------------*/

package com.wk.Employee.Repository;

import com.wk.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
