package com.tka.DatabaseDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.DatabaseDemo.Service.EmployeeService;
import com.tka.DatabaseDemo.entity.Employee;


@RestController
@RequestMapping("/apiEmployee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    
    @PostMapping("/savedata")
    public String insertData(@RequestBody Employee e) {
        String msg = service.insertData(e);
        return msg;
    }
    
    
//update data
    @PutMapping("/updatedata/{id}")
    public String updateRecord(@PathVariable int id,@RequestBody Employee e) {
    	
    	String msg=service.updateData(id,e);
		return msg;
    }
    	
		//delete data
		@DeleteMapping("/deleteData/{id}")
		public String deleteData(@PathVariable int id){
			String msg=service.deleteData(id);
			return msg;
		
		}
		//get perticular record
		@GetMapping("/getPerticularData/{id}")
		public Employee getPerticularRecordById(@PathVariable int id) {
			Employee e=service.GetPerticularRecord(id);
			    return e;
			
		}
		
		//getAll record 
		@GetMapping("/getAll")
		public List<Employee > getAllRecord(){
			List<Employee > family=service.getAllRecord();
			return family ;
			
		}
    	
		
    
}