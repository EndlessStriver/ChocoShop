package dao;

import java.util.List;

import entity.Ward;

public interface WardDao {
	
	List<Ward> getWards();

	Ward getWard(long id);

	void CreateWard(Ward ward);

	void UpdateWard(Ward ward);

	void DeleteWard(long id);
	
}
