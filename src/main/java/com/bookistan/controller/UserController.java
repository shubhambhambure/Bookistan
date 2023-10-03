package com.bookistan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookistan.entity.User;
import com.bookistan.repository.UserRepo;
import com.bookistan.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserRepo repo;

	@Autowired
	private UserService service;

	// Login division------------------------Start-------------------------------

	User user = new User();

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("user", user);
		return "login";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/login")
	public String loginButton(@ModelAttribute("user") User user) {
		String userId = (user.getUserId());
		User pass = repo.findByUserId(userId);
		if (pass != null && user.getPassword().equals(pass.getPassword())) {
			return "redirect:/home";
		} else {
			return "error";
		}

	}
	// Login division------------------------End--------------------------------

	// New Account
	// division------------------------Start--------------------------------

	@GetMapping("/new_account")
	public String newAccount() {
		return "newAccount";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/";
	}

	@PostMapping("/saveuser")
	public String addUser(@ModelAttribute User user) {

		User oldUser = repo.findByUserId(user.getUserId());

		if (oldUser == null) {

			if (user.getPassword().equals(user.getConfirmPassword())) {
				service.saveUser(user);
				return "redirect:/";
			} else {
				return "confirmationError";
			}

		} else {
			return "existing";
		}
		
	}
	
	@GetMapping("/show_password")
	public String showPassword() {
		return "redirect:/showPassword";
	}
	
}
