package org.examples.integration.junit.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.examples.integration.dao.AbstractHibernateDAO;
import org.examples.integration.dao.GenericDAO;
import org.examples.integration.entities.Employee;
import org.examples.integration.junit.base.AbstractTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class EmployeeTest extends AbstractTestCase {
	
	 GenericDAO< Employee > dao;
	 
	   @Autowired
	   public void setDao( GenericDAO< Employee > dao){
	      this.dao = dao;
	      if(dao instanceof AbstractHibernateDAO){
	    	 ( (AbstractHibernateDAO<Employee>) dao ).setClazz(Employee.class);
	      }
	   }

	   @Test
	   public void injected_dao_should_not_be_null() {
		   assertNotNull(dao);
	   }
	   
	   @Test
	   public void should_save_employee_into_database() {
		   Employee employee = buildEmployee();
		   dao.save(employee);
		   assertNotSame(0, employee.getId());
	   }

	private Employee buildEmployee() {
		Employee emp = new Employee();
		emp.setFirstName("John");
		emp.setLastName("Smith");
		emp.setProjectName("UI-RT");
		emp.setSalary(Double.valueOf("1000"));
		return emp;
	}
}
