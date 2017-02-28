package Book.dao;

import java.util.List;

import Book.model.Tenancy;

public interface TenancyDao {
	
	void save(Tenancy tenant);

	void update(Tenancy tenant);

	void delete(Tenancy tenant);

	Tenancy findOne(String id);

	List<Tenancy> findAll();
}
