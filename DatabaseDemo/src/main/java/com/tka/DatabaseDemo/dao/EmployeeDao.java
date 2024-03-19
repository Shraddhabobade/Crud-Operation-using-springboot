package com.tka.DatabaseDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.DatabaseDemo.entity.Employee;



@Repository
public class EmployeeDao {
@Autowired
	
	//save data
	SessionFactory fac;
	public String insertData( Employee e) {
		Session session = fac.openSession();
		session.beginTransaction();
		session.persist(e);
		session.getTransaction().commit();
		session.close();
		return "Data inserted";
	}
	
	//update data
	public String updateData(int id, Employee e) {
		Session session=fac.openSession();
		session.beginTransaction();
		
		Employee dbrecord =session.get(Employee.class, id);
		dbrecord.setName(e.getName());
		dbrecord.setEmail(e.getEmail());
		dbrecord.setMobileno(e.getMobileno());
	session.merge(dbrecord);
	return "data is updated...";
	}
	
	//delete data
	public String deleteData(int id) {
		Session session=fac.openSession();
	         session.beginTransaction();
	         
	         Employee e=session.get(Employee.class, id);
	         session.remove(e);
	         session.getTransaction().commit();
	         session.close();
		return "record is deleted";
		
	}
	
	//get perticular record
	public Employee getPerticularRecord(int id) {
	     Session session= fac.openSession();
	     session.beginTransaction();
	    
	     String hqlQuery="from Family where id=:myid";
	   Query<Employee>query= session.createQuery(hqlQuery,Employee.class);
		query.setParameter("myid", id);
		
		Employee e=query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return e;
	}
		//get All record
		public List<Employee> getAllRecord() {
		    Session session=fac.openSession();
		    session.beginTransaction();
		    
		    String hqlQry="from Family";
		    Query<Employee> family=session.createQuery(hqlQry,Employee.class);
	List<Employee> list	=family.list();
	session.getTransaction().commit();
	session.close();
	return list;
		}
		
		
	
}


