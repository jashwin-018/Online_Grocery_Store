package com.example.demo;

import java.util.List;

public interface IcustomerService {
	public Integer savecustomer(Customer c);
	public List<Customer> AllCustomers();
	public Customer getOneCustomer(Integer id); 
	public Customer updatecustomer(Customer upd);
}
