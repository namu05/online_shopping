package net.nmu.onlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.nmu.onlineshoppingbackend.dao.CategoryDAO;
import net.nmu.onlineshoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.nmu.onlineshoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	@Test
	public void testCRUDCategory() {

		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is descp for Laptop");
		category.setImageURL("PNG_1.png");

		assertEquals("Succesfully added", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Telivision");
		category.setDescription("This is descp for Telivision");
		category.setImageURL("PNG_2.png");

		assertEquals("Succesfully added", true, categoryDAO.add(category));

		category = categoryDAO.get(24);
		category.setName("TV");
		assertEquals("Succesfully fetched", true, categoryDAO.update(category));

		assertEquals("Succesfully fetched", true, categoryDAO.delete(category));

		assertEquals("Succesfully fetched", 2, categoryDAO.list().size());
	}

}
