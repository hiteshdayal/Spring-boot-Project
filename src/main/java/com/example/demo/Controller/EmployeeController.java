package com.example.demo.Controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Beans.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
//@RequestMapping("Employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/register")
    public ModelAndView registerForm () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("employee") Employee employee) {
		
	    String msg=null;
	    int count=0;
		System.out.println(employee);
		System.out.println("data from database ============>");
		Iterable<Employee> itr = employeeService.findByEmail(employee.getEmail());
		
		for(Employee data: itr) {
			if(data.getEmail().equalsIgnoreCase(employee.getEmail())) {
				System.out.println(data.getEmail());
				System.out.println();
				msg = "Employee Already Registered";
				count++;
			}
			
		}
		
		if(count == 0) {
			Employee emp = employeeService.insertData(employee);
			System.out.println(emp);
			if(emp.getId() != 0) {
				msg = "Employee Registered";
			}
			else {
				msg = "Failed to register";
			}
		}
		
		return msg;
		
		
	}
	

	@RequestMapping("/login")
    public ModelAndView loginForm () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
	@RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		String msg=null;
		Employee employee = employeeService.findByEmailAndPassword(email,password);
			System.out.println(employee);
			if(employee!=null) {
				session.setAttribute("employeedata", employee); // setting employee data to session
				System.out.println();
				//System.out.println(session.getAttribute("employeedata"));
				msg = "logged in";
			}
			else {
				msg = "Invalid Credentials";
			}
		return msg;
	}
	
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public ModelAndView imageroute() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("imageupload");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
	public String uploadimage(@RequestParam("status") int status, @RequestParam("bugid") int bugid, @RequestParam("img") List<MultipartFile>  image ) {
		
		System.out.println(status +" "+ bugid +" "+ image);
		//System.out.println(image.getContentType() +" "+image.getName() +" "+image.getOriginalFilename() +" "+image.getSize());
		
		System.out.println(image.size());
		for(MultipartFile file: image) {
			System.out.println(file);
		}
		
		
		try {
			boolean f = employeeService.uploadfile(image);
			if(f) {
				return "uploaded";
			}
			else {
				return "failed";
			}
			
		}
		catch(Exception e) {
			
		}
		
		
		
		return "success";
	}
	
	
	@RequestMapping(value = "/bugform", method = RequestMethod.GET)
	public ModelAndView bugform() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bug");
		return modelAndView;
	}
	
	
	
	
	
	
	/*
	@RequestMapping(value = "/tester", method = RequestMethod.GET)
	public String getData(@RequestParam("name") String name) {
		
		return "from test controller "+ name+" hscbh";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public String data() {
		
		return "from read route";
	}*/
	/*
	@RequestMapping("/test")
	public ModelAndView set () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("test");
	    return modelAndView;
	}*/
	
	
	
}
