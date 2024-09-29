package service;

import entity.Province;

public interface ProvinceService {
	
	void createProvince(Province province);

	void updateProvince(Province province);

	void deleteProvince(long id);
	
	Province getProvince(long id);
	
}
