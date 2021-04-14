package com.project.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dao.UsersRepository;
import com.project.entity.Users;

@Controller
public class UsersController {
	
	@Autowired
	private UsersRepository repository1;
	
	@RequestMapping("/")
	public String indexPage(Model model) {
	
		return "home";
	}
	
	@RequestMapping("/usersForm")
	public String formPage(Model model) {
		model.addAttribute("usersmodel", new Users());
		return "user-form";
	}
	
	@RequestMapping("/usersSave")
	public String savePage(@ModelAttribute("usersmodel")Users user) {
		this.repository1.usersSave(user);
		return "redirect:/";
	}

}
