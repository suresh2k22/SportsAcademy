package com.sports.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Coach {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String coach_id;

	@Column
	public String name;
	
	@Column
	public String address;	

	@Column
	@CreationTimestamp
	public LocalDateTime created_dt;
	
	@Column
	public String created_by;
	
	@Column
	@CreationTimestamp
	public LocalDateTime last_updated_dt;
	
	@Column
	public String last_updated_by;
	
	@Column
	public String user_id;
	
	/*@ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private BusinessOwner businessOwner;*/

	@ManyToOne()
    @JoinColumn(name = "sports_id", referencedColumnName = "sports_id")
	private Sports sports;

	/*public BusinessOwner getBusinessOwner() {
		return businessOwner;
	}

	public void setBusinessOwner(BusinessOwner businessOwner) {
		this.businessOwner = businessOwner;
	}*/
	
	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}

	public String getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}
	
	

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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


	public LocalDateTime getCreated_dt() {
		return created_dt;
	}

	public void setCreated_dt(LocalDateTime created_dt) {
		this.created_dt = created_dt;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public LocalDateTime getLast_updated_dt() {
		return last_updated_dt;
	}

	public void setLast_updated_dt(LocalDateTime last_updated_dt) {
		this.last_updated_dt = last_updated_dt;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}	

	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coach(String coach_id, String name, String address, LocalDateTime created_dt, String created_by, LocalDateTime last_updated_dt, String last_updated_by) {
		super();
		this.coach_id = coach_id;
		this.name = name;
		this.address = address;		
		this.created_dt = created_dt;
		this.created_by = created_by;
		this.last_updated_dt = last_updated_dt;
		this.last_updated_by = last_updated_by;
	}

	@Override
	public String toString() {
		return "Coach [coach_id=" + coach_id + ", name=" + name + ", address=" + address + ", created_dt=" + created_dt + ", created_by=" + created_by
				+ ", last_updated_dt=" + last_updated_dt + ", last_updated_by=" + last_updated_by + "]";
	}
}
