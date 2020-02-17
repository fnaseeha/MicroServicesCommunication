package com.naseeha.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naseeha.demo.entity.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Integer>{
	
	
  
}
