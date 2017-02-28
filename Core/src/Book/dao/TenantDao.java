package Book.dao;

import java.util.List;

import Book.model.Tenant;

public interface TenantDao {
	
	void save(Tenant tenant);

	void update(Tenant tenant);

	void delete(Tenant tenant);

	Tenant findOne(String id);

	List<Tenant> findAll();
}
