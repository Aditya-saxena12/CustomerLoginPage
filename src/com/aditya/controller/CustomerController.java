package com.aditya.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aditya.dao.CustomerDAO;
import com.aditya.entity.Customer;
import com.aditya.entity.Login;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/")
	public String loadHome(Model theModel)
	{
		theModel.addAttribute("login",new Login());
		return "home";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin(
			@Valid @ModelAttribute("login") Login login,
			BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
			return "home";
		else
		{
			String uname=login.getUserName();
			String upass=login.getUserPass();
			if(customerDAO.checkLogin(uname, upass))
				return "redirect:list";
			else
			{
				model.addAttribute("msg","Invalid username or password");
				return "home";
			}
		}
	}
	
	@RequestMapping("/list")
	public String customerList(Model theModel)
	{
		List<Customer> theCustomers=customerDAO.getCustomers();
		theModel.addAttribute("customers", theCustomers);
		return "customer-list";
	}
	
	@RequestMapping("/showCustomer")
	public String showCustomer(Model theModel)
	{
		theModel.addAttribute("customer",new Customer());
		return "showCustomer";
	}
	@RequestMapping("/saveCust")
	public String saveCust(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
			return "showCustomer";
		else
		{
		customerDAO.saveCustomer(customer);
		return "redirect:list";
		}
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("custUpdate")Integer theId,Model model)
	{
		Customer theCustomer=customerDAO.getCustomer(theId);
		model.addAttribute("customer",theCustomer);
		return "showCustomer";
	}
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("custDelete")Integer theId)
	{
		customerDAO.deleteCustomer(theId);
		return "redirect:list";
	}
}
