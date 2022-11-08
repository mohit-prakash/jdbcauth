package com.mps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

	@GetMapping("/home")
	public String showHome()
	{
		return "HomePage";
	}
	@GetMapping("/welcome")
	public String showWelcome()
	{
		return "WelcomePage";
	}
	@GetMapping("/admin")
	public String showAdmin()
	{
		return "AdminPage";
	}
	@GetMapping("/std")
	public String showStudent()
	{
		return "StudentPage";
	}
	@GetMapping("/emp")
	public String showEmp()
	{
		return "EmpPage";
	}
	//It is for Status Code:403 handling
	@GetMapping("/denied")
	public String showDenied()
	{
		return "DeniedPage";
	}
}
