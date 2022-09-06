package com.sports.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class BusinessOwner {

	@Id
	//@Column
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String user_id;
	@OneToMany()
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<Coach> coach;

	public List<Coach> getCoach() {
		return coach;
	}

	public void setCoach(List<Coach> coach) {
		this.coach = coach;
	}

	@Column
	public String password;

	@Column
	public Boolean is_admin;

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

	public BusinessOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessOwner(String user_id, String password, Boolean is_admin, LocalDateTime created_dt, String created_by,
			LocalDateTime last_updated_dt, String last_updated_by) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.is_admin = is_admin;
		this.created_dt = created_dt;
		this.created_by = created_by;
		this.last_updated_dt = last_updated_dt;
		this.last_updated_by = last_updated_by;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(Boolean is_admin) {
		this.is_admin = is_admin;
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

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password + ", is_admin=" + is_admin + ", created_dt="
				+ created_dt + ", created_by=" + created_by + ", last_updated_dt=" + last_updated_dt
				+ ", last_updated_by=" + last_updated_by + "]";
	}	
}
