package Service.Implement;

import Dao.ProvinceDao;
import Entity.Province;
import Service.ProvinceService;
import Util.ValidatorUtil;

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
			throw new RuntimeException(e.getMessage());
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
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void deleteProvince(long id) {
		try {
			provinceDao.deleteProvince(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Province getProvince(long id) {
		Province province = null;
		try {
			province = provinceDao.getProvince(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return province;
	}

}
