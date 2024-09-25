package Service;

import java.util.List;

import Entity.District;

public interface DistrictService {
	
	List<District> getAllDistrict();

	District getDistrictById(long id);

	void addDistrict(District district);

	void updateDistrict(District district);

	void deleteDistrict(long id);
	
}
