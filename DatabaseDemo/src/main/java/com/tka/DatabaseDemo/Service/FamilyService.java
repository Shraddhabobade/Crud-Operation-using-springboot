package com.tka.DatabaseDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.DatabaseDemo.dao.FamilyDao;
import com.tka.DatabaseDemo.entity.Family;

@Service
public class FamilyService {

	@Autowired
	//save data
	FamilyDao dao;
	
	public String insertData(Family f) {
		String msg = dao.insertData(f);
		return msg;
	}

		//update data
	public String updateData(int id, Family f) {
		String msg=dao.updateData(id, f);
		return "msg";
		
	}
	//delete data
	public String deleteData(int id) {
		String msg=dao.deleteData(id);
		return "msg";
	}
	//get perticular record
	public Family GetPerticularRecord(int id) {
	Family f	=dao.getPerticularRecord(id);
	return f;
	}
	
	//getAll record
	public List<Family> getAllRecord() {
		List<Family> family=dao.getAllRecord();
		return family;
		
	}
}
