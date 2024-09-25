package Dao;

import java.util.List;

import Entity.District;

public interface DistrictDao {
	
	void createDistrict(District district);

	void updateDistrict(District district);

	void deleteDistrict(long id);

	District getDistrict(long id);

	List<District> getDistricts();
	
}
