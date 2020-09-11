package com.vatapi.springmvc.dao;

import java.util.List;

import com.vatapi.springmvc.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
