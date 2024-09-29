package dao;

import java.util.List;

import entity.Province;

public interface ProvinceDao {
	
	List<Province> getProvinces();

	Province getProvince(long id);

	void createProvince(Province province);

	void updateProvince(Province province);

	void deleteProvince(long id);

}
