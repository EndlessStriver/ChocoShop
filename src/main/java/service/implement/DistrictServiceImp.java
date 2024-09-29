package service.implement;

import java.util.List;

import dao.DistrictDao;
import entity.District;
import service.DistrictService;
import util.ValidatorUtil;

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
			throw e;
		}
		return districts;
	}

	@Override
	public District getDistrictById(long id) {
		District district = null;
		try {
			district = districtDao.getDistrict(id);
		} catch (Exception e) {
			throw e;
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
			throw e;
		}
	}

	@Override
	public void updateDistrict(District district) {

		String messageError = ValidatorUtil.validatorDistrict(district);

		if (messageError != null) throw new RuntimeException(messageError);

		try {
			districtDao.updateDistrict(district);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteDistrict(long id) {
		try {
			districtDao.deleteDistrict(id);
		} catch (Exception e) {
			throw e;
		}
	}

}
