package ua.com.shop.dao;

import java.util.List;

public interface ShopDao<T> {

	void save(T t);

	List<T> findAll();

	T findOne(String title);

	void delete(String title);

}
