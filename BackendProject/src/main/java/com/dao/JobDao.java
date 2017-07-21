package com.dao;

import java.util.List;

import com.model.Job;
import com.model.PROJ2_USER;

public interface JobDao {
void postJob(Job job);
List<Job> getAllJobs();
Job getJob(int id);

Job updateJob(int id,Job job);
void deleteJob(int id);


//Job getJobById(int jobId);
//List<Job> getJobById(int jobId);
// if we keep it like this we r needed to type cast it in backend controller so changed to Job type here itself

}
