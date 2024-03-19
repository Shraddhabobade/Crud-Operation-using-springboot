package com.tka.DatabaseDemo.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.DatabaseDemo.entity.Family;

@Repository
public class FamilyDao {
	
	@Autowired
	
	//save data
	SessionFactory fac;
	public String insertData(Family f) {
		Session session = fac.openSession();
		session.beginTransaction();
		session.persist(f);
		session.getTransaction().commit();
		session.close();
		return "Data inserted";
	}
	
	//update data
	public String updateData(int id, Family f) {
		Session session=fac.openSession();
		session.beginTransaction();
		
		Family dbrecord =session.get(Family.class, id);
		dbrecord.setAadharno(f.getAadharno());;
		dbrecord.setPassportno(f.getPassportno());
		dbrecord.setDrivinglicno(f.getDrivinglicno());
		
	session.merge(dbrecord);
	return "data is updated...";
	}
	
	//delete data
	public String deleteData(int id) {
		Session session=fac.openSession();
	         session.beginTransaction();
	         
	         Family f=session.get(Family.class, id);
	         session.remove(f);
	         session.getTransaction().commit();
	         session.close();
		return "record is deleted";
		
	}
	
	//get perticular record
	public Family getPerticularRecord(int id) {
	     Session session= fac.openSession();
	     session.beginTransaction();
	    
	     String hqlQuery="from Family where id=:myid";
	   Query<Family>query= session.createQuery(hqlQuery,Family.class);
		query.setParameter("myid", id);
		
		Family f=query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return f;
	}
		//get All record
		public List<Family> getAllRecord() {
		    Session session=fac.openSession();
		    session.beginTransaction();
		    
		    String hqlQry="from Family";
		    Query<Family> family=session.createQuery(hqlQry,Family.class);
	List<Family> list	=family.list();
	session.getTransaction().commit();
	session.close();
	return list;
		}
		
		
	
}
