package com.project.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dao.AngestellteRepositroy;
import com.project.entity.Angestellte;

@Controller
public class AngestellteController {
	
	@Autowired
	private AngestellteRepositroy repository5;
	
	@RequestMapping("/angstForm")
	public String angestellteForm(Model model) {
	 model.addAttribute("angstmodel", new Angestellte());
		return "angestellte-form";
	}
	
	@RequestMapping("/angstinfo")
	public String angestellteInfo(Model model) {
		List<Angestellte> list=this.repository5.angestellteListAll();
		model.addAttribute("angstlist", list);
		return "angestellte-info";
	}
	
	@RequestMapping("/angstSave")
	public String angestellteSave(@ModelAttribute("angstmodel") Angestellte angst) {
		if(angst.getId()!=null) {
			this.repository5.angestellteUpdate(angst);
		}else {
			this.repository5.angestellteSave(angst);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String angstDelete(@PathVariable("id")Integer id) {
		this.repository5.angestellteDelete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/update/{id}")
	public String angstUpdate(@PathVariable("id")Integer id,Model model) {
		Angestellte angst=this.repository5.angestellteFindById(id);
		model.addAttribute("angstmodel", angst);
		return "angestellte-form";
	}

}
