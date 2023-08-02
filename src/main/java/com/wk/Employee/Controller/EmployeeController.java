/*---------------------------------------------------------------------
  --------------------------*Controller (Class)*------------------------
---------------------------------------------------------------------*/

package com.wk.Employee.Controller;

import com.wk.Employee.Entity.Employee;
import com.wk.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@RequestBody Employee emp){
        return ResponseEntity.ok().body(this.empService.create(emp));
    }

    @GetMapping("/getEmp")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok().body(this.empService.getAll());
    }

    @GetMapping("/getFilter")
    public ResponseEntity<List<Employee>> getFiltered(){
        return ResponseEntity.ok().body(this.empService.getFiltered());
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity.HeadersBuilder deleteAllEmp(){
        //return ResponseEntity.ok().body(this.empService.deleteAllEmp());
        this.empService.deleteAllEmp();
        return ResponseEntity.status(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Employee> deleteEmpById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.empService.deleteEmpById(id));
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Employee> updateEmpById(@RequestBody Employee emp, @PathVariable("id") Long id){
        return ResponseEntity.ok().body(this.empService.updateEmpById(emp,id));
    }

    @PatchMapping("/updatePatch/{id}")
    public ResponseEntity<Employee> updatePatch(@RequestBody Employee emp, @PathVariable("id") Long id){
        return ResponseEntity.ok().body(this.empService.updatePatch(emp,id));
    }

}
