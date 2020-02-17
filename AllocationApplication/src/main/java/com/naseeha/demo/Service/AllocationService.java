package com.naseeha.demo.Service;

import java.util.List;

import com.naseeha.demo.entity.Allocation;

public interface AllocationService {

	
	List<Allocation> findById(Integer id);
	
	Allocation save(Allocation allocation);
	
}
