package Dao;

import java.util.List;

import Entity.Province;

public interface ProvinceDao {
	
	List<Province> getProvinces();

	Province getProvince(long id);

	void createProvince(Province province);

	void updateProvince(Province province);

	void deleteProvince(long id);

}
