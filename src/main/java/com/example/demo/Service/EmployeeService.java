package com.example.demo.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Beans.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee insertData(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}

	public List<Employee> findByEmail(String email) {
		return employeeRepository.findByEmail(email);
		 
	}

	public Employee findByEmailAndPassword(String email, String password) {
		return  employeeRepository.findByEmailAndPassword(email,password);	
		
	}
	
	public boolean uploadfile(List<MultipartFile> file) {
		boolean f = false;
		final String UPLOAD_DIR = "E:\\";
		try {
			
			int i=0;
			for(MultipartFile image:file) {
				i++;
				String tempname="abcd"+i+".jpg";
				System.out.println("Path ====> "+ Paths.get(UPLOAD_DIR+File.separator+image.getOriginalFilename()));
				System.out.println("Input Stream ======> "+ image.getInputStream());
				Files.copy(image.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+tempname), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("TempName ========> " + Paths.get(UPLOAD_DIR+File.separator+tempname));
				
			}
			f=true;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}
	
	
}
