package com.vatapi.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vatapi.springmvc.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<Customer> getCustomers() {

		Session session = sessionfactory.getCurrentSession();
		String sql = "from Customer";
		Query<Customer> query = session.createQuery(sql, Customer.class);
		List<Customer> cusList = query.getResultList();
		
		return cusList;
		
	}

	@Override
	
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(customer);		
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session = sessionfactory.getCurrentSession();
		Customer customer= session.get(Customer.class, id);
//		if(customer!=null)
		return customer;
		
		
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
	}

}
