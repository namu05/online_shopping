package net.nmu.onlineshoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.nmu.onlineshoppingbackend.dao.ProductDAO;
import net.nmu.onlineshoppingbackend.dto.Product;



@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Product> list() {
	
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
	}

	@Override
	public Product get(int productId) {
		
		return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
	}

	@Override
	public boolean add(Product product) {
		try {

			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {

			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {

			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProduct="FROM Product WHERE active = :active";	
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveProduct,Product.class);
		query.setParameter("active",true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductByCategory="FROM Product WHERE active = :active AND categoryId =:categoryId";	
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveProductByCategory,Product.class);
		query.setParameter("active",true);
		query.setParameter("categoryId",categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String selectLatestActiveProducts="FROM Product WHERE active = :active ORDER BY id";	
		Query query=sessionFactory.getCurrentSession().createQuery(selectLatestActiveProducts,Product.class);
		query.setParameter("active",true);
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.getResultList();
	}

}
