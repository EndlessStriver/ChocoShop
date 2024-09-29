package service.implement;

import dao.ProvinceDao;
import entity.Province;
import service.ProvinceService;
import util.ValidatorUtil;

public class ProvinceServiceImp implements ProvinceService {

	private ProvinceDao provinceDao;

	public void setProvinceDao(ProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}

	@Override
	public void createProvince(Province province) {

		try {
			String messageError = ValidatorUtil.validatorProvince(province);

			if (messageError != null)
				throw new RuntimeException(messageError);
			provinceDao.createProvince(province);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateProvince(Province province) {
		try {
			String messageError = ValidatorUtil.validatorProvince(province);
			if (messageError != null)
				throw new RuntimeException(messageError);
			provinceDao.updateProvince(province);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteProvince(long id) {
		try {
			provinceDao.deleteProvince(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Province getProvince(long id) {
		Province province = null;
		try {
			province = provinceDao.getProvince(id);
		} catch (Exception e) {
			throw e;
		}
		return province;
	}

}
