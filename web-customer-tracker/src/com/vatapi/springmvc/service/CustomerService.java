package com.vatapi.springmvc.service;

import java.util.List;
import com.vatapi.springmvc.entity.Customer;



public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
