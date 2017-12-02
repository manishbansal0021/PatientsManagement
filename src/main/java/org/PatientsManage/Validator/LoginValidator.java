package org.PatientsManage.Validator;

import org.PatientsManage.DoctorLogin.DoctorLoginService;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginValidator {

    private String username;
    private String password;
    
    @Autowired
    private DoctorLoginService doctorloginService;
    
    
    public LoginValidator(String username,String password) {
	
	this.username=username;
	this.password=password;
    }
    public boolean isValid() {
	
	String usernameDB = doctorloginService.getLoginCredential(username).getUsername();
	String passwordDB = doctorloginService.getLoginCredential(username).getPassword();
	
	System.out.println(usernameDB+"," +passwordDB);
	
	if(usernameDB.equalsIgnoreCase(username)&& passwordDB.equalsIgnoreCase(password))
	    return true;
	else return false;
	
	
    }
    
}
