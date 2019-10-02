package net.nmu.onlineshoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.nmu.onlineshoppingbackend.dao.CategoryDAO;
import net.nmu.onlineshoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		category.setId(1);
		category.setName("Telivision");
		category.setDescription("This is descp for telivisioon");
		category.setImageURL("PNG_1.png");

		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("This is descp for Laptop");
		category.setImageURL("PNG_2.png");

		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("This is descp for Mobile");
		category.setImageURL("PNG_3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
	
		for(Category category:categories)
			{if(category.getId()==id)
				return category;
			}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

}
