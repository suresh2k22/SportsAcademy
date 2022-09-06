package com.sports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int parent_id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String ssn_no;
	
	@ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private BusinessOwner businessOwner;

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSsn_no() {
		return ssn_no;
	}

	public void setSsn_no(String ssn_no) {
		this.ssn_no = ssn_no;
	}

	public BusinessOwner getBusinessOwner() {
		return businessOwner;
	}

	public void setBusinessOwner(BusinessOwner businessOwner) {
		this.businessOwner = businessOwner;
	}

	

}