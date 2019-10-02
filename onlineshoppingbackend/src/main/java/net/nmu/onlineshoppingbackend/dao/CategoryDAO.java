package net.nmu.onlineshoppingbackend.dao;

import java.util.List;

import net.nmu.onlineshoppingbackend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);
	List<Category> list();
	Category get(int id);

}
