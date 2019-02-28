package com.dm.spring.shoppingbackend.dao;

import java.util.List;

import com.dm.spring.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	List<Category>  list();
	Category get(int id);
}
