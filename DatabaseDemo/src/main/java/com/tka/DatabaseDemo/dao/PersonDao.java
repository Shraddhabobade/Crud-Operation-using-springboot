package com.tka.DatabaseDemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.DatabaseDemo.entity.Person;


@Repository
public class PersonDao {
	@Autowired
	SessionFactory factory;
	
	public String insertData(Person p) {
		
			Session session= factory.openSession();
			session.beginTransaction();
			session.persist(p);
			session.getTransaction().commit();
			session.close();
			return "Record is Saved";
	}
	//update data
		public String updateData(int id, Person p) {
			Session session=factory.openSession();
			session.beginTransaction();
			
			Person dbrecord =session.get(Person.class, id);
			dbrecord.setFname(p.getFname());
			dbrecord.setEmailid(p.getEmailid());
			dbrecord.setMobileno(p.getMobileno());
			
		session.merge(dbrecord);
		return "data is updated...";
		}
		
		//delete data
		public String deleteData(int id) {
			Session session=factory.openSession();
		         session.beginTransaction();
		         
		         Person p=session.get(Person.class, id);
		         session.remove(p);
		         session.getTransaction().commit();
		         session.close();
			return "record is deleted";
			
		}
		
		//get perticular record
		public Person getPerticularRecord(int id) {
		     Session session= factory.openSession();
		     session.beginTransaction();
		    
		     String hqlQuery="from Family where id=:myid";
		   Query<Person>query= session.createQuery(hqlQuery,Person.class);
			query.setParameter("myid", id);
			
			Person p=query.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return p;
		}
			//get All record
			public List<Person> getAllRecord() {
			    Session session=factory.openSession();
			    session.beginTransaction();
			    
			    String hqlQry="from Family";
			    Query<Person> person=session.createQuery(hqlQry,Person.class);
		List<Person> list	=person.list();
		session.getTransaction().commit();
		session.close();
		return list;
			}
}


