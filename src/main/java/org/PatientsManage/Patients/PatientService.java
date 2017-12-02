package org.PatientsManage.Patients;

import org.PatientsManage.HibernateConfig.HibernateConfiguration;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private HibernateConfiguration hibernateConfiguration;
    
    
    public void SavePatientDetails(Patient patient) {

	patientRepository.save(patient);
	
    }
    public int getCount(String department) {
	
	SessionFactory sessionFactory =  hibernateConfiguration.getSessionFactory();
	
	Query query = sessionFactory.openSession().createQuery("from Patients where department = ?");
	query.setString(0, department);
	int count = query.list().size();
	
	System.out.println(count);
	return count;
	
	
    }
}
