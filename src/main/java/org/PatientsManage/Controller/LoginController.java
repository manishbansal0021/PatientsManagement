package org.PatientsManage.Controller;

import org.PatientsManage.Doctor.Doctor;
import org.PatientsManage.Doctor.DoctorService;
import org.PatientsManage.DoctorLogin.DoctorLogin;
import org.PatientsManage.DoctorLogin.DoctorLoginService;
import org.PatientsManage.Patients.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private DoctorLoginService doctorLoginService;
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private PatientService patientService;
    
    @RequestMapping(value="/ValidateLogin" , method=RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("TempDoctor") DoctorLogin tempDoctor) {
	
	if(doctorLoginService.isValidLoginCredential(tempDoctor.getUsername(), tempDoctor.getPassword())) {
	    
	    Doctor doctor = (Doctor)doctorService.getDoctor(tempDoctor.getUsername());
	    ModelAndView modelandview = new ModelAndView("DoctorPanel");
	    int count = patientService.getCount(doctor.getDepartment());
	    modelandview.addObject("TotalPatients",count);
	    modelandview.addObject("Doctor",doctor);
	    return modelandview;
	}
	else {
	    return new ModelAndView("404");
	}
    }
    
    @RequestMapping(value = "/LoginDoctor", method = RequestMethod.GET)
    public ModelAndView getLoginForm() {
	
	return new ModelAndView("DoctorLoginPage");
    }
    
    public void Loggedin() {
	
    }
}