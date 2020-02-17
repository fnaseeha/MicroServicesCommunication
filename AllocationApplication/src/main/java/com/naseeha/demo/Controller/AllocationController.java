package com.naseeha.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naseeha.demo.entity.Allocation;
import com.naseeha.demo.Service.AllocationServiceImpl;


@RestController
@RequestMapping("/allocation")
public class AllocationController {
	
	@Autowired
	AllocationServiceImpl allocationService; 
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Hello welcome to the 2nd application";
	}

	@RequestMapping(value = "/findbyid/{id}",method = RequestMethod.GET)
	public List<Allocation> find(@PathVariable Integer id){
		return allocationService.findById(id);
	}
	
	@RequestMapping(value = "/allocation",method = RequestMethod.POST)
	public Allocation save(@RequestBody Allocation allocation) {
		return allocationService.save(allocation);
	}
	
	@RequestMapping(value = "/all_allocation",method = RequestMethod.GET)
	public List<Allocation> getAll() {
		return allocationService.getAllAllocation();
	}
	
	
}
