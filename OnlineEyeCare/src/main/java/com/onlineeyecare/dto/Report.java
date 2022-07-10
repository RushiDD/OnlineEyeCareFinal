package com.onlineeyecare.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Report implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	private int reportId;
	
	private LocalDateTime dateOfReport;
	private String descriptionOfReport;
	private String visualAcuity;
	private String visualAcuityNear;
	private String visualAcuityDistance;
	
	@OneToOne
	@JoinColumn(name = "test_id")
	private TestModule typeOfTest;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patientId;
	
	public Report() {
		super();
	}
	

	public Report(int reportId, LocalDateTime dateOfReport, String descriptionOfReport, String visualAcuity,
				String visualAcuityNear, String visualAcuityDistance) {
			super();
			this.reportId = reportId;
			this.dateOfReport = dateOfReport;
			this.descriptionOfReport = descriptionOfReport;
			this.visualAcuity = visualAcuity;
			this.visualAcuityNear = visualAcuityNear;
			this.visualAcuityDistance = visualAcuityDistance;
		
	}
     
    public int getReportId() {
	   return reportId;
    }

    public void setReportId(int reportId) {
    	this.reportId = reportId;
    }

    public LocalDateTime getDateOfReport() {
	   return dateOfReport;
    }

    public void setDateOfReport(LocalDateTime dateOfReport) {
	   this.dateOfReport = dateOfReport;
    }
    
    public String getDescriptionOfReport() {
	   return descriptionOfReport;
    }

    public void setDescriptionOfReport(String descriptionOfReport) {
	   this.descriptionOfReport = descriptionOfReport;
    }

    public String getVisualAcuity() {
	    return visualAcuity;
    }

    public void setVisualAcuity(String visualAcuity) {
	   this.visualAcuity = visualAcuity;
    }

    public String getVisualAcuityNear() {
	   return visualAcuityNear;
    }

    public void setVisualAcuityNear(String visualAcuityNear) {
	  this.visualAcuityNear = visualAcuityNear;
    }

    public String getVisualAcuityDistance() {
	    return visualAcuityDistance;
    }

    public void setVisualAcuityDistance(String visualAcuityDistance) {
    	 this.visualAcuityDistance = visualAcuityDistance;
    }
      
    @Override
    public String toString() {
	return "Report [reportId=" + reportId + ", dateOfReport=" + dateOfReport + ", descriptionOfReport="
			+ descriptionOfReport + ", visualAcuity=" + visualAcuity + ", visualAcuityNear=" + visualAcuityNear
			+ ", visualAcuityDistance=" + visualAcuityDistance +   "]";
    }

	public LocalDateTime getDateOfReport1() {
		return null;
	}

	public Patient getPatientId() {
		return null;
	}
}
