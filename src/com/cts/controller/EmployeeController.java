package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.cts.Dao.EmployeeDao;

import com.cts.Entity.Employee;
import com.cts.Entity.Login;
import com.cts.service.EmployeeService;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired 
	public EmployeeDao employeeDao;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	private String indexPage() {
		return "index";
	}
	
	
	  @RequestMapping(value = "/registerpage", method = RequestMethod.GET)
	  public ModelAndView showRegister() {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("employee", new Employee());
	    
	    return mav;
	  }
	  
	  @RequestMapping(value="myProfile",method=RequestMethod.GET)
		private String myProfilePage() {
			return "myProfile";
		}
	  
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin() {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	  
	  @RequestMapping(value="searchEmployee",method=RequestMethod.GET)
		private String searchEmployeePage() {
			return "searchEmployee";
		}
	  
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(@ModelAttribute("employee") Employee employee) throws Exception {
	  employeeService.registerUser(employee);
	  return new ModelAndView("hello", "Name", employee.getFirstname());
	  }
	
	  @RequestMapping(value = "/myProfile", method = RequestMethod.POST)
	  public ModelAndView myProfile(@ModelAttribute("employee") Employee employee) throws Exception {
	    ModelAndView mav = null;
	    
	   
	    mav = new ModelAndView("myProfile");
	    mav.addObject("EmpId", employee.getEmpid());
	    mav.addObject("FistName", employee.getFirstname());
	    mav.addObject("EmpId", employee.getLastname());
	    mav.addObject("EmpId", employee.getUsername());
	    mav.addObject("EmpId", employee.getExpertise());
	    mav.addObject("EmpId", employee.getDesignation());
	    return mav;
	  }
	
	
	
	 
	  
	  @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	  public ModelAndView loginProcess(@ModelAttribute("login") Login login) throws Exception {
	    ModelAndView mav = null;
	    Employee employee = employeeService.validateUser(login);
	    if (null != employee) {
	    mav = new ModelAndView("hello");
	    mav.addObject("Name", employee.getFirstname());
	    } 
	    return mav;
	  }
	  
	 
	  
	  @RequestMapping(value="/viewbyid",method = RequestMethod.POST)    
	    public String viewById(@ModelAttribute("employee") Employee employee, Model m){    
	    	
			
	    	 List<Employee> list = employeeDao.getEmployeeById(employee.getEmpid());  
	     
	    	  m.addAttribute("list",list); 
	       
	        return "";    
	    } 
		
		
	

}
