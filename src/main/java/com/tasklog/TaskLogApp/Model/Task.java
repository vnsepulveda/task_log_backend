package com.tasklog.TaskLogApp.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="insert_time",nullable=false)
	private LocalDateTime insert_time;
	
	@Column(name="description",nullable=false)
	@NotEmpty(message = "You need to add a description")
	private String descripcion;
	
	@Column(name="valid",nullable=false)
	private Boolean valid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getInsert_time() {
		return insert_time;
	}

	public void setInsert_time(LocalDateTime insert_time) {
		this.insert_time = insert_time;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	
}
