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

import com.tka.DatabaseDemo.Service.FamilyService;
import com.tka.DatabaseDemo.entity.Family;

@RestController
@RequestMapping("/fam")
public class FamilyControler {
    
    @Autowired
    FamilyService service;
    
    @PostMapping("/famdata")
    public String insertData(@RequestBody Family f) {
        String msg = service.insertData(f);
        return msg;
    }
    
    
//update data
    @PutMapping("/updatedata/{id}")
    public String updateRecord(@PathVariable int id,@RequestBody Family p) {
    	
    	String msg=service.updateData(id,p);
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
		public Family getPerticularRecordById(@PathVariable int id) {
			    Family f=service.GetPerticularRecord(id);
			    return f;
			
		}
		
		//getAll record 
		@GetMapping("/getAll")
		public List<Family> getAllRecord(){
			List<Family> family=service.getAllRecord();
			return family ;
			
		}
    	
		
    
}