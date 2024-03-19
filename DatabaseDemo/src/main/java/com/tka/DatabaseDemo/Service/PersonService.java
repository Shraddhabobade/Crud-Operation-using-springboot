package com.tka.DatabaseDemo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.DatabaseDemo.dao.PersonDao;
import com.tka.DatabaseDemo.entity.Person;

@Service
public class PersonService {

	@Autowired
	PersonDao dao;
	
	public String InsertData(Person p) {
		
			String msg= dao.insertData(p);
			return msg;
		}
	//update data
		public String updateData(int id, Person p) {
			String msg=dao.updateData(id, p);
			return "msg";
			
		}
		//delete data
		public String deleteData(int id) {
			String msg=dao.deleteData(id);
			return "msg";
		}
		//get perticular record
		public Person GetPerticularRecord(int id) {
		Person p	=dao.getPerticularRecord(id);
		return p;
		}
		
		//getAll record
		public List<Person> getAllRecord() {
			List<Person>person =dao.getAllRecord();
			return person;
			
		}
	}

