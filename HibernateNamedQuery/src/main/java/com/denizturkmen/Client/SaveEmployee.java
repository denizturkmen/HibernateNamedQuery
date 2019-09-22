package com.denizturkmen.Client;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import com.denizturkmen.Entity.Department;
import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class SaveEmployee {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();

			Employee employee = new Employee();
			employee.setEmployeeName("Deniz TÜRKMEN");
			employee.setDoj(new Date());
			employee.setEmail("turkmen@gmail.com");
			employee.setSalary(455645D);
			employee.setBonus(new BigDecimal(56465465));
			employee.setDesignation("JUNİOR");

			Employee employee1 = new Employee();
			employee1.setEmployeeName("Eren TÜRKMEN");
			employee1.setDoj(new Date());
			employee1.setEmail("eren@gmail.com");
			employee1.setSalary(752D);
			employee1.setBonus(new BigDecimal(423));
			employee1.setDesignation("SENOR");

			Department department = new Department();
			department.setDepartmentName("IT MANAGER");
			department.setDepartmentLocation("Ankara");
			
			department.getEmployees().add(employee);
			department.getEmployees().add(employee1);
			
			employee.setDepartment(department);
			employee1.setDepartment(department);
			
			session.save(department);
			
			Employee employee2 = new Employee();
			employee2.setEmployeeName("Besra TÜRKMEN");
			employee2.setEmail("besra@gmail.com");
			employee2.setSalary(64564D);
			employee2.setDoj(new Date());
			employee2.setBonus(new BigDecimal(4353));
			employee2.setDesignation("IKTISAT");

			Employee employee3 = new Employee();
			employee3.setEmployeeName("Emre TÜRKMEN");
			employee3.setEmail("emre@gmail.com");
			employee3.setSalary(342143D);
			employee3.setDoj(new Date());
			employee3.setBonus(new BigDecimal(8678));
			employee3.setDesignation("COGRAFYA");

			Employee employee4 = new Employee();
			employee4.setEmployeeName("HABİB TÜRKMEN");
			employee4.setEmail("habib@gmail.com");
			employee4.setSalary(45235D);
			employee4.setDoj(new Date());
			employee4.setBonus(new BigDecimal(876586));
			employee4.setDesignation("Elektrik");

		

			Department department1 = new Department();
			department1.setDepartmentName("Network MANAGER");
			department1.setDepartmentLocation("Istanbul");

		
			department1.getEmployees().add(employee2);
			department1.getEmployees().add(employee3);
			department1.getEmployees().add(employee4);

			employee2.setDepartment(department1);
			employee3.setDepartment(department1);
			employee4.setDepartment(department1);

			session.save(department1);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
