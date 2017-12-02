package org.PatientsManage.Doctor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Doctors")
@Table(name = "Doctors")
public class Doctor {

    @Id
    private String username;

    private String name;
    private String Department;
    private String phoneNo;
    private String email;
    private String education;
    private String bioData;
    private String status;
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDepartment() {
	return Department;
    }

    public void setDepartment(String department) {
	Department = department;
    }

    public String getPhoneNo() {
	return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getEducation() {
	return education;
    }

    public void setEducation(String education) {
	this.education = education;
    }

    public String getBioData() {
	return bioData;
    }

    public void setBioData(String bioData) {
	this.bioData = bioData;
    }

}