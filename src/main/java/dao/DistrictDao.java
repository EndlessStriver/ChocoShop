package dao;

import java.util.List;

import entity.District;

public interface DistrictDao {
	
	void createDistrict(District district);

	void updateDistrict(District district);

	void deleteDistrict(long id);

	District getDistrict(long id);

	List<District> getDistricts();
	
}
