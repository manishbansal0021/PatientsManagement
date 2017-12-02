package org.PatientsManage.Controller;

import org.PatientsManage.Doctor.Doctor;
import org.PatientsManage.Doctor.DoctorService;
import org.PatientsManage.Patients.Patient;
import org.PatientsManage.Patients.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;
    
    @Autowired
    private DoctorService doctorService;
    
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public ModelAndView HomePage() {
	
	return new ModelAndView("HomePage");
    }
    @RequestMapping(value="/Registered", method=RequestMethod.POST)
    public ModelAndView registeredPatient(@ModelAttribute("PatientDetails")Patient patient) {
	
	patientService.SavePatientDetails(patient);
	ModelAndView modelandview = new ModelAndView("welcome");
	   
	Doctor doctor = doctorService.getAvailableDoctor(patient.getDepartment());
	
	System.out.println("Hello1");
	if(doctor==null) {
	    Doctor nulldoctor = new Doctor();
	    nulldoctor.setName("Not Available");
	    modelandview.addObject("Doctor", nulldoctor);
	}
	else  modelandview.addObject("Doctor", doctor);
	
	modelandview.addObject("Patient",patient);
	
	return modelandview;
	
    }
    
    
}
