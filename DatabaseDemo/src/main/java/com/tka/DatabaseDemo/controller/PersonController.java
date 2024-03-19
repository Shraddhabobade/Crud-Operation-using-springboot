package com.tka.DatabaseDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.DatabaseDemo.Service.PersonService;

import com.tka.DatabaseDemo.entity.Person;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@PostMapping("/savedata")
	public String saveRecord(@RequestBody Person p) {
		System.out.println(p);
		
		String msg= service.InsertData(p);
		return msg;
		
	}
	//update data
    @PutMapping("/updatedata/{id}")
    public String updateRecord(@PathVariable int id,@RequestBody Person p) {
    	
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
		public Person getPerticularRecordById(@PathVariable int id) {
			   Person p=service.GetPerticularRecord(id);
			    return p;
			
		}
		
		//getAll record 
		@GetMapping("/getAll")
		public List<Person> getAllRecord(){
			List<Person> p=service.getAllRecord();
			return p ;
	
}

}