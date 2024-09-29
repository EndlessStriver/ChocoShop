package service.implement;

import java.util.List;

import entity.Ward;
import service.WardService;

public class WardServiceImp implements WardService {

	private WardService wardService;

	public WardServiceImp(WardService wardService) {
		this.wardService = wardService;
	}

	@Override
	public List<Ward> getAllWards() {
		List<Ward> wards = null;
		try {
			wards = wardService.getAllWards();
		} catch (Exception e) {
			throw e;
		}
		return wards;
	}

	@Override
	public Ward getWard(int id) {
		Ward ward = null;
		try {
			ward = wardService.getWard(id);
		} catch (Exception e) {
			throw e;
		}
		return ward;
	}

	@Override
	public void createWard(Ward ward) {
		try {
			wardService.createWard(ward);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateWard(Ward ward) {
		try {
			wardService.updateWard(ward);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteWard(int id) {
		try {
			wardService.deleteWard(id);
		} catch (Exception e) {
			throw e;
		}
	}

}
