package Book.dao;

import java.util.List;

import Book.model.Rent;
import Book.model.Tenancy;
import Book.model.Tenant;

public interface RentDao {

	void save(Rent rent);

	//Rent findOne(String id);

	void returnRent(Tenant tenant, Tenancy tenancy);

	List<Rent> findAll();

	List<Rent> findAll(Tenant tenant);

	List<Rent> findAll(Tenancy tenant);
}
