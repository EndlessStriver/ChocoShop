package Service.Implement;

import java.util.List;

import Dao.DistrictDao;
import Entity.District;
import Service.DistrictService;
import Util.ValidatorUtil;

public class DistrictServiceImp implements DistrictService {

	private DistrictDao districtDao;

	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}

	@Override
	public List<District> getAllDistrict() {
		List<District> districts = null;
		try {
			districts = districtDao.getDistricts();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return districts;
	}

	@Override
	public District getDistrictById(long id) {
		District district = null;
		try {
			district = districtDao.getDistrict(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return district;
	}

	@Override
	public void addDistrict(District district) {

		String messageError = ValidatorUtil.validatorDistrict(district);

		if (messageError != null) throw new RuntimeException(messageError);
		
		try {
			districtDao.createDistrict(district);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void updateDistrict(District district) {

		String messageError = ValidatorUtil.validatorDistrict(district);

		if (messageError != null) throw new RuntimeException(messageError);

		try {
			districtDao.updateDistrict(district);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void deleteDistrict(long id) {
		try {
			districtDao.deleteDistrict(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
