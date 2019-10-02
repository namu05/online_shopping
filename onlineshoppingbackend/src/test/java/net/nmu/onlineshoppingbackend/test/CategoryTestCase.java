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
	public void testAddCategory() {
		category = new Category();
		category.setId(1);
		category.setName("Telivision");
		category.setDescription("This is descp for telivisioon");
		category.setImageURL("PNG_1.png");
		
		
		assertEquals("Succesfully added", true, categoryDAO.add(category));

	}
}
