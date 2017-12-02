package org.PatientsManage.Doctor;

import java.util.List;

import org.PatientsManage.HibernateConfig.HibernateConfiguration;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private HibernateConfiguration hibernateConfiguration;
    
    public Doctor getDoctor(String username) {
	
	Doctor doctor = (Doctor) doctorRepository.findOne(username);
	return doctor;
    }
    public List<Doctor> getAllDoctor() {
	
	return null;
    }
    public Doctor getAvailableDoctor(String department) {
	
	SessionFactory sessionFactory =  hibernateConfiguration.getSessionFactory();
	
	Query query = sessionFactory.openSession().createQuery("from Doctors where department = ?");
	query.setString(0, department);
	
	List<Doctor> doctors = query.list();
	System.out.println(doctors.size());
	if(!doctors.isEmpty()) {
	    
	    for(Doctor doctor:doctors) {
		
		if(doctor.getStatus().equalsIgnoreCase("online")) {
		    return doctor;
		}
	    }
	}
	System.out.println("Hello");
	return null;
    }
    
    public void changeStatus(String status,String username) {
	
	Doctor doctor = doctorRepository.findOne(username);
	doctor.setStatus(status);
	doctorRepository.save(doctor);
    }
    
}
