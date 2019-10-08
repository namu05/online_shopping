package net.nmu.onlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.nmu.onlineshoppingbackend.dao.ProductDAO;
import net.nmu.onlineshoppingbackend.dto.Product;

public class ProductTestCase {
	
	


private static AnnotationConfigApplicationContext context;

private static ProductDAO productDAO;

private Product product;

@BeforeClass
public static void init() {
	context = new AnnotationConfigApplicationContext();
	context.scan("net.nmu.onlineshoppingbackend");
	context.refresh();
	productDAO = (ProductDAO) context.getBean("productDAO");

}

  @Test public void testCRUDProduct() {
  
  product = new Product(); product.setName("Oppo Selfie S53");
  product.setBrand("Oppo");
  product.setDescription("This is descp for Oppo Mobile Phones");
  product.setUnitPrice(25000); product.setCategoryId(3);
  product.setActive(true); product.setSupplierId(3);
  
  
  assertEquals("Something added", true, productDAO.add(product));
  
  product = productDAO.get(2); product.setName("Samsung Galaxy S7");
  assertEquals("Succesfully updated", true, productDAO.update(product));
  
  assertEquals("Succesfully fetched", true, productDAO.delete(product));
  
  assertEquals("Succesfully fetched", 6, productDAO.list().size());
  
  }
 

	
	  @Test public void TestListActiveProducts() {
	  assertEquals("Succesfully fetched", 5,
	  productDAO.listActiveProducts().size());
	  
	  }
	 
	
	  @Test public void TestListActiveProductsByCategory() {
	  assertEquals("Succesfully fetched", 3,
	  productDAO.listActiveProductsByCategory(3).size());
	  assertEquals("Succesfully fetched", 2,
	  productDAO.listActiveProductsByCategory(1).size()); }
	 

@Test public void TestLatestActiveProductsByCategory() {
	 assertEquals("Succesfully fetched", 3,	 productDAO.getLatestActiveProducts(3).size()); 
 }

}