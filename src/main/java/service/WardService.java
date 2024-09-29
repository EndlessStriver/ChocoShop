package service;

import java.util.List;

import entity.Ward;

public interface WardService {
	
	List<Ward> getAllWards();

	Ward getWard(int id);

	void createWard(Ward ward);

	void updateWard(Ward ward);

	void deleteWard(int id);
}
