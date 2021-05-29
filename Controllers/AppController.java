package com.springboot.SalesManager.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.SalesManager.DAO.Sales;
import com.springboot.SalesManager.DAO.SalesDAO;
import com.springboot.SalesManager.Services.ISalesService;

@Controller

public class AppController {
	


	@Autowired
	private SalesDAO dao;
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Sales> salesList = dao.list();
		model.addAttribute("salesList",salesList);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Sales sales = new Sales();
		model.addAttribute("sales",sales);
		return "new_form";
		
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)  // referenziert die action aus dem HTML file
	public String save(@ModelAttribute("sales")Sales sales) { //hier genauso
		dao.save(sales);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_form");
	    Sales sales = dao.get(id);
	    mav.addObject("sales", sales);
	 
	    return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("sales") Sales sales) {
	    dao.update(sales);
	      
	    return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
	    dao.delete(id);
	    return "redirect:/";      
	}

}
