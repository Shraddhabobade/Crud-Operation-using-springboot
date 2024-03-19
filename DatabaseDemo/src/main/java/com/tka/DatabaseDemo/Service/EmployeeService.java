package com.tka.DatabaseDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.DatabaseDemo.dao.EmployeeDao;
import com.tka.DatabaseDemo.entity.Employee;



	@Service
	public class EmployeeService {
	    @Autowired
	    EmployeeDao dao;
	   
		//save data
		public String insertData(Employee e) {
			String msg = dao.insertData(e);
			return msg;
		}

			//update data
		public String updateData(int id, Employee e) {
			String msg=dao.updateData(id, e);
			return "msg";
			
		}
		//delete data
		public String deleteData(int id) {
			String msg=dao.deleteData(id);
			return "msg";
		}
		//get perticular record
		public Employee GetPerticularRecord(int id) {
			Employee e	=dao.getPerticularRecord(id);
		return e;
		}
		
		//getAll record
		public List<Employee> getAllRecord() {
			List<Employee> family=dao.getAllRecord();
			return family;
			
		}
	}


