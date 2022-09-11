package com.jbk.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="Emp_details")
@Data
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String mobNo;
	String emailId;
	String gender;
	String department;
	String status;
	
	@Temporal(TemporalType.TIMESTAMP )
	Date createdDate;
	
	@PrePersist 
	private void onCreate() {
		createdDate=new Date();
		updateDate=new Date();
		
	}
	
	String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date updateDate;

	String updatedBy;
	@OneToOne(cascade =CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	Country country;
	
	
	
	

	
	}
	


