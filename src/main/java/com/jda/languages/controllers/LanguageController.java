package com.jda.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jda.languages.models.LanguageModel;
import com.jda.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService service;
	
	public LanguageController(LanguageService service) {
		this.service = service;
	}

//	DISPLAY / CREATE ROUTES
	@RequestMapping("/languages")
	public String index(@ModelAttribute("language") LanguageModel language, Model model) {
		List<LanguageModel> languages = service.getAll();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			List<LanguageModel> languages = service.getAll();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}
		else {
			service.create(language);
			return "redirect:/languages";
		}
	}
	
//	SHOW ONE
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		LanguageModel language = service.get(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
//	EDIT ROUTES
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		LanguageModel language = service.get(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/languages/edit/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			service.update(language);
			return "redirect:/languages";
		}
	}
	
//	DELETE
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/languages";
	}
}
