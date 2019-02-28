package com.dm.spring.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dm.spring.shoppingbackend.dao.CategoryDAO;
import com.dm.spring.shoppingbackend.dto.Category;

@Controller
public class Pagecontroller {

	@Autowired
	private  CategoryDAO categoryDAO;
	
	
	@RequestMapping(value= { "/", "/home", "/index"})
	
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "Welcome to Spring MVC");
		mv.addObject("title", "home");
	
		//passing list of categories
		
		mv.addObject("categories",categoryDAO.list());
			
		
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	
@RequestMapping(value=  "/about")
	
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
	//	mv.addObject("greeting", "Welcome to Spring MVC");
		mv.addObject("title", "about");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	
@RequestMapping(value= "/contact")

public ModelAndView contact()
{
	ModelAndView mv = new ModelAndView("page");
	//mv.addObject("greeting", "Welcome to Spring MVC");
	mv.addObject("title", "contact");
	mv.addObject("userClickContact", true);
	return mv;
}


@RequestMapping(value= "/show/all/products")

public ModelAndView showAllProducts()
{
	ModelAndView mv = new ModelAndView("page");
	//mv.addObject("greeting", "Welcome to Spring MVC");
	mv.addObject("title", "All Products");
	mv.addObject("userClickAllProducts", true);
	return mv;
}


@RequestMapping(value= "/show/category/{id}/products")

public ModelAndView showCategoryProducts(@PathVariable("id") int id)
{
	ModelAndView mv = new ModelAndView("page");
	//mv.addObject("greeting", "Welcome to Spring MVC");
	
	
	Category category = null;
	category = categoryDAO.get(id);
	
	mv.addObject("title",category.getName());
	
	mv.addObject("categories", categoryDAO.list());
	
	mv.addObject("category", category);
	mv.addObject("userClickCategoryProducts", true);
	return mv;
}



}
	
