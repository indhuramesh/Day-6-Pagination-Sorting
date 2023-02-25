package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;

@Service

public class ApiService {
	
	@Autowired(required=true)
	
	ChildRepo cr;
	
	public Child saveDetails(Child c)
	{
		return cr.save(c);
	}
	public List<Child> getDetails()
	{
		return cr.findAll();
	}
	public List<Child> getSorted(String field)
	{
		return cr.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<Child> getWithPagination(@PathVariable int offset, @PathVariable int pageSize)
	{
		Page<Child> page=cr.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

}
