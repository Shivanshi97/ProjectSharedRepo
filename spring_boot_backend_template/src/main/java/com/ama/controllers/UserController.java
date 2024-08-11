package com.ama.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ama.entities.Role;
import com.ama.entities.User;
import com.ama.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

	//DI service
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/register")
	public String processRegistration(@RequestBody User newUser, Model map, HttpSession session) {
		
		System.out.println("in process login form " + newUser);
		try {
			User user = userService.registration(newUser);
			session.setAttribute("message", "Registration Successful");
			session.setAttribute("user_details", user);
			
			return "/users/login";
		}
		catch (RuntimeException e) {
			System.out.println("err " + e);
			
			map.addAttribute("message", e.getMessage());
			return "/users/register";// AVN : /WEB-INF/views/users/login.jsp

		}
	}
	
	@PostMapping("/login")
	public String processLoginform(@RequestParam String email, @RequestParam String password, Model map, HttpSession session) {
		
		System.out.println("in process login form " + email + " " + password);
		try {
			// invoke service layer method
			User user = userService.login(email, password);
			// => login successful
			// add user details n message -- under model attribute
			session.setAttribute("message", "Login Successful");
			session.setAttribute("user_details", user);
			// chk the role --in case of admin -- forward the clnt admin home page
			if (user.getRole() == Role.ROLE_ADMIN)
				return "redirect:/admin/home";
			/*
			 * SC -- redirect + URL encoding
			 * Next URL -- http://host:port/spring_boot/admin/home
			 */
			// o.w -- in case of blogger -- forward the clnt blogger home page
			return "redirect:/blogger/home";
			/*
			 * SC -- redirect + URL encoding
			 * Next URL -- http://host:port/spring_boot/blogger/home
			 */

		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// => invalid login , forward the clnt to the login form
			// , highlighted with errs
			map.addAttribute("message", e.getMessage());
			return "/users/login";// AVN : /WEB-INF/views/users/login.jsp
		}
	}
}
