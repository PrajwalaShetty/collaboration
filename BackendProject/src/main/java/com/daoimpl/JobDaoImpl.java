package com.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.JobDao;
import com.model.Job;

@Repository
public class JobDaoImpl implements JobDao {
	@Autowired
private SessionFactory sessionFactory;
	
	@Override
	public void postJob(Job job) {
		Session session=sessionFactory.openSession();
	//	job.setCreatedBy(user);
		session.save(job);
		session.flush();
		session.close();

	}

	@Override
	public List<Job> getAllJobs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> jobs=query.list();
		session.close();
		return jobs;
	}

	@Override
	public Job updateJob(int id, Job job) {
		//job -> modified value -> 226
		Session session=sessionFactory.openSession();
		//current job -> 226
		//currentPerson, job -> with same id
		//updating only variable job
		//notunique
		//select [before modification]
		
		System.out.println("edit blog1");
		Job currentJob=(Job)session.get(Job.class, id);//persistent
		if(currentJob==null) //id doesnt exist in the database
			return null;
		//to modify [update]
		session.merge(job); //update query where personid=?
		//select [after modification]
		Job updatedJob=(Job)session.get(Job.class, id); //select query
		session.flush();
		session.close();
		return updatedJob;
	}

	@Override
	public void deleteJob(int id) {
		Session session = sessionFactory.openSession();
		// it makes the object persistent - person
		Job job = (Job)session.get(Job.class,id);
		session.delete(job);
		// transient - person
		session.flush();
		session.close();		
	}

	@Override
	public Job getJob(int id) {
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, id);
		session.close();
		return job;
	}

}