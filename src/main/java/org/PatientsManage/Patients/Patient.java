package org.PatientsManage.Patients;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Patients")
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue
    private int patientId;

    private String name;
    private String dob;
    private String email;
    private String phoneNo;
    private String appointmentDate;
    private String department;
    private String problemSubject;
    private String problemDescription;
    
    public int getPatientId() {
	return patientId;
    }

    public void setPatientId(int patientId) {
	this.patientId = patientId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDob() {
	return dob;
    }

    public void setDob(String dob) {
	this.dob = dob;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }


    public String getPhoneNo() {
	return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
    }

    public String getAppointmentDate() {
	return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
	this.appointmentDate = appointmentDate;
    }

    public String getDepartment() {
	return department;
    }

    public void setDepartment(String department) {
	this.department = department;
    }

    public String getProblemSubject() {
	return problemSubject;
    }

    public void setProblemSubject(String problemSubject) {
	this.problemSubject = problemSubject;
    }

    public String getProblemDescription() {
	return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
	this.problemDescription = problemDescription;
    }

}
