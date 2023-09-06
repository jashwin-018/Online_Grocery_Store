package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceimpl implements IcustomerService{
	@Autowired
	private CustomerRepository repo;
	Customer c = null;
	@Override
	public Integer savecustomer(Customer c) {
		// TODO Auto-generated method stub
		c=repo.save(c);
		return c.getCustomerid();
	
	}
	@Override
	public List<Customer> AllCustomers() {
		// TODO Auto-generated method stub
		List x=(List) repo.findAll();
		return x;
	
	}
	@Override
	public Customer getOneCustomer(Integer id) {
		// TODO Auto-generated method stub
	java.util.Optional<Customer> opt = repo.findById(id);
		
		return opt.get();
	}
	@Override
	public Customer updatecustomer(Customer upd) {
		// TODO Auto-generated method stub
		repo.save(upd);
		return null;
	}
	

}
