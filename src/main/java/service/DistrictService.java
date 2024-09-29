package service;

import java.util.List;

import entity.District;

public interface DistrictService {
	
	List<District> getAllDistrict();

	District getDistrictById(long id);

	void addDistrict(District district);

	void updateDistrict(District district);

	void deleteDistrict(long id);
	
}
