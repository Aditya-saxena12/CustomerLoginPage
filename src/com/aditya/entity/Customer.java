package com.aditya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@SequenceGenerator(name="ms", sequenceName="myseq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ms")
	@Column(name="cust_id")
	private Integer custId;
	
	@NotNull(message ="is required")
	@Size(min=1,message="is required")
	@Column(name="cust_name")
	private String custName;
	
	@NotNull(message ="is required")
	@Pattern(regexp="^[0-9]{10}",message="Enter 10 digits")
	@Column(name="cust_mb")
	private String custMb;
	
	@NotNull(message ="is required")
	@Email(message="Not a valid email")
	@Column(name="cust_email")
	private String custEmail;
	
	@NotNull(message ="is required")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past(message="It is Impossible")
	@Column(name="cust_date")
	private Date custDate;
	
	@NotNull(message ="is required")
	@Size(min=1,message="is required")
	@Column(name="cust_city")
	private String custCity;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMb() {
		return custMb;
	}

	public void setCustMb(String custMb) {
		this.custMb = custMb;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public Date getCustDate() {
		return custDate;
	}

	public void setCustDate(Date custDate) {
		this.custDate = custDate;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	
	
}
