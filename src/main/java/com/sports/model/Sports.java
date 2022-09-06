package com.sports.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Sports {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator ="sports_id_gen")
	@GenericGenerator(name="sports_id_gen", strategy = "com.sports.customidgenerator.SportsIdGenerator")
	/*@GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")	*/
	@Column
	private String sports_id;

	@Column
	public String sports_name;
	
	@Column
	public String sports_type;
	
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
	
	/*@OneToMany(mappedBy="sports")
	private Set<Coach> coach;*/
	
	public String getSports_id() {
		return sports_id;
	}

	public void setSports_id(String sports_id) {
		this.sports_id = sports_id;
	}

	public String getSports_name() {
		return sports_name;
	}

	public void setSports_name(String sports_name) {
		this.sports_name = sports_name;
	}

	public String getSports_type() {
		return sports_type;
	}

	public void setSports_type(String sports_type) {
		this.sports_type = sports_type;
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

	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sports(String sports_id, String sports_name, String sports_type, LocalDateTime created_dt, String created_by,
			LocalDateTime last_updated_dt, String last_updated_by) {
		super();
		this.sports_id = sports_id;
		this.sports_name = sports_name;
		this.sports_type = sports_type;
		this.created_dt = created_dt;
		this.created_by = created_by;
		this.last_updated_dt = last_updated_dt;
		this.last_updated_by = last_updated_by;
	}

	@Override
	public String toString() {
		return "Sports [sports_id=" + sports_id + ", sports_name=" + sports_name + ", sports_type=" + sports_type
				+ ", created_dt=" + created_dt + ", created_by=" + created_by + ", last_updated_dt=" + last_updated_dt
				+ ", last_updated_by=" + last_updated_by + "]";
	}
}
