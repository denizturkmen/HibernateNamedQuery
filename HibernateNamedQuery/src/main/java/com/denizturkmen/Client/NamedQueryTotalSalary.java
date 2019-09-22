package com.denizturkmen.Client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.denizturkmen.Util.HibernateUtil;

public class NamedQueryTotalSalary {

	public static void main(String[] args) {
		
		Session session = null;
		try {
			session =HibernateUtil.getSessionFactory().openSession();
			
			Query<Object[]> query = session.getNamedQuery("getTotalSalaryDepartment");
			List<Object[]> list = query.list();
			System.out.println("-------------------------------------------------------------------------");
			for(Object[] objects : list) {
				String departmentName =(String) objects[0];
				Double TotalSalart = (Double) objects[1];
				System.out.println("Department Name : "+departmentName);
				System.out.println("Total Salary By DepartmentName : "+TotalSalart);
				System.out.println("----------------------------------------------------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		
	}
}
