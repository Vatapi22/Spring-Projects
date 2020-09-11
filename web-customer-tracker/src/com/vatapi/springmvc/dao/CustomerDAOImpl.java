package com.vatapi.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.vatapi.springmvc.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<Customer> getCustomers() {

		Session session = sessionfactory.getCurrentSession();
		System.out.println("creating the query");
		String sql = "from Customer";
		Query<Customer> query = session.createQuery(sql, Customer.class);
		System.out.println("query created");
		List<Customer> cusList = query.getResultList();
		
		return cusList;
		
	}

	@Override
	
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Session session = sessionfactory.getCurrentSession();
		
		session.save(customer);		
		
	}

}
