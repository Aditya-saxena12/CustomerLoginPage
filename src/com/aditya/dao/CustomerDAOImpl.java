package com.aditya.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.entity.Customer;
import com.aditya.entity.Login;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	public SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//Create current session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//Create a query
		Query theQuery=currentSession.createQuery("from Customer",Customer.class);
		
		//Execute the Query
		List<Customer> theCustomers=theQuery.getResultList();
		
		//Returns the result
		return theCustomers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer)
	{
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Customer where custId=:theCust");
		theQuery.setParameter("theCust", theId);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public boolean checkLogin(String theUser, String thePass) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("from Login where userName=:user and userPass=:pass", Login.class);
		theQuery.setParameter("user", theUser);
		theQuery.setParameter("pass", thePass);
		List<Login> theList=theQuery.getResultList();
		if(theList.isEmpty())
			return false;
		else
			return true;
	}
}
