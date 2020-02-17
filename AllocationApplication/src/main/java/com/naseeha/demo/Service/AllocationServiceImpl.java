package com.naseeha.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.naseeha.demo.entity.Allocation;
import com.naseeha.demo.repository.AllocationRepository;

@Service
public class AllocationServiceImpl implements AllocationService{

	@Autowired
	AllocationRepository Allocationrepo;
	
	@Override
	public List<Allocation> findById(Integer id) {
		
		Allocation allocation = new Allocation();
		
		allocation.setEmployeeid(id);
		
		Example<Allocation> employeeExample = Example.of(allocation);
		
		return Allocationrepo.findAll(employeeExample);
		
	}

	@Override
	public Allocation save(Allocation allocation) {
		
		return Allocationrepo.save(allocation);
	}

	public List<Allocation> getAllAllocation(){
		return Allocationrepo.findAll();
	}
	
}
