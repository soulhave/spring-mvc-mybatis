package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dao.mapper.IUserMapper;
import com.test.domain.User;

@Controller
@RequestMapping("/article")
public class UserController {
	
	@Autowired
	IUserMapper mapper;
	
	@RequestMapping("/list")
	public String showAll(ModelMap modelMap){
		User user = mapper.getUserById(1);  
		System.out.println("list  end");
        modelMap.addAttribute("user", user);  
        return "list.jsp"; 
	}

	
	

}
