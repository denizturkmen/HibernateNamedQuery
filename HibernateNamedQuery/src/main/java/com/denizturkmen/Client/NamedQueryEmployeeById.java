package com.denizturkmen.Client;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class NamedQueryEmployeeById {

	public static void main(String[] args) {
		
		int empId=2;
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query<Employee> query = session.getNamedQuery("EmployeeById");
			query.setParameter("empId", empId);
			Employee employee = query.uniqueResult();
			//System.out.println(employee.getDepartment().getDepartmentName());
			System.out.println(employee);
			
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if(session != null) {
				session.close();
			}
		}
		
	}
}
