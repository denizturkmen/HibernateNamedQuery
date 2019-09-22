package com.denizturkmen.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department_table")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Department_Id")
	private Integer departmentId;
	
	@Column(name="DepartmentName")
	private String departmentName;
	
	@Column(name="DepartmentLocation")
	private String departmentLocation;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department")
	private Set<Employee> employees = new HashSet<Employee>();

	
	
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}



	
	
}
