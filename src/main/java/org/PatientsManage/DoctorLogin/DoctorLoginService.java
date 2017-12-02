package org.PatientsManage.DoctorLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorLoginService {

    @Autowired
    private DoctorLoginRepository doctorLoginRepository;

    public DoctorLogin getLoginCredential(String username) {

	return (DoctorLogin) doctorLoginRepository.findOne(username);
    }

    public boolean isValidLoginCredential(String username, String password) {

	if (doctorLoginRepository.exists(username)) {

	    String usernameDB = doctorLoginRepository.findOne(username).getUsername();
	    String passwordDB = doctorLoginRepository.findOne(username).getPassword();

	    if (usernameDB.equalsIgnoreCase(username) && passwordDB.equalsIgnoreCase(password))
		return true;
	    else
		return false;
	} else
	    return false;
    }
}