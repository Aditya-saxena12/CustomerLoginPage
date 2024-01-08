package com.aditya.dao;

import java.util.List;

import com.aditya.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(Integer theId);
	public void deleteCustomer(Integer theId);
	public boolean checkLogin(String theUser, String thePass);
}
