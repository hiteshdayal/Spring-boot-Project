package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/* checking employee email exists */
	public List<Employee> findByEmail(String email);

	/* login user  */
	public Employee findByEmailAndPassword(String email, String password);
}
